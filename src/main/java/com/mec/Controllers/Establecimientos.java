/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;



import com.mec.DAO.UserDAO;
import com.mec.Services.LuTrabService;
import com.mec.Services.PostgreService;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Passport.Usuario;

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
@RequestMapping("/APIv1/establecimientos")
public class Establecimientos{
    @Autowired
    private LuTrabService luTrabService;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PostgreService dao;
    
    @ApiOperation(value = "Listado de todos los Establecimientos Educativos de la Provincia de Corrientes. Filtros opcionales vía query (modalidades, regimenes, jurisdicciones, departamentos y localidades). Ejemplo: departamentos=id,id&regimenes=id,id..", response = LuTrab.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET)
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
    @RequestMapping(method = RequestMethod.GET,value = "/{Cue}/{Anexo}")
    public LuTrab lugaresTrabajoByID(@PathVariable(value="Cue") int Cue,
                                     @PathVariable(value="Anexo") int Anexo){
        return luTrabService.getByCueAnexo(Cue,Anexo);
    }
    
    /*************POSTGRE************/
    @ApiOperation(value = "Listado de todos los Establecimientos Educativos de la Provincia de Corrientes. Filtros opcionales vía query (modalidades, regimenes, jurisdicciones, departamentos y localidades). Ejemplo: departamentos=id,id&regimenes=id,id..", response = EstablecimientoPost.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value="postgre")
    public List<EstablecimientoPost> getAllP(
                        @RequestParam(value="modalidades",required = false) Integer[] modalidades,
                        @RequestParam(value="regimenes",required = false) Integer[] regimenes,
                        @RequestParam(value="jurisdicciones",required = false) Integer[] jurisdicciones,
                        @RequestParam(value="departamentos",required = false) Integer[] departamentos,
                        @RequestParam(value="localidades",required = false) Integer[] localidades,
                        @RequestParam(value="ambitos",required = false) Integer[] ambitos){
        return dao.getAll();
    }
    
    @ApiOperation(value = "Búsqueda de Establecimiento Educativo de la Provincia de Corrientes a través del CUE/ANEXO", response = EstablecimientoPost.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "postgre/{Cue}/{Anexo}")
    public EstablecimientoPost getByID(@PathVariable(value="Cue") int Cue,
                                     @PathVariable(value="Anexo") int Anexo){
        return dao.getByCueAnexo(Cue,Anexo);
    }
    
    @ApiOperation(value = "Búsqueda de Establecimiento Educativo de la Provincia de Corrientes a través del CUE", response = EstablecimientoPost.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "postgre/{Cue}")
    public EstablecimientoPost getByCue(@PathVariable(value="Cue") int Cue){
        return dao.getByCue(Cue);
    }
    
    /*************************/
    /*@RequestMapping(method = RequestMethod.GET,value = "/test/{userName}/{pass}")
    public Usuario test(@PathVariable(value="userName") String userName,@PathVariable(value="pass") String pass){
        return userDAO.getUser(userName,pass);
    }*/
}
