/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author MarianoLopez
 */
public abstract class HibernateUtil {
    @Autowired
    @Qualifier(value="sessionPof2")
    private SessionFactory session;
    
    @Autowired
    @Qualifier(value="sessionGE")
    private SessionFactory session2;
    
    @Autowired
    @Qualifier(value="sessionPassport")
    private SessionFactory session3;
    
    @Autowired
    @Qualifier(value="sessionPostgre")
    private SessionFactory session4;
    
    @Autowired
    @Qualifier(value="sessionConexionesEscuelas")
    private SessionFactory session5;
    
    public SessionFactory getSessionFactoryPof2(){return this.session;}
    
    public Session getSessionPof2(){return this.session.getCurrentSession();}
    
    public SessionFactory getSessionFactoryGE(){return this.session2;}
    
    public Session getSessionGE(){return this.session2.getCurrentSession();}
    
    public SessionFactory getSessionFactoryPassport(){return this.session3;}
    
    public Session getSessionPassport(){return this.session3.getCurrentSession();}
    
    public SessionFactory getSessionFactoryPostgre(){return this.session4;}
    
    public Session getSessionPostgre(){return this.session4.getCurrentSession();}
    
    public SessionFactory getSessionFactoryConexionesEscuelas(){return this.session5;}
    
    public Session getSessionConexionesEscuelas(){return this.session5.getCurrentSession();}
    
}
