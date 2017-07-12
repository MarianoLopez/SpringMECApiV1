/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.AmbitoDAO;
import com.mec.DAO.ModalidadRegimenJurisdiccionDAO;
import com.mec.DAO.Postgre.PostgreDAO;
import com.mec.models.GE.Ambito;
import com.mec.models.Padron.AmbitoTipo;
import com.mec.models.Padron.CategoriaTipo;
import com.mec.models.Padron.DependenciaTipo;
import com.mec.models.Padron.EstadoTipo;
import com.mec.models.Padron.SectorTipo;
import com.mec.models.Pof2.LuTrabRegimen;
import com.mec.models.Pof2.Modali;
import com.mec.models.Pof2.NivelJur;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@RequestMapping("/API")
public class InformacionAdicional {
    @Autowired
    private ModalidadRegimenJurisdiccionDAO dao;
    @Autowired
    private AmbitoDAO ambitoDAO;
    @Autowired
    private PostgreDAO postgre;
    
    @ApiOperation(value = "Listado de todas las Modalidades posibles de los Establecimientos Educativos", response = Modali.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v1/modalidades")
    public List<Modali> getModalidades(){return dao.getModalidades();}
    
    @ApiOperation(value = "Listado de todos los Regímenes posibles de los Establecimientos Educativos", response = LuTrabRegimen.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v1/regimenes")
    public List<LuTrabRegimen> getRegimenes(){return dao.getRegimenes();}
    
    @ApiOperation(value = "Listado de todas las Jurisdicciones posibles de los Establecimientos Educativos", response = LuTrabRegimen.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v1/jurisdicciones")
    public List<NivelJur> getJurisdicciones(){return dao.getJurisdicciones();}
    
    @ApiOperation(value = "Listado de todos los Ambitos posibles de los Establecimientos Educativos", response = Ambito.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "v1/ambitos")
    public List<Ambito> getAmbitos(){return ambitoDAO.getAll();}
    
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
}
