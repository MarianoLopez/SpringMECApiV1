/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Security;

import com.mec.DAO.Passport.UserDAO;
import com.mec.models.Passport.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author 36194445
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
    @Autowired
    private UserDAO userDAO;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication auth = null;
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        if(name!=null&&password!=null){
             Usuario u = userDAO.getUser(name, password);
            if (u!=null) {
                final UserDetails principal = new User(u.getId()+";"+name, password, u.getRoles());
                auth = new UsernamePasswordAuthenticationToken(principal, password, u.getRoles());  
            }
        }
       return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
}
