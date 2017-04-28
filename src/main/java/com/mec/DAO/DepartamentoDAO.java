/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.especial.Dep;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true)
public class DepartamentoDAO extends HibernateUtil{
    public List<Dep> getAll() {
        List<Dep> d = getSession().createCriteria(Dep.class).add(Restrictions.isNotNull("departamentoId")).list();
        for (Dep departamento : d) {Hibernate.initialize(departamento.getLocalidadList());}
        return d;
    } 
}
