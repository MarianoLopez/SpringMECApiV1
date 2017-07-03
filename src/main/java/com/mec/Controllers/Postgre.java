/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.DAO.EstablecimientoPostgreDAO;
import com.mec.models.Padron.EstablecimientoPost;
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
@RequestMapping("/APIv1/postgree")
public class Postgre {
    @Autowired
    private EstablecimientoPostgreDAO dao;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<EstablecimientoPost> getAll(){
        return dao.getAll();
    }
}
