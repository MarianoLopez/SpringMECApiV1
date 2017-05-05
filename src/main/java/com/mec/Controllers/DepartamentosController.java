/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.DepartamentoDAO;

import com.mec.models.Departamento;
import com.mec.models.Localidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@CrossOrigin()
@RequestMapping("/APIv1/departamentos")
public class DepartamentosController {
    @Autowired
    private DepartamentoDAO departamentoDAO;
    
    @RequestMapping()
    public List<Departamento> getAll(){
        return departamentoDAO.getAll();
    }
    
    @RequestMapping("/{id}")
    public Departamento getAll(@PathVariable(value="id")int id){
        return this.departamentoDAO.getById(id);
    }
}
