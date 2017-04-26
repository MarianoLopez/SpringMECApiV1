/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.UserDAO;
import com.mec.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarianoLopez
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    
    
    public List<User> getAll(){
        return userDAO.getAll();
    }
    public User getById(Long id){
        return userDAO.getById(id);
    }
    public User getByIdWithProfile(Long id){
        return userDAO.getByIdWithProfile(id);
    }
}
