/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.NivelEnsenanzaDAO;
import com.mec.models.GE.NivelEnsenanza;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 36194445
 */
@RestController
@CrossOrigin()
@RequestMapping("/APIv1/nivel")
public class Nivel {
    @Autowired
    private NivelEnsenanzaDAO nivel;
    
    @ApiOperation(value = "Listado de los niveles de enseñanza desde Gestion Educativa (test)", response = NivelEnsenanza.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<NivelEnsenanza> getAll(){
        return nivel.getAll();
    }
}
