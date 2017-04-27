/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MarianoLopez
 */
public abstract class HibernateUtil {
    @Autowired
    private SessionFactory session;
    
    public SessionFactory getSessionFactory(){
        return this.session;
    }
    
    public Session getSession(){
        return this.session.getCurrentSession();
    }
}
