/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO.Postgre;

import com.mec.Util.HibernateUtil;
import com.mec.models.Padron.DepartamentoTipo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 36194445
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerPostgre")
public class DepartamentoPostgreDAO extends HibernateUtil{
    
    public List<DepartamentoTipo> getAll(){
        Criteria cr = getSessionPostgre().createCriteria(DepartamentoTipo.class);
        cr.add(Restrictions.eq("c_provincia", 18));//corrientes
        return cr.list();
    }
    
    public DepartamentoTipo getById(int id){
        return getSessionPostgre().get(DepartamentoTipo.class, id);
    }
}
