/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Departamento;
import java.util.List;
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
    public List<Departamento> getAll() {
        return getSession().createQuery("from Departamento where departamentoId is not null order by Descr").list();
    }
    
    public Departamento getById(int id){
        return getSession().get(Departamento.class, id);
    }
}
