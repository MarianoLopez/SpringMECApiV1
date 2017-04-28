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
import java.util.List;
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

    @Override
    public List<LuTrab> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
