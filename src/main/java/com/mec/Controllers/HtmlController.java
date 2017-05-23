/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author MarianoLopez
 */
@ApiIgnore
@Controller
public class HtmlController {
    @RequestMapping(method = RequestMethod.GET,value = {"/","/APIv1"})
    public String home(){
        return "redirect:/swagger-ui.html";
    }
}
