/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.Postgre.LocalidadPostgreDAO;
import com.mec.Services.LocalidadService;
import com.mec.models.Padron.DepartamentoTipo;
import com.mec.models.Padron.LocalidadTipo;
import com.mec.models.Pof2.Departamento;
import com.mec.models.Pof2.Localidad;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@RequestMapping("/APIv1/localidades")
public class Localidades {
    @Autowired
    private LocalidadService localidadService;
    @Autowired
    private LocalidadPostgreDAO plocalidad;
    
    @ApiOperation(value = "Listado de todas las Localidades de la Provincia de Corrientes. Filtro por departamentos opcional vía query: departamentos=id,id...", response = Localidad.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET)
    public List<Localidad> getAll(@RequestParam(value="departamentos",required = false) Integer[] departamentos){
        if(departamentos!=null){
            List<Localidad> filtro = new ArrayList<>();
            List<Integer> IDs = Arrays.asList(departamentos);
            this.localidadService.getLocalidades().forEach((localidad) -> {
                Departamento dep = localidad.getDepartamento();
                if (dep!=null &&IDs.contains(dep.getDepartamentoId())) {
                    filtro.add(localidad);
                }
            });
            return filtro;
        }else{
            return this.localidadService.getLocalidades();
        }
    }
    
    @ApiOperation(value = "Búsqueda de Localidad de la Provincia de Corrientes a través de su ID 'Código Postal'", response = Localidad.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value="/{id}")
    public Localidad getAll(@PathVariable(value="id")int id){
        return this.localidadService.getById(id);
    }
    
    
    /**************************************************/
    
    @ApiOperation(value = "Listado de todas las Localidades de la Provincia de Corrientes. Filtro por departamentos opcional vía query: departamentos=id,id...", response = LocalidadTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value="/postgre")
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
    @RequestMapping(method = RequestMethod.GET,value="/postgre/{id}")
    public LocalidadTipo getP(@PathVariable(value="id")int id){
        return this.plocalidad.getById(id);
    }
}
