/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.GE.Establecimiento;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 36194445
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerGE")
public class EstablecimientoDAO extends HibernateUtil{
    
     public Establecimiento getByCueAnexoLuTrab(int Cue, int Anexo, int luTrab){
        Query query = this.getSessionGE().createQuery("from Establecimiento WHERE CUE = :Cue AND Anexo = :Anexo AND LuTrab = :luTrab");
        query.setParameter("Cue", Cue);
        query.setParameter("Anexo", Anexo);
        query.setParameter("luTrab", luTrab);
        return (Establecimiento)query.uniqueResult();
    }
}
