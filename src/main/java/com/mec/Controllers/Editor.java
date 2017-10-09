/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 36194445
 */
@RestController
@RequestMapping(value = "API/editor")
public class Editor {
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Prueba rol mapa.Editor", produces = "application/json;charset=UTF-8")
    public String home(){
        return "hello mapa.Editor";
    }
}
