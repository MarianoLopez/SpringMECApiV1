/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.LocalidadDAO;
import com.mec.models.Localidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@CrossOrigin()
@RequestMapping("/APIv1/localidades")
public class LocalidadesController {
    @Autowired
    private LocalidadDAO localidadDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Localidad> getAll(){
        return this.localidadDAO.getAll();
    }
    
    @RequestMapping(method = RequestMethod.GET,value="/{id}")
    public Localidad getAll(@PathVariable(value="id")int id){
        return this.localidadDAO.getById(id);
    }
    
    @RequestMapping(method = RequestMethod.GET,value="/byDepartamento/{id}")
    public List<Localidad> getByDepartamentoId(@PathVariable(value="id")int id){
        return this.localidadDAO.getByDepartamentoId(id);
    }
}
