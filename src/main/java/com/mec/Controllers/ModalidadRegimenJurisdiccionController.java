/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.ModalidadRegimenJurisdiccionDAO;
import com.mec.models.LuTrabRegimen;
import com.mec.models.Modali;
import com.mec.models.NivelJur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@CrossOrigin()
@RequestMapping("/APIv1/")
public class ModalidadRegimenJurisdiccionController {
    @Autowired
    private ModalidadRegimenJurisdiccionDAO dao;
    
    @RequestMapping(value = "/modalidades")
    public List<Modali> getModalidades(){
        return dao.getModalidades();
    }
    @RequestMapping(value = "/regimenes")
    public List<LuTrabRegimen> getRegimenes(){
        return dao.getRegimenes();
    }
    @RequestMapping(value = "/jurisdicciones")
    public List<NivelJur> getJurisdicciones(){
        return dao.getJurisdicciones();
    }
}
