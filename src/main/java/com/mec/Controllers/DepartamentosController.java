/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mec.DAO.DepartamentoDAO;

import com.mec.models.Departamento;
import com.mec.models.especial.Dep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@RequestMapping("/APIv1/departamentos")
public class DepartamentosController {
    @Autowired
    private DepartamentoDAO departamentoDAO;
    
    @RequestMapping()
    public List<Dep> getAll(){
        return departamentoDAO.getAll();
    }
}
