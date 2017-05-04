/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;


import com.mec.Services.LuTrabService;
import com.mec.models.LuTrab;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@RequestMapping("/APIv1/establecimientos")
public class EstablecimientosController {
    @Autowired
    private LuTrabService luTrabService;
    
    
    /*@RequestMapping()
    public List<LuTrabNoRelationship> lugaresTrabajo(){
        return luTrabService.getAll();
    }*/
    @RequestMapping("byCueAnexo/{Cue}/{Anexo}")
    public LuTrab lugaresTrabajoByID(@PathVariable(value="Cue") int Cue,@PathVariable(value="Anexo") int Anexo){
        return luTrabService.getByCueAnexo(Cue,Anexo);
    }
    
    @RequestMapping("byDepartamento/{id}")
    public List<LuTrab> lugaresTrabajoByDepartamento(@PathVariable(value="id") int id){
        return luTrabService.getByDepartamento(id);
    }
    
    @RequestMapping("byLocalidad/{id}")
    public List<LuTrab> lugaresTrabajoByLocalidad(@PathVariable(value="id") int id){
        return luTrabService.getByLocalidad(id);
    }
    
    
    @RequestMapping("hello")
    public String home(){
        return "Hello World!";
    }
}
