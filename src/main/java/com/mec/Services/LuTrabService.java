/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.GeoDAO;
import com.mec.DAO.LuTrabDAO;
import com.mec.models.Geoposicion;
import com.mec.models.LuTrab;
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
    
    private List<LuTrab> todos;
    
    @Scheduled(fixedRate = 120000)//2min
    private void reportCurrentTime() {this.todos = getAll(true);}
    
    public List<LuTrab> getAll(){return this.todos;}
    
     public List<LuTrab> getAll(boolean geo){
        List<LuTrab> lugares =  luTrabDAO.getAll();
        if(geo){initGeo(lugares);}
        return lugares;
    }
    
    public LuTrab getByCueAnexo(int Cue,int Anexo){
        LuTrab l = luTrabDAO.getByCueAnexo(Cue,Anexo);
        if(l!=null){
            Geoposicion geo = geoDAO.getByCueAnexo(Cue, Anexo);
            l.setGeo(geo);
        }
        return l;
    }
   
    public List<LuTrab> getByFilter(Integer idDepartamento,Integer idLocalidad, Integer modalidad, Integer regimen, Integer juris){
        List<LuTrab> lugares = luTrabDAO.getByFilter(idDepartamento,idLocalidad,modalidad,regimen,juris);
        initGeo(lugares);
        return lugares;
    }
   
    
    private void initGeo(List<LuTrab> lugares){
        lugares.parallelStream().forEach((lugar)->{
            lugar.setGeo(geoDAO.getByCueAnexo(lugar.getCue(),lugar.getAnexo()));
        });
    }
}
