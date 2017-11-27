/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.Criteria.ConexionesEscuelas.InternetCriteria;
import com.mec.Criteria.ConexionesEscuelas.TipoConexionCriteria;
import com.mec.Criteria.Padron.AmbitoCriteria;
import com.mec.Criteria.Padron.CategoriaCriteria;
import com.mec.Criteria.Padron.DepartamentoCriteria;
import com.mec.Criteria.Padron.DependenciaCriteria;
import com.mec.Criteria.Padron.EstadoCriteria;
import com.mec.Criteria.Padron.JornadaCriteria;
import com.mec.Criteria.Padron.LocalidadCriteria;
import com.mec.Criteria.Padron.ModalidadCriteria;
import com.mec.Criteria.Padron.OfertaBaseCriteria;
import com.mec.Criteria.Padron.OfertaCriteria;
import com.mec.Criteria.Padron.SectorCriteria;
import com.mec.DAO.ConexionesEscuelas.ConexionesDAO;
import com.mec.DAO.ConexionesEscuelas.ElectricidadDAO;
import com.mec.DAO.Postgre.EstablecimientoPostgreDAO;
import com.mec.DAO.POF2.GeoDAO;
import com.mec.Util.EstablecimientoDTO;
import com.mec.Models.Padron.EstablecimientoPost;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
//import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author 36194445
 */
@Service
public class EstablecimientosService {
    @Autowired private GeoDAO geoDAO;
    @Autowired private EstablecimientoPostgreDAO establecimientoDAO;
    @Autowired private ConexionesDAO conexionesEstablecimientosDAO;
    @Autowired private ElectricidadDAO electricidadEstablecimientosDAO;

    private List<EstablecimientoPost> todos = new ArrayList<>();//cache
    private Map<String,List<EstablecimientoDTO>> DTO = new HashMap<>();//index

    

    public EstablecimientoPost getByCue(int Cue){
        EstablecimientoPost est =  establecimientoDAO.getByCue(Cue);
        setGeoAndConexiones(est);
        return est;
    }
    public EstablecimientoPost getByCueAnexo(int Cue, int Anexo){
        EstablecimientoPost est = establecimientoDAO.getByCueAnexo(Cue, Anexo);
        setGeoAndConexiones(est);
        return est;
    }

     public List<EstablecimientoPost> getByFilter(Integer[] ambitos,Integer[] categorias,Integer[] dependencias,
                                                    Integer[] estados,Integer[] sectores,Integer[] departamentos,Integer[] localidades,
                                                    Integer[] ofertas,Integer[] jornadas,Integer[] modalidades,Integer[] bases,
                                                    Boolean state,Integer[]conexiones){
        List<EstablecimientoPost> todo = this.getAll();
        if(ambitos!=null){
            todo = new AmbitoCriteria().filterCriteria(todo, ambitos);
        }
        if(categorias!=null){
            todo = new CategoriaCriteria().filterCriteria(todo, categorias);
        }
        if(dependencias!=null){
            todo = new DependenciaCriteria().filterCriteria(todo, dependencias);
        }
        if(estados!=null){
            todo = new EstadoCriteria().filterCriteria(todo, estados);
        }
        if(sectores!=null){
            todo = new SectorCriteria().filterCriteria(todo, sectores);
        }
        if(departamentos!=null){
            todo = new DepartamentoCriteria().filterCriteria(todo,departamentos);
        }
        if(localidades!=null){
            todo = new LocalidadCriteria().filterCriteria(todo,localidades);
        }
        if(ofertas!=null){
            todo = new OfertaCriteria().filterCriteria(todo,ofertas);
        }
        if(jornadas!=null){
            todo = new JornadaCriteria().filterCriteria(todo,jornadas);
        }
        if(modalidades!=null){
            todo = new ModalidadCriteria().filterCriteria(todo,modalidades);
        }
        if(bases!=null){
            todo = new OfertaBaseCriteria().filterCriteria(todo,bases);
        }
        if(state!=null){
            todo = InternetCriteria.filterCriteria(todo,state);
        }
        if(conexiones!=null){
            todo = new TipoConexionCriteria().filterCriteria(todo,conexiones);
        }
        return todo;
    }
     
    //cache task
    @Scheduled(fixedRate = 600000)//10min en ms
    public void getAllEstablecimientos() {
        long startTime = System.currentTimeMillis();
        List<EstablecimientoPost> aux = establecimientoDAO.getAll();
        initCollections(aux);
        this.todos = aux;
        long endTime = System.currentTimeMillis();
        System.out.println("getAllEstablecimientos() listo -->"+(endTime - startTime)/1000.0+" segundos");
        this.toDTO(this.todos);
    }
    //create index map
    private void toDTO(List<EstablecimientoPost> establecimientos){
        Map<String,List<EstablecimientoDTO>> _DTO = new HashMap<>();
        establecimientos.forEach(est->{
            est.getLocalizacion().forEach(anexo->{
                EstablecimientoDTO holder =  new EstablecimientoDTO(anexo.getNombre(), anexo.getAnexo());
                if(!_DTO.containsKey(est.getCue())){
                    _DTO.put(est.getCue(), new ArrayList(){{add(holder);}});
                }else{
                    _DTO.get(est.getCue()).add(holder);
                }
            });
        });
        this.DTO = _DTO;
    }

    private void initCollections(List<EstablecimientoPost> establecimientos){
        establecimientos.parallelStream().forEach((establecimiento)->{
            this.setGeoAndConexiones(establecimiento);
        });
    }
    
    private void setGeoAndConexiones(EstablecimientoPost establecimiento){
        establecimiento.getLocalizacion().forEach((loc) -> {
                loc.setConexiones(conexionesEstablecimientosDAO.getByCueAnexo(establecimiento.getCue(), Short.parseShort(loc.getAnexo())));
                loc.setElectricidad(electricidadEstablecimientosDAO.getByCueAnexo(establecimiento.getCue(), Short.parseShort(loc.getAnexo())));
                loc.getDomicilios().forEach((dom) -> {
                   try{
                        dom.setGeo(geoDAO.getByCueAnexo(Integer.parseInt(establecimiento.getCue()), Integer.parseInt(loc.getAnexo())));
                    }catch(NumberFormatException e){
                        System.out.println("NumberFormatException: "+e.toString());
                    } 
                });
            });   
    }
    public Map<String, List<EstablecimientoDTO>> getDTO() {
        return DTO;
    }
    public List<EstablecimientoPost> getAll(){
        return this.todos;
    }
}
