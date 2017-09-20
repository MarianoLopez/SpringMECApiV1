/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.GeoDAO;
import com.mec.DAO.LuTrabDAO;
import com.mec.DAO.Postgre.EstablecimientoPostgreDAO;
import com.mec.DAO.Superior.SuperiorDAO;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Pof2.LuTrab;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mariano
 */
@Service
public class SuperiorService {
    @Autowired
    private LuTrabDAO lutrab;
    @Autowired
    private EstablecimientoPostgreDAO posgreDAO;
    @Autowired
    private SuperiorDAO superior;
    @Autowired
    private GeoDAO geoDAO;
    
    private String clean(String s){
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
    }
    public List<LuTrab> getAll(String filtro) throws IOException{
        Map<String,List<String>> s = superior.getAll();
        List<LuTrab> list = new ArrayList<>();
        s.forEach((carrera, cueAnexos) -> {
            if(filtro==null||filtro.isEmpty()||clean(carrera).contains(clean(filtro))){
                cueAnexos.forEach(cueAnexo ->{
                    Integer cue = Integer.parseInt(cueAnexo.substring(0, 7));
                    Integer anexo = Integer.parseInt(cueAnexo.substring(8));
                    LuTrab l = lutrab.getByCueAnexo(cue,anexo);
                    if(l!=null){
                        if(list.contains(l)){
                            list.get(list.indexOf(l)).getOrientacion().add(carrera);
                        }else{
                            l.getOrientacion().add(carrera);
                            list.add(l);
                        }
                    }
                });
            }
        });
        initGeo(list);
        return list;
    }
    
        public List<EstablecimientoPost> getAllP(String filtro) throws IOException{
        Map<String,List<String>> s = superior.getAll();
        List<EstablecimientoPost> list = new ArrayList<>();
        s.forEach((carrera, cueAnexos) -> {
            if(filtro==null||filtro.isEmpty()||clean(carrera).contains(clean(filtro))){
                cueAnexos.forEach(cueAnexo ->{
                    Integer cue = Integer.parseInt(cueAnexo.substring(0, 7));
                    Integer anexo = Integer.parseInt(cueAnexo.substring(8));
                    EstablecimientoPost l = posgreDAO.getByCueAnexo(cue,anexo);
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
    
    private void initGeo(List<LuTrab> lugares){lugares.parallelStream().forEach((lugar)->{lugar.setGeo(geoDAO.getByCueAnexo(lugar.getCue(),lugar.getAnexo()));});}
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
    
}
