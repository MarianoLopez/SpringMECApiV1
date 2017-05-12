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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@CrossOrigin()
@RequestMapping("/APIv1/establecimientos")
public class EstablecimientosController {
    @Autowired
    private LuTrabService luTrabService;
    
    @RequestMapping()
    public List<LuTrab> getAll(@RequestParam(value = "geo", required = false, defaultValue = "false") Boolean geo){
        return luTrabService.getAll(geo);
    }
    @RequestMapping("byCueAnexo/{Cue}/{Anexo}")
    public LuTrab lugaresTrabajoByID(@PathVariable(value="Cue") int Cue,
                                     @PathVariable(value="Anexo") int Anexo){
        return luTrabService.getByCueAnexo(Cue,Anexo);
    }
    
    @RequestMapping("byDepartamento/{id}")
    public List<LuTrab> lugaresTrabajoByDepartamento(@PathVariable(value="id") int id,
            @RequestParam(value = "modalidad", required = false) Integer modalidad,
            @RequestParam(value = "regimen", required = false) Integer regimen,
            @RequestParam(value = "jurisdiccion", required = false) Integer juridisccion){
        return luTrabService.getByFilter(id,null,modalidad,regimen,juridisccion);
       
    }
    
    @RequestMapping("byLocalidad/{id}")
    public List<LuTrab> lugaresTrabajoByLocalidad(@PathVariable(value="id") int id,
            @RequestParam(value = "modalidad", required = false) Integer modalidad,
            @RequestParam(value = "regimen", required = false) Integer regimen,
            @RequestParam(value = "juridisccion", required = false) Integer juridisccion){
        return luTrabService.getByFilter(null,id,modalidad,regimen,juridisccion);
    }
}
