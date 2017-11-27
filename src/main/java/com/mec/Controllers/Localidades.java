/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.Postgre.LocalidadPostgreDAO;
import com.mec.Models.Padron.DepartamentoTipo;
import com.mec.Models.Padron.LocalidadTipo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MarianoLopez
 */
@RestController
@RequestMapping("/API")
public class Localidades {
    @Autowired
    private LocalidadPostgreDAO plocalidad;

    /*******************POSTGRE*******************************/
    
    @ApiOperation(value = "Listado de todas las Localidades de la Provincia de Corrientes. Filtro por departamentos opcional vía query: departamentos=id,id...", response = LocalidadTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value="v2/localidades")
    public List<LocalidadTipo> getAllP(@RequestParam(value="departamentos",required = false) Integer[] departamentos){
         if(departamentos!=null){
            List<LocalidadTipo> filtro = new ArrayList<>();
            List<Integer> IDs = Arrays.asList(departamentos);
            this.plocalidad.getAll().forEach((localidad) -> {
                DepartamentoTipo dep = localidad.getDepartamento();
                if (dep!=null &&IDs.contains(dep.getId())) {
                    filtro.add(localidad);
                }
            });
            return filtro;
        }else{
            return plocalidad.getAll();
        }
    }
    
    @ApiOperation(value = "Búsqueda de Localidad de la Provincia de Corrientes a través de su ID 'Código Postal'", response = LocalidadTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value="v2/localidades/{id}")
    public LocalidadTipo getP(@PathVariable(value="id")int id){
        return this.plocalidad.getById(id);
    }
}
