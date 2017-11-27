/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.ConexionesEscuelas.ConexionesTipoDAO;
import com.mec.DAO.Postgre.PostgreDAO;
import com.mec.Models.ConexionesEscuelas.Conexiontipo;
import com.mec.Models.Padron.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author MarianoLopez
 */
@RestController
@RequestMapping("/API")
public class InformacionAdicional {
    @Autowired private PostgreDAO postgre;
    @Autowired private ConexionesTipoDAO conexionesTipoDAO;

    @RequestMapping(method = RequestMethod.GET,value = "v2/conexiones")
    public List<Conexiontipo> getConexiones(){return conexionesTipoDAO.getAll();}

    /*****************************************************POSTGRE**************************************************/
    @ApiOperation(value = "Listado de todos los Ambitos posibles de los Establecimientos Educativos", response = AmbitoTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/ambitos")
    public List<AmbitoTipo> getAmbitosP(){return postgre.getAmbitos();}
    
    @ApiOperation(value = "Listado de todas las Categorías posibles de los Establecimientos Educativos", response = CategoriaTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/categorias")
    public List<CategoriaTipo> getCategoriasP(){return postgre.getCategorias();}
    
    @ApiOperation(value = "Listado de todas las Dependecias posibles de los Establecimientos Educativos", response = DependenciaTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/dependencias")
    public List<DependenciaTipo> getDependenciasP(){return postgre.getDependencias();}
    
    @ApiOperation(value = "Listado de todos los Estados posibles de los Establecimientos Educativos", response = EstadoTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/estados")
    public List<EstadoTipo> getEstadosP(){return postgre.getEstados();}
    
    @ApiOperation(value = "Listado de todos los Sectores posibles de los Establecimientos Educativos", response = SectorTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/sectores")
    public List<SectorTipo> getSectoresP(){return postgre.getSectores();}
    
    @ApiOperation(value = "Listado de todas las Ofertas posibles de los Establecimientos Educativos", response = OfertaTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/ofertas")
    public List<OfertaTipo> getOfertasP(){return postgre.getOfertas();}
    
    @ApiOperation(value = "Listado de todas las Jornadas posibles de los Establecimientos Educativos", response = JornadaTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/jornadas")
    public List<JornadaTipo> getJornadasP(){return postgre.getJornadas();}
    
    @ApiOperation(value = "Listado de todas las Modalidades de las ofertas posibles de los Establecimientos Educativos", response = Modalidad1Tipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/modalidades")
    public List<Modalidad1Tipo> getModalidadesP(){return postgre.getModalidades();}
    
    @ApiOperation(value = "Listado de todas las Bases de las ofertas posibles de los Establecimientos Educativos", response = OfertaBaseTipo.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v2/bases")
    public List<OfertaBaseTipo> getBasesP(){return postgre.getBases();}
}
