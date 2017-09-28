/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;
import com.mec.Criteria.*;
import com.mec.DAO.EdificioDAO;
import com.mec.DAO.EstablecimientoDAO;
import com.mec.DAO.GeoDAO;
import com.mec.DAO.LuTrabDAO;
import com.mec.models.GE.Establecimiento;
import com.mec.models.Pof2.Geoposicion;
import com.mec.models.Pof2.LuTrab;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarianoLopez
 */
@Service
public class LuTrabService{
    @Autowired
    private LuTrabDAO luTrabDAO;
    @Autowired
    private GeoDAO geoDAO;
    @Autowired
    private EdificioDAO edificioDAO;
    @Autowired
    private EstablecimientoDAO establecimientoDAO;
    @Autowired
    @Qualifier(value="dataGE")
    private DataSource ds;
    
    private List<LuTrab> todos = new ArrayList<>();
    
    //@Scheduled(fixedRate = 600000)//10min en ms
    private void getAllEstablecimientos() {
        long startTime = System.currentTimeMillis();
        List<LuTrab> aux = getAll(true);
        this.todos = aux;
        long endTime = System.currentTimeMillis();
        System.out.println("Pof/GE getAllEstablecimientos() listo -->"+(endTime - startTime)/1000.0+" segundos");
    }
    
    public List<LuTrab> getAll(){return this.todos;}
    
     public List<LuTrab> getAll(boolean geo){
        List<LuTrab> lugares =  luTrabDAO.getAll();
        if(geo){initGeoAndEdificios(lugares);}
        return lugares;
    }
    
    public LuTrab getByCueAnexo(int Cue,int Anexo){
        LuTrab l = luTrabDAO.getByCueAnexo(Cue,Anexo);
        if(l!=null){
            Geoposicion geo = geoDAO.getByCueAnexo(Cue, Anexo);
            l.setGeo(geo);
            initEdificio(l);
        }
        return l;
    }
    public List<LuTrab> getByFilter(List<Integer> cues){
        List<LuTrab> todo = this.getAll();
        if(cues!=null){
            todo = new CueAnexoCriteria().filterCriteria(todos, cues);
        }
        return todo;
    }
    public List<LuTrab> getByFilter(Integer[] modalidades,Integer[] regimenes,Integer[] jurisdicciones,Integer[] departamentos,Integer[] localidades,Integer[] ambitos){
        List<LuTrab> todo = this.getAll();
        if(modalidades!=null){
            todo = new ModalidadCriteria().filterCriteria(todo, modalidades);
        }
        if(regimenes!=null){
            todo = new RegimenCriteria().filterCriteria(todo, regimenes);
        }
        if(jurisdicciones!=null){
            todo = new JurisdiccionCriteria().filterCriteria(todo, jurisdicciones);
        }
        if(departamentos!=null){
            todo = new DepartamentoCriteria().filterCriteria(todo, departamentos);
        }
        if(localidades!=null){
            todo = new LocalidadCriteria().filterCriteria(todo, localidades);
        }
        if(ambitos!=null){
            todo = new AmbitoCriteria().filterCriteria(todo,ambitos);
        }
        return todo;
    }
    
    public List<LuTrab> getEstablecimientoByPlanEstudio(String arg){
        SimpleJdbcCall jdbcCall =  new SimpleJdbcCall(ds)
                 .withCatalogName("dbo")
                 .withProcedureName("traerPlanesMaterias")
                 .withoutProcedureColumnMetaDataAccess()
                 .declareParameters(new SqlParameter("arg", Types.VARCHAR));
        SqlParameterSource in = new MapSqlParameterSource().addValue("arg", arg);
        Map<String,Object> r = jdbcCall.execute(in);
        List<Integer> cues = new ArrayList<>();
        Iterator it = r.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            for(Object v:(ArrayList)e.getValue()){
                for(Map.Entry<String,Object> entry:((Map<String,Object>)v).entrySet()){
                    if(entry.getKey().equals("CUE")){
                        cues.add(Integer.valueOf((String)entry.getValue()));
                    }
                }
            }
        }//while
        return getByFilter(cues);
    }
 
    private void initGeoAndEdificios(List<LuTrab> lugares){
        lugares.parallelStream().forEach((lugar)->{
            lugar.setGeo(geoDAO.getByCueAnexo(lugar.getCue(),lugar.getAnexo()));
            initEdificio(lugar);
        });
    }
    
    private void initEdificio(LuTrab lugar){
        Establecimiento e = establecimientoDAO.getByCueAnexoLuTrab(lugar.getCue(), lugar.getAnexo(),lugar.getLuTrab());
        if(e!=null){
            lugar.setEdificios(edificioDAO.getByEstablecimientoId(e.getEstablecimientoId()));
        }
    }
}
