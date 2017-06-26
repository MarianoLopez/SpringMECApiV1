/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Passport;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author 36194445
 */
public class Usuario {
    private int id;
    private List<GrantedAuthority> roles;

    public Usuario(int id, List<GrantedAuthority> roles) {
        this.id = id;
        this.roles = roles;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }
    
    
}
