/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;



import com.mec.Services.LuTrabService;
import com.mec.models.LuTrab;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/APIv1/establecimientos")
@Api(value="establecimientos")
public class EstablecimientosController{
    @Autowired
    private LuTrabService luTrabService;
    
    @ApiOperation(value = "Lista de establecimientos educativos", response = LuTrab.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<LuTrab> getAll(@RequestParam(value = "cache", required = false, defaultValue = "true") Boolean cache,
                        @RequestParam(value="modalidades",required = false) Integer[] modalidades,
                        @RequestParam(value="regimenes",required = false) Integer[] regimenes,
                        @RequestParam(value="jurisdicciones",required = false) Integer[] jurisdicciones,
                        @RequestParam(value="departamentos",required = false) Integer[] departamentos,
                        @RequestParam(value="localidades",required = false) Integer[] localidades){
        if(cache){
            return luTrabService.getByFilter(modalidades, regimenes, jurisdicciones, departamentos, localidades);
        }else{
            return luTrabService.getAll(true);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "byCueAnexo/{Cue}/{Anexo}")
    public LuTrab lugaresTrabajoByID(@PathVariable(value="Cue") int Cue,
                                     @PathVariable(value="Anexo") int Anexo){
        return luTrabService.getByCueAnexo(Cue,Anexo);
    }
}
