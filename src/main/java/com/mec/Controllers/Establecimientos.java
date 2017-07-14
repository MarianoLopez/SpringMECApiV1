/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;



import com.mec.Services.LuTrabService;
import com.mec.Services.EstablecimientosPostgreService;
import com.mec.models.Padron.EstablecimientoPost;

import com.mec.models.Pof2.LuTrab;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/API")
public class Establecimientos{
    @Autowired
    private LuTrabService luTrabService;
    /*@Autowired
    private UserDAO userDAO;*/
    @Autowired
    private EstablecimientosPostgreService dao;
    
    @ApiOperation(value = "Listado de todos los Establecimientos Educativos de la Provincia de Corrientes. Filtros opcionales vía query (modalidades, regimenes, jurisdicciones, departamentos y localidades). Ejemplo: departamentos=id,id&regimenes=id,id..", response = LuTrab.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v1/establecimientos")
    public List<LuTrab> getAll(@RequestParam(value = "cache", required = false, defaultValue = "true") Boolean cache,
                        @RequestParam(value="modalidades",required = false) Integer[] modalidades,
                        @RequestParam(value="regimenes",required = false) Integer[] regimenes,
                        @RequestParam(value="jurisdicciones",required = false) Integer[] jurisdicciones,
                        @RequestParam(value="departamentos",required = false) Integer[] departamentos,
                        @RequestParam(value="localidades",required = false) Integer[] localidades,
                        @RequestParam(value="ambitos",required = false) Integer[] ambitos){
        if(cache){
            return luTrabService.getByFilter(modalidades, regimenes, jurisdicciones, departamentos, localidades,ambitos);
        }else{
            return luTrabService.getAll(true);
        }
    }
    
    @ApiOperation(value = "Búsqueda de Establecimiento Educativo de la Provincia de Corrientes a través del CUE/ANEXO", response = LuTrab.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v1/establecimientos/{Cue}/{Anexo}")
    public LuTrab lugaresTrabajoByID(@PathVariable(value="Cue") int Cue,
                                     @PathVariable(value="Anexo") int Anexo){
        return luTrabService.getByCueAnexo(Cue,Anexo);
    }
    
    /*************POSTGRE************/
    @ApiOperation(value = "Listado de todos los Establecimientos Educativos de la Provincia de Corrientes. Filtros opcionales vía query (ámbitos, categorías, dependencias, estados, sectores, departamentos y localidades). Ejemplo: departamentos=id,id&regimenes=id,id..", response = EstablecimientoPost.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value="v2/establecimientos")
    public List<EstablecimientoPost> getAllP(
                        @RequestParam(value="ambitos",required = false) Integer[] ambitos,
                        @RequestParam(value="categorias",required = false) Integer[] categorias,
                        @RequestParam(value="dependencias",required = false) Integer[] dependencias,
                        @RequestParam(value="estados",required = false) Integer[] estados,
                        @RequestParam(value="sectores",required = false) Integer[] sectores,
                        @RequestParam(value="departamentos",required = false) Integer[] departamentos,
                        @RequestParam(value="localidades",required = false) Integer[] localidades,
                        @RequestParam(value="ofertas",required = false) Integer[] ofertas,
                        @RequestParam(value="jornadas",required = false) Integer[] jornadas,
                        @RequestParam(value="modalidades",required = false) Integer[] modalidades){
        return dao.getByFilter(ambitos, categorias, dependencias, estados, sectores, departamentos, localidades,ofertas,jornadas,modalidades);
    }
    
    @ApiOperation(value = "Búsqueda de Establecimiento Educativo de la Provincia de Corrientes a través del CUE/ANEXO", response = EstablecimientoPost.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/establecimientos/{Cue}/{Anexo}")
    public EstablecimientoPost getByID(@PathVariable(value="Cue") int Cue,
                                     @PathVariable(value="Anexo") int Anexo){
        return dao.getByCueAnexo(Cue,Anexo);
    }
    
    @ApiOperation(value = "Búsqueda de Establecimiento Educativo de la Provincia de Corrientes a través del CUE", response = EstablecimientoPost.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/establecimientos/{Cue}")
    public EstablecimientoPost getByCue(@PathVariable(value="Cue") int Cue){
        return dao.getByCue(Cue);
    }
    
    /*************************/
    /*@RequestMapping(method = RequestMethod.GET,value = "/test/{userName}/{pass}")
    public Usuario test(@PathVariable(value="userName") String userName,@PathVariable(value="pass") String pass){
        return userDAO.getUser(userName,pass);
    }*/
}
