/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.POF2.GeoDAO;
import com.mec.DAO.Postgre.EstablecimientoPostgreDAO;
import com.mec.DAO.Superior.SuperiorDAO;
import com.mec.Models.Padron.EstablecimientoPost;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mariano
 */
@Service
public class SuperiorService {
    private EstablecimientoPostgreDAO posgreDAO;
    private SuperiorDAO superior;
    private GeoDAO geoDAO;
    private  List<EstablecimientoPost> TODO;

    public SuperiorService(EstablecimientoPostgreDAO posgreDAO, SuperiorDAO superior, GeoDAO geoDAO) throws IOException {
        this.posgreDAO = posgreDAO;
        this.superior = superior;
        this.geoDAO = geoDAO;
        new Thread(() -> {
            try {
                TODO = buscate();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();//para quedar bloqueado

    }
    private void initGeo(EstablecimientoPost establecimiento){
        establecimiento.getLocalizacion().forEach((loc) -> {
                loc.getDomicilios().forEach((dom) -> {
                   try{
                        dom.setGeo(geoDAO.getByCueAnexo(Integer.parseInt(establecimiento.getCue()), Integer.parseInt(loc.getAnexo())));
                    }catch(NumberFormatException e){
                        System.out.println("NumberFormatException: "+e.toString());
                    } 
                });
            });   
    }
    private List<EstablecimientoPost> buscate () throws IOException{
        Map<String,List<String>> s = superior.getAll();
        List<EstablecimientoPost> list = new ArrayList<>();
        s.forEach((carrera, cueAnexos) -> {
            if (carrera!=null && cueAnexos!=null){
                cueAnexos.forEach(cueAnexo ->{
                    Integer cue =0, anexo=0;
                    EstablecimientoPost l = null;
                    try {
                        cue = Integer.parseInt(cueAnexo.substring(0, 7));
                        anexo = Integer.parseInt(cueAnexo.substring(8));
                        l = posgreDAO.getByCueAnexo(cue,anexo);

                    } catch (Exception e) {
                        
                    }
                    if(l!=null){
                        if(list.contains(l)){
                            list.get(list.indexOf(l)).getLocalizacion().forEach(loc ->{loc.getOrientacion().add(carrera);});
                        }else{
                            l.getLocalizacion().forEach(loc ->{loc.getOrientacion().add(carrera);});
                            list.add(l);
                        }
                    }
                });
            }
            
            
        });
        
        
        list.forEach(e->{initGeo(e);});
        
        return list;
    }
    public List<EstablecimientoPost> getAllSuperior() throws IOException {return TODO;}
}
