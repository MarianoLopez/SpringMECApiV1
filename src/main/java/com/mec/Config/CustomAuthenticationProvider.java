/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Config;

import com.mec.DAO.UserDAO;
import com.mec.models.Passport.Rol;
import com.mec.models.Passport.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
                List<GrantedAuthority> grantedAuths = new ArrayList<>();
                for(Rol r:u.getRoles()){
                    grantedAuths.add(new SimpleGrantedAuthority("ROLE_"+r.getNombre()));
                }
                final UserDetails principal = new User(name, password, grantedAuths);
                auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);  
            }
        }
       return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
}
