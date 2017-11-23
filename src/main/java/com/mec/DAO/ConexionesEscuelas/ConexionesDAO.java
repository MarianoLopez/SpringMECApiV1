/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO.ConexionesEscuelas;

import com.mec.Util.HibernateUtil;
import com.mec.models.ConexionesEscuelas.Conexiones;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mariano
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerConexionesEscuelas")
public class ConexionesDAO extends HibernateUtil{
    public List<Conexiones> getAll(){
        Criteria cr = this.getSessionConexionesEscuelas().createCriteria(Conexiones.class);
        return lazyInit(cr.list());
    }
    public List<Conexiones> getByCueAnexo(String cue,short anexo){
        Criteria cr = this.getSessionConexionesEscuelas().createCriteria(Conexiones.class);
        cr.add(Restrictions.eq("conexionesPK.cue", cue));
        cr.add(Restrictions.eq("conexionesPK.anexo", anexo));
        return lazyInit(cr.list());
    }
     
     private List<Conexiones> lazyInit(List<Conexiones> conexiones){
         conexiones.forEach(c->{
             Hibernate.initialize(c.getConexionTipo());
             Hibernate.initialize(c.getMovimiento());
             Hibernate.initialize(c.getProveedor());
         });
         return conexiones;
     }
}
