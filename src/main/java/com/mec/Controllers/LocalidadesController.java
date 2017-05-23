/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.Services.LocalidadService;
import com.mec.models.Departamento;
import com.mec.models.Localidad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin()
@RequestMapping("/APIv1/localidades")
public class LocalidadesController {
    @Autowired
    private LocalidadService localidadService;
    
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
    
    @RequestMapping(method = RequestMethod.GET,value="/{id}")
    public Localidad getAll(@PathVariable(value="id")int id){
        return this.localidadService.getById(id);
    }
}
