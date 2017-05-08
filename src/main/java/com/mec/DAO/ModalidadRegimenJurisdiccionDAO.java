/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.LuTrabRegimen;
import com.mec.models.Modali;
import com.mec.models.NivelJur;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true)
public class ModalidadRegimenJurisdiccionDAO extends HibernateUtil{
    public List<Modali> getModalidades(){
        return getSession().createQuery("from Modali").list();
    }
    
    public List<LuTrabRegimen> getRegimenes(){
        return getSession().createQuery("from LuTrabRegimen").list();
    }
    
    public List<NivelJur> getJurisdicciones(){
        return getSession().createQuery("from NivelJur").list();
    }
}
