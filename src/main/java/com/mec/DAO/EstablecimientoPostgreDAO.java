/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Padron.EstablecimientoPost;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 36194445
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerPostgre")
public class EstablecimientoPostgreDAO extends HibernateUtil{
    public List<EstablecimientoPost> getAll(){
        return this.getSessionPostgre().createQuery("from "+EstablecimientoPost.class.getName()).list();
    }
}
