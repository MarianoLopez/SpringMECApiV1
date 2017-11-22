/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.POF2.GeoDAO;
import com.mec.DAO.Postgre.EstablecimientoPostgreDAO;
import com.mec.DAO.Superior.SuperiorDAO;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Padron.Localizacion;
import com.mec.models.Pof2.LuTrab;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    
    private String clean(String s){
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
    }

    
    public List<EstablecimientoPost> getAllP(String filtro) throws IOException{
        List<EstablecimientoPost> listado = getAllSuperior().stream()
            .filter(e->{
                List<Localizacion> loct = e.getLocalizacion().stream()
                    .filter(l->{
                        List<String> orientaciones = l.getOrientacion().stream()
                                .filter(o->clean(o).contains(clean(filtro)))
                                .collect(Collectors.toList());
                        return (orientaciones.size()>0);
                    })
                    .collect(Collectors.toList());//filtrado a lista
                if(loct.size()>0){e.setLocalizacion(loct);return true;}else{return false;}
            }).collect(Collectors.toList());
        
        listado.forEach(e->{
            e.getLocalizacion().forEach(loc->{
                loc.getOrientacion().removeIf(laOrientacion->(!clean(laOrientacion).contains(clean(filtro))));
            });
        });
        
        return listado;
    }
    
    
//    public List<EstablecimientoPost> getAllP(String filtro) throws IOException{
//        List<EstablecimientoPost> todos = getAllSuperior();
//        List<EstablecimientoPost> list = new ArrayList<>();
//        List<EstablecimientoPost> aux = new ArrayList<>();
//        
//        todos.forEach((laEscuela) -> {
//                laEscuela.getLocalizacion().forEach((laLocalizacion) ->{
//                    laLocalizacion.getOrientacion().forEach((laOrientacion)->{
//                        if (clean(laOrientacion).contains(clean(filtro))){
//                            aux.add(laEscuela);
//                        }
//                    });
//                   
//                });
//            });
//        
//        for (EstablecimientoPost estab : aux) {
//            if (!list.contains(estab)){
//                list.add(estab);
//            }
//        }
//        return list;
//    }
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
    public List<EstablecimientoPost> getAllSuperior() throws IOException {
       return TODO;
    }
    
}
