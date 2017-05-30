/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.ModalidadRegimenJurisdiccionDAO;
import com.mec.models.Pof2.LuTrabRegimen;
import com.mec.models.Pof2.Modali;
import com.mec.models.Pof2.NivelJur;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@CrossOrigin()
@RequestMapping("/APIv1/")
public class ModalidadRegimenJurisdiccion {
    @Autowired
    private ModalidadRegimenJurisdiccionDAO dao;
    
    @ApiOperation(value = "Listado de todas las Modalidades posibles de los Establecimientos Educativos", response = Modali.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "/modalidades")
    public List<Modali> getModalidades(){return dao.getModalidades();}
    
    @ApiOperation(value = "Listado de todos los Regímenes posibles de los Establecimientos Educativos", response = LuTrabRegimen.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "/regimenes")
    public List<LuTrabRegimen> getRegimenes(){return dao.getRegimenes();}
    
    @ApiOperation(value = "Listado de todas las Jurisdicciones posibles de los Establecimientos Educativos", response = LuTrabRegimen.class,produces = "application/json;charset=UTF-8")
    @RequestMapping(method = RequestMethod.GET,value = "/jurisdicciones")
    public List<NivelJur> getJurisdicciones(){return dao.getJurisdicciones();}
}
