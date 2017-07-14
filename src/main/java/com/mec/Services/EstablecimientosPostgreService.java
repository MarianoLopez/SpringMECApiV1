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
import com.mec.Criteria.Postgre.OfertaCriteriaPostgre;
import com.mec.Criteria.Postgre.SectorCriteriaPostgre;
import com.mec.DAO.Postgre.EstablecimientoPostgreDAO;
import com.mec.DAO.GeoDAO;
import com.mec.models.Padron.EstablecimientoPost;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author 36194445
 */
@Service
public class EstablecimientosPostgreService {
    @Autowired
    private GeoDAO geoDAO;
    @Autowired
    private EstablecimientoPostgreDAO establecimientoDAO;
    
    private List<EstablecimientoPost> todos = new ArrayList<>();
    
    
    public List<EstablecimientoPost> getAll(){
        return this.todos;
    }
    public EstablecimientoPost getByCue(int Cue){
        return establecimientoDAO.getByCue(Cue);
    }
    public EstablecimientoPost getByCueAnexo(int Cue, int Anexo){
        return establecimientoDAO.getByCueAnexo(Cue, Anexo);
    }
    
    
    
     public List<EstablecimientoPost> getByFilter(Integer[] ambitos,Integer[] categorias,Integer[] dependencias,
                                                    Integer[] estados,Integer[] sectores,Integer[] departamentos,Integer[] localidades,
                                                    Integer[] ofertas,Integer[] jornadas,Integer[] modalidades){
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
        return todo;
    }
    
    //cache task
    @Scheduled(fixedRate = 600000)//10min en ms
    private void getAllEstablecimientos() {
        long startTime = System.currentTimeMillis();
        List<EstablecimientoPost> aux = establecimientoDAO.getAll();
        initGeo(aux);
        this.todos = aux;
        long endTime = System.currentTimeMillis();
        System.out.println("getAllEstablecimientos() listo -->"+(endTime - startTime)/1000.0+" segundos");
    }
    
    private void initGeo(List<EstablecimientoPost> establecimientos){
        establecimientos.parallelStream().forEach((establecimiento)->{
            establecimiento.getLocalizacion().forEach((loc) -> {
                loc.getDomicilios().forEach((dom) -> {
                   try{
                        dom.setGeo(geoDAO.getByCueAnexo(Integer.parseInt(establecimiento.getCue()), Integer.parseInt(loc.getAnexo())));
                    }catch(NumberFormatException e){
                        System.out.println("NumberFormatException: "+e.toString());
                    } 
                });
            });
        });
    }
}
