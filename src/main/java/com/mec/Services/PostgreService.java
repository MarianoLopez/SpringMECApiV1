/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.EstablecimientoPostgreDAO;
import com.mec.DAO.GeoDAO;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Pof2.Geoposicion;
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
public class PostgreService {
    @Autowired
    private GeoDAO geoDAO;
    @Autowired
    private EstablecimientoPostgreDAO establecimientoDAO;
    
    private List<EstablecimientoPost> todos = new ArrayList<>();
    
    
    public List<EstablecimientoPost> getAll(){
        return this.todos;
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
