/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO.Postgre;

import com.mec.Util.HibernateUtil;
import com.mec.Models.Padron.DepartamentoTipo;
import com.mec.Models.Padron.LocalidadTipo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 36194445
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerPostgre")
public class LocalidadPostgreDAO extends HibernateUtil{
    
    public List<LocalidadTipo> getAll(){
        DetachedCriteria subCriteria = DetachedCriteria.forClass(DepartamentoTipo.class, "departamento")
                .add(Restrictions.eq("c_provincia", 18))
                .setProjection(Projections.property("departamento.id"));
        Criteria cr = getSessionPostgre().createCriteria(LocalidadTipo.class,"localidad");
        cr.add(Subqueries.propertyIn("localidad.cDepartamento.id", subCriteria));//localidades de Corrientes
        return lazyInit(cr.list());
    }
    
     public LocalidadTipo getById(int id){
        LocalidadTipo loc = getSessionPostgre().get(LocalidadTipo.class, id);
        Hibernate.initialize(loc.getDepartamento());
        return loc;
    }
    
    private List<LocalidadTipo> lazyInit(List<LocalidadTipo> localidades){
        localidades.forEach((l) -> {Hibernate.initialize(l.getDepartamento());});
        return localidades;
    }
}
