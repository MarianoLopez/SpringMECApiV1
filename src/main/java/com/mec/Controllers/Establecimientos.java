/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;



import com.mec.Criteria.JurisdiccionCriteria;
import com.mec.Criteria.Postgre.GeoCriteria;
import com.mec.DAO.Superior.SuperiorDAO;
import com.mec.Services.LuTrabService;
import com.mec.Services.EstablecimientosPostgreService;
import com.mec.Services.SuperiorService;
import com.mec.Services.VoteroService;
import com.mec.Util.EstablecimientoDTO;
import com.mec.models.Padron.EstablecimientoPost;

import com.mec.models.Pof2.LuTrab;
import com.mec.models.votero.Establecimiento;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Autowired
    private SuperiorDAO superior;
    @Autowired
    private SuperiorService superiorService;
    @Autowired
    private VoteroService voteroService;
    
    
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
    
    @RequestMapping(method = RequestMethod.GET, value = "v1/establecimientos/plan/{arg}")
    public List<LuTrab> getEstablecimientosByPlan(@PathVariable(value="arg") String arg){
        return new JurisdiccionCriteria().filterCriteria(luTrabService.getEstablecimientoByPlanEstudio(arg),new Integer[]{0,1,2,3,4,5,6,7,8});
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "v1/establecimientos/superior")
    public Map<String,List<String>> superior() throws IOException{
        return superior.getAll();
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "v1/establecimientos/superior/{arg}")
    public List<LuTrab> superior(@PathVariable(value="arg") String arg) throws IOException{
        try {
            return new JurisdiccionCriteria().filterCriteria(superiorService.getAll(arg),new Integer[]{0,1,2,3,4,5,6,7,8});
        } catch (IOException ex) {
            Logger.getLogger(Establecimientos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
                        @RequestParam(value="modalidades",required = false) Integer[] modalidades,
                        @RequestParam(value="bases",required = false) Integer[] bases){
        return dao.getByFilter(ambitos, categorias, dependencias, estados, sectores, departamentos, localidades,ofertas,jornadas,modalidades,bases);
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

//    @ApiOperation(value = "Búsqueda de Establecimiento Superior a través de palabra clave en la orientación (Excel)", response = EstablecimientoPost.class,produces = "application/json;charset=UTF-8")
//    @RequestMapping(method = RequestMethod.GET,value = "v2/establecimientos/superior/{arg}")
//    public List<EstablecimientoPost> superiorP(@PathVariable(value="arg") String arg) throws IOException{
//        try {
//            return superiorService.getAllP(arg);
//        } catch (IOException ex) {
//            Logger.getLogger(Establecimientos.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
    
    @ApiOperation(value = "Solo Superior", response = EstablecimientoPost.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/establecimientos/superior")
    public List<EstablecimientoPost> superiorAll(){
        try {
            return superiorService.getAllSuperior();
        } catch (IOException ex) {
            Logger.getLogger(Establecimientos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    @RequestMapping(method = RequestMethod.GET,value = "v2/establecimientos/votero")
    public Map<String,List<Establecimiento>> voteroEstablecimientos() throws IOException{
        return voteroService.getAll();
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "v2/establecimientos/index")
    public Map<String, List<EstablecimientoDTO>> establecimientosIndex() throws IOException{
        return dao.getDTO();
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "v2/establecimientos/{lat}/{lon}/{km}")
    public List<EstablecimientoPost> establecimientosGeoFilter(@PathVariable(value="lat") Float lat,
                                                               @PathVariable(value="lon") Float lon,
                                                               @PathVariable(value="km") Double km) throws IOException{
        return GeoCriteria.criteria(dao.getAll(),lat,lon,km);
    }
    
    
    /*************************/
    /*@RequestMapping(method = RequestMethod.GET,value = "/test/{userName}/{pass}")
    public Usuario test(@PathVariable(value="userName") String userName,@PathVariable(value="pass") String pass){
        return userDAO.getUser(userName,pass);
    }*/
    
            
}