/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 36194445
 */
@RestController
@RequestMapping(value = "APIv1/admin")
public class AdminTest {
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "Admin";
    }
}
