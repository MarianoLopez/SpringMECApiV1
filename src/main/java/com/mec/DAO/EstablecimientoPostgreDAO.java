/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Padron.Localizacion;
import java.util.List;
import org.hibernate.Hibernate;
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
        return lazyInit(this.getSessionPostgre().createQuery("from "+EstablecimientoPost.class.getName()+" WHERE fechaBaja is null").list());
    }
    
    private List<EstablecimientoPost> lazyInit(List<EstablecimientoPost> establecimientos){
        establecimientos.parallelStream().forEach((t) -> {
            Hibernate.initialize(t.getCategoria());
            Hibernate.initialize(t.getDependencia());
            Hibernate.initialize(t.getEstado());
            Hibernate.initialize(t.getSector());
            List<Localizacion> loc = t.getLocalizacion();
            Hibernate.initialize(loc);
            if(loc!=null){
                loc.forEach((l) -> {Hibernate.initialize(l.getAmbito());});
            }
        });
        return establecimientos;
    }
}
