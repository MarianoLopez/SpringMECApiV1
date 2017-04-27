/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.GET;
import com.mec.Util.HibernateUtil;
import com.mec.models.Departamento;
import java.util.List;
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
        return this.getSession().createCriteria(Departamento.class).list();
    }

    public Departamento getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
