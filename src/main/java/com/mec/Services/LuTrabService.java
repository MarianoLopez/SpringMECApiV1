/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.GeoDAO;
import com.mec.DAO.LuTrabDAO;
import com.mec.Util.GET;
import com.mec.models.Geoposicion;
import com.mec.models.LuTrab;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarianoLopez
 */
@Service
public class LuTrabService implements GET<LuTrab,Integer>{
    @Autowired
    private LuTrabDAO luTrabDAO;
    @Autowired
    private GeoDAO geoDAO;
    
    public LuTrab getByCueAnexo(int Cue,int Anexo){
        LuTrab l = luTrabDAO.getByCueAnexo(Cue,Anexo);
        Geoposicion geo = geoDAO.getByCueAnexo(Cue, Anexo);
        l.setGeo(geo);
        return l;
    }

    @Override
    public LuTrab getByID(Integer id) {
        return luTrabDAO.getById(id);
    }
    
    
    public List<LuTrab> getByDepartamento2(int id){
        return luTrabDAO.getByDepartamento(id);
    }
    
    public List<LuTrab> getByDepartamento(int id){
        List<LuTrab> lugares = luTrabDAO.getByDepartamento(id);
        /*if(id==9||id==30){*/
            int size = lugares.size();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<size/2;i++){
                        lugares.get(i).setGeo(geoDAO.getByCueAnexo(lugares.get(i).getCue(),lugares.get(i).getAnexo()));
                    }
                }
            });
            t.start();
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=size/2;i<size;i++){
                        lugares.get(i).setGeo(geoDAO.getByCueAnexo(lugares.get(i).getCue(),lugares.get(i).getAnexo()));
                    }
                }
            });
            t2.start();
            try {
                t.join();
                t2.join();
             } catch (InterruptedException ex) {
             // Logger.getLogger(LuTrabService.class.getName()).log(Level.SEVERE, null, ex);
             }
            /*try {
                latch.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(LuTrabService.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        /*}else{
            for (LuTrab lugar : lugares) {lugar.setGeo(geoDAO.getByCueAnexo(lugar.getCue(),lugar.getAnexo()));}
        }*/
        return lugares;
    }
    
    public List<LuTrab> getByLocalidad(int id){
        List<LuTrab> lugares = luTrabDAO.getByLocalidad(id);
        for (LuTrab lugar : lugares) {lugar.setGeo(geoDAO.getByCueAnexo(lugar.getCue(),lugar.getAnexo()));}
        return lugares;
    }

    @Override
    public List<LuTrab> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
