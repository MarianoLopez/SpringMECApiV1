/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
    @RequestMapping(method = RequestMethod.GET,value = {"/","/API"})
    public String home(){
        return "redirect:/swagger-ui.html";
    }
    
    /*@RequestMapping(method = RequestMethod.GET,value = "/API/login")
    public String login(){
        return "redirect:/login";
    }
    
    @RequestMapping(value = "/API/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {new SecurityContextLogoutHandler().logout(request, response, auth);}
        return "redirect:/API";
    }*/
}
