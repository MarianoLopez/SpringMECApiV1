/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.Criteria.Postgre.AmbitoCriteriaPostgre;
import com.mec.Criteria.Postgre.CategoriaCriteriaPostgre;
import com.mec.Criteria.Postgre.DepartamentoCriteriaPostgre;
import com.mec.Criteria.Postgre.DependenciaCriteriaPostgre;
import com.mec.Criteria.Postgre.EstadoCriteriaPostgre;
import com.mec.Criteria.Postgre.JornadaCriteriaPostgre;
import com.mec.Criteria.Postgre.LocalidadCriteriaPostgre;
import com.mec.Criteria.Postgre.ModalidadCriteriaPostgre;
import com.mec.Criteria.Postgre.OfertaBaseCriteriaPostgre;
import com.mec.Criteria.Postgre.OfertaCriteriaPostgre;
import com.mec.Criteria.Postgre.SectorCriteriaPostgre;
import com.mec.DAO.ConexionesEscuelas.ConexionesDAO;
import com.mec.DAO.Postgre.EstablecimientoPostgreDAO;
import com.mec.DAO.POF2.GeoDAO;
import com.mec.Util.EstablecimientoDTO;
import com.mec.models.Padron.EstablecimientoPost;
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
public class EstablecimientosPostgreService {
    @Autowired private GeoDAO geoDAO;
    @Autowired private EstablecimientoPostgreDAO establecimientoDAO;
    @Autowired private ConexionesDAO conexionesEstablecimientosDAO;
    private List<EstablecimientoPost> todos = new ArrayList<>();
    private Map<String,List<EstablecimientoDTO>> DTO = new HashMap<>();

    
    public Map<String, List<EstablecimientoDTO>> getDTO() {
        return DTO;
    }
    
    public List<EstablecimientoPost> getAll(){
        return this.todos;
    }
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
                                                    Integer[] ofertas,Integer[] jornadas,Integer[] modalidades,Integer[] bases){
        List<EstablecimientoPost> todo = this.getAll();
        if(ambitos!=null){
            todo = new AmbitoCriteriaPostgre().filterCriteria(todo, ambitos);
        }
        if(categorias!=null){
            todo = new CategoriaCriteriaPostgre().filterCriteria(todo, categorias);
        }
        if(dependencias!=null){
            todo = new DependenciaCriteriaPostgre().filterCriteria(todo, dependencias);
        }
        if(estados!=null){
            todo = new EstadoCriteriaPostgre().filterCriteria(todo, estados);
        }
        if(sectores!=null){
            todo = new SectorCriteriaPostgre().filterCriteria(todo, sectores);
        }
        if(departamentos!=null){
            todo = new DepartamentoCriteriaPostgre().filterCriteria(todo,departamentos);
        }
        if(localidades!=null){
            todo = new LocalidadCriteriaPostgre().filterCriteria(todo,localidades);
        }
        if(ofertas!=null){
            todo = new OfertaCriteriaPostgre().filterCriteria(todo,ofertas);
        }
        if(jornadas!=null){
            todo = new JornadaCriteriaPostgre().filterCriteria(todo,jornadas);
        }
        if(modalidades!=null){
            todo = new ModalidadCriteriaPostgre().filterCriteria(todo,modalidades);
        }
        if(bases!=null){
            todo = new OfertaBaseCriteriaPostgre().filterCriteria(todo,bases);
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
                loc.getDomicilios().forEach((dom) -> {
                   try{
                        dom.setGeo(geoDAO.getByCueAnexo(Integer.parseInt(establecimiento.getCue()), Integer.parseInt(loc.getAnexo())));
                    }catch(NumberFormatException e){
                        System.out.println("NumberFormatException: "+e.toString());
                    } 
                });
            });   
    }
}
