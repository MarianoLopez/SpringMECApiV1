/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.models.User;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true)
public class UserDAO {
    @Autowired
    private SessionFactory session;
    
    public List<User> getAll(){
        List<User> usuarios = this.session.getCurrentSession().createQuery("from User u").list();
        for (User usuario : usuarios) {
            Hibernate.initialize(usuario.getProfileList());//lazy
        }
        return usuarios;
    }
    
    public User getById(Long id){
        return (User) this.session.getCurrentSession().createCriteria(User.class).add(Restrictions.idEq(id)).uniqueResult(); 
    }
    public User getByIdWithProfile(Long id){
        User u = this.getById(id);
        Hibernate.initialize(u.getProfileList());//lazy
        return u;
    }
    
}
