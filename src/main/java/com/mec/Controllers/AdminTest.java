/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author 36194445
 */
@RestController
@RequestMapping(value = "APIv1/admin")
@ApiIgnore
public class AdminTest {
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    authentication.getAuthorities().forEach((t) -> {
        System.out.println(t.getAuthority());
    });
        return "Admin";
    }
}
