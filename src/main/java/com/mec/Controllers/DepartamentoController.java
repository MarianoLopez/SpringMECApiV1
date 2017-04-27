/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.Services.DepartamentoService;
import com.mec.models.Departamento;
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
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;
    
    @RequestMapping()
    public List<Departamento> getAll(){
        return departamentoService.getAll();
    }
}
