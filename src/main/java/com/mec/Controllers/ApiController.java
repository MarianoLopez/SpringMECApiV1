/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Controllers;

import com.mec.Services.UserService;
import com.mec.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarianoLopez
 */
@RestController
@RequestMapping("/")
public class ApiController {
    @Autowired
    private UserService userService;
    
    @RequestMapping()
    public List<User> users(){
        return userService.getAll();
    }
    @RequestMapping("/{id}")
    public User get(@PathVariable(value="id") Long id){
        return userService.getById(id);
    }
    @RequestMapping("hello")
    public String home(){
        return "Hello World!";
    }
}
