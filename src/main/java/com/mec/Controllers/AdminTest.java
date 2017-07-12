/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
@RequestMapping(value = "API/v1/roles")
@ApiIgnore
public class AdminTest {
    
    @RequestMapping(method = RequestMethod.GET)
    public List<GrantedAuthority> home(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (List<GrantedAuthority>)authentication.getAuthorities();
       
    }
}
