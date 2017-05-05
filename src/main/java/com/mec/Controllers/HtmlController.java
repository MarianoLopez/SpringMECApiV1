/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MarianoLopez
 */
@Controller
public class HtmlController {
    
    @RequestMapping(value = "/APIv1/",method = RequestMethod.GET)
    public String index(){
        return "Index";
    }
}
