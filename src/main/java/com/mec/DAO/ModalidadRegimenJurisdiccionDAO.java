/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Pof2.LuTrabRegimen;
import com.mec.models.Pof2.Modali;
import com.mec.models.Pof2.NivelJur;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerPof2")
public class ModalidadRegimenJurisdiccionDAO extends HibernateUtil{
    public List<Modali> getModalidades(){
        return getSessionPof2().createQuery("from Modali").list();
    }
    
    public List<LuTrabRegimen> getRegimenes(){
        return getSessionPof2().createQuery("from LuTrabRegimen").list();
    }
    
    public List<NivelJur> getJurisdicciones(){
        return getSessionPof2().createQuery("from NivelJur").list();
    }
}
