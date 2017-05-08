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
    
    public LuTrab getByCueAnexo(int Cue,int Anexo){
        LuTrab l = luTrabDAO.getByCueAnexo(Cue,Anexo);
        if(l!=null){
            Geoposicion geo = geoDAO.getByCueAnexo(Cue, Anexo);
            l.setGeo(geo);
        }
        return l;
    }

    public List<LuTrab> getByDepartamento(int id){
        List<LuTrab> lugares = luTrabDAO.getByDepartamento(id);
        initGeo(lugares);
        return lugares;
    }
    public List<LuTrab> getByDepartamento(int idDepartamento, int modalidad){
        List<LuTrab> lugares = luTrabDAO.getByDepartamento(idDepartamento,modalidad);
        initGeo(lugares);
        return lugares;
    }
    
    public List<LuTrab> getByLocalidad(int id){
        List<LuTrab> lugares = luTrabDAO.getByLocalidad(id);
        initGeo(lugares);
        return lugares;
    }
    
    private void initGeo(List<LuTrab> lugares){
        lugares.parallelStream().forEach((lugar)->{
            lugar.setGeo(geoDAO.getByCueAnexo(lugar.getCue(),lugar.getAnexo()));
        });
    }
}
