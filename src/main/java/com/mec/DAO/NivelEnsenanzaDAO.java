/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.GE.NivelEnsenanza;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 36194445
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerGE")
public class NivelEnsenanzaDAO extends HibernateUtil{
    public List<NivelEnsenanza> getAll() {
        return getSessionGE().createQuery("from NivelEnsenanza").list();
    }
    
}
