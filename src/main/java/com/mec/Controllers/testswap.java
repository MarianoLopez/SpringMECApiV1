/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nicholls
 */
@RestController
@RequestMapping("/testing")
public class testswap {
    @RequestMapping()
    public String sarasa(){
        return "probando swap - cambiando algo en el String, justo hacia el hilo la anterior";
    }
}
