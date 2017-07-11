/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.DepartamentoDAO;
import com.mec.DAO.Postgre.DepartamentoPostgreDAO;
import com.mec.models.Padron.DepartamentoTipo;

import com.mec.models.Pof2.Departamento;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@RequestMapping("/APIv1/departamentos")
public class Departamentos {
    @Autowired
    private DepartamentoDAO departamentoDAO;
    @Autowired
    private DepartamentoPostgreDAO pDepartamento;
    @ApiOperation(value = "Listado de todos los Departamentos de la Provincia de Corrientes", response = Departamento.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET)
    public List<Departamento> getAll(){
        return departamentoDAO.getAll();
    }
    
    @ApiOperation(value = "Búsqueda de Departamento de la Provincia de Corrientes a través de su ID", response = Departamento.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Departamento getAll(@PathVariable(value="id")int id){
        return this.departamentoDAO.getById(id);
    }
    
    
    /*******************************POSTGRE***************************************/
    @ApiOperation(value = "Listado de todos los Departamentos de la Provincia de Corrientes", response = DepartamentoTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value="/postgre")
    public List<DepartamentoTipo> getAllP(){
        return pDepartamento.getAll();
    }
    
    @ApiOperation(value = "Búsqueda de Departamento de la Provincia de Corrientes a través de su ID", response = DepartamentoTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}/postgre")
    public DepartamentoTipo getP(@PathVariable(value="id")int id){
        return this.pDepartamento.getById(id);
    }
    
}
