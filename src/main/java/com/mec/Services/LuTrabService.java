/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.LuTrabDAO;
import com.mec.models.LuTrab;
import com.mec.models.LuTrabNoRelationship;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarianoLopez
 */
@Service
public class LuTrabService {
    @Autowired
    private LuTrabDAO luTrabDAO;
    
    public List<LuTrabNoRelationship> getAll(){
        return this.luTrabDAO.getAll();
    }
    
    public LuTrab getById(int id){
        return luTrabDAO.getById(id);
    }
    
    public LuTrab getByCueAnexo(int Cue,int Anexo){
        return luTrabDAO.getByCueAnexo(Cue,Anexo);
    }
    
    
}
