/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.models.LuTrab;
import com.mec.models.LuTrabNoRelationship;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true)
public class LuTrabDAO {
    @Autowired
    private SessionFactory session;
    
    public List<LuTrabNoRelationship> getAll(){
        List<LuTrabNoRelationship> list = 
                        this.session.getCurrentSession()
                        .createCriteria(LuTrabNoRelationship.class)
                        .add(Restrictions.isNull("fechaClausura")).list();
        /*Query query = this.session.getCurrentSession().createQuery("from LuTrab where FechaClausura is null");
        return query.list();*/
        return list;
    }
    
    public LuTrab getById(int id){
        LuTrab l = (LuTrab)this.session.getCurrentSession().createCriteria(LuTrab.class).add(Restrictions.idEq(id)).uniqueResult();
        return l;
    }
    
    public LuTrab getByCueAnexo(int Cue, int Anexo){
        Query query = this.session.getCurrentSession().createQuery("from LuTrab where CUE = :Cue AND Anexo = :Anexo AND FechaClausura is null");
        query.setParameter("Cue", Cue);
        query.setParameter("Anexo", Anexo);
        LuTrab l = (LuTrab)query.uniqueResult();
        Hibernate.initialize(l.getIdDepartamento());
        Hibernate.initialize(l.getIdEntidadTipo());
        Hibernate.initialize(l.getIdLuTrabZona());
        Hibernate.initialize(l.getIdNivelJur());
        return l;
    }
}
