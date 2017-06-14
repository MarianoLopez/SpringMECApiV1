/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Pof2.Localidad;
import com.mec.models.Pof2.LuTrab;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerPof2")
public class LocalidadDAO extends HibernateUtil{
    public List<Localidad> getAll(){
        //Solo localidades con establecimientos educativos
        DetachedCriteria subCriteria = DetachedCriteria.forClass(LuTrab.class, "lutrab")
                .add(Restrictions.isNull("lutrab.fechaClausura"))
                .add(Restrictions.isNull("lutrab.hasta"))
                .setProjection(Projections.property("lutrab.localidad.id"));
        try {
            return (List<Localidad>) getSessionPof2().createCriteria(Localidad.class,"loc")
                            .add(Restrictions.eq("loc.idProvincia", 8))//corrientes
                            .add(Subqueries.propertyIn("loc.id", subCriteria))
                            .list();		
	} catch (HibernateException e) {
                System.out.println("LocalidadDAO getAll(): "+e.toString());
		return new ArrayList<>();
	}
    }
    
    public Localidad getById(int id){
        return getSessionPof2().get(Localidad.class, id);
    }
}
