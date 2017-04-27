/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.DepartamentoDAO;
import com.mec.Util.GET;
import com.mec.models.Departamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarianoLopez
 */
@Service
public class DepartamentoService implements GET<Departamento,Integer>{
    @Autowired
    private DepartamentoDAO departamentoDAO;
    
    @Override
    public Departamento getByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departamento> getAll() {
        return departamentoDAO.getAll();
    }
    
}
