/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.LuTrab;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true)
public class LuTrabDAO extends HibernateUtil{

    /*public List<LuTrabNoRelationship> getAll(){
        List<LuTrabNoRelationship> list = 
                        this.getSession()
                        .createCriteria(LuTrabNoRelationship.class)
                        .add(Restrictions.isNull("fechaClausura")).list();
        return list;
    }*/
    
    public LuTrab getById(int id){
        LuTrab l = (LuTrab)this.getSession().createCriteria(LuTrab.class).add(Restrictions.idEq(id)).uniqueResult();
        return l;
    }
    
    public LuTrab getByCueAnexo(int Cue, int Anexo){
        Query query = this.getSession().createQuery("from LuTrab where CUE = :Cue AND Anexo = :Anexo AND FechaClausura is null AND Hasta is null");
        query.setParameter("Cue", Cue);
        query.setParameter("Anexo", Anexo);
        LuTrab l = (LuTrab)query.uniqueResult();
        ini(l);
        return l;
    }
    
    public List<LuTrab> getByDepartamento(int idDepartamento){
        Query query = this.getSession().createQuery("from LuTrab where idDepartamento =:id AND FechaClausura is null AND Hasta is null AND CUE is not null AND LEN(CUE)=7");
        query.setParameter("id", idDepartamento);
        return query.list();
        /*List<LuTrab> lugares = query.list();
        for (LuTrab lugar : lugares) {ini(lugar);}
        return lugares;*/
    }
    
        public List<LuTrab> getByLocalidad(int idLocalidad){
        Query query = this.getSession().createQuery("from LuTrab where idLocalidad =:id AND FechaClausura is null AND Hasta is null AND CUE is not null AND LEN(CUE)=7");
        query.setParameter("id", idLocalidad);
        List<LuTrab> lugares = query.list();
        for (LuTrab lugar : lugares) {ini(lugar);}
        return lugares;
    }
    
    private void ini(LuTrab l){
          Hibernate.initialize(l.getEntidadTipo());
        //Hibernate.initialize(l.getIdLuTrabZona()); ej: {id: 4, descr: "Muy Desfavorable", mnemo: "D", porcentaje: 150}
        Hibernate.initialize(l.getNivelJurisdiccional());
        Hibernate.initialize(l.getLocalidad());
        if(l.getLocalidad()!=null){Hibernate.initialize(l.getLocalidad().getDepartamento());}
        Hibernate.initialize(l.getRegimen());
        Hibernate.initialize(l.getModalidad());
        Hibernate.initialize(l.getTurno());
    }
}
