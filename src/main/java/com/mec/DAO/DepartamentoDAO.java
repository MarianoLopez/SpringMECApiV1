/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Pof2.Departamento;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerPof2")
public class DepartamentoDAO extends HibernateUtil{
    public List<Departamento> getAll() {
        return getSessionPof2().createQuery("from Departamento where departamentoId is not null order by Descr").list();
    }
    
    public Departamento getById(int id){
        return getSessionPof2().get(Departamento.class, id);
    }
}
