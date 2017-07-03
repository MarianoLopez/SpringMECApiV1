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
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    private List<LuTrab> todos = new ArrayList<>();
    
    //@Scheduled(fixedRate = 600000)//10min en ms
    private void getAllEstablecimientos() {
        long startTime = System.currentTimeMillis();
        List<LuTrab> aux = getAll(true);
        this.todos = aux;
        long endTime = System.currentTimeMillis();
        System.out.println("getAllScheduled() listo -->"+(endTime - startTime)/1000.0+" segundos");
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
