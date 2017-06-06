/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.GE.Edificio;
import com.mec.models.GE.EstablecimientoEdificio;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 36194445
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerGE")
public class EdificioDAO extends HibernateUtil{
    
    public EstablecimientoEdificio getById(int id){
        EstablecimientoEdificio e = getSessionGE().get(EstablecimientoEdificio.class, id);
        lazyInit(e);
        return e;
    }
    
    public List<EstablecimientoEdificio> getByEstablecimientoId(int id){
        Query query = getSessionGE().createQuery("from EstablecimientoEdificio where EstablecimientoId = :id");
        query.setParameter("id", id);
        List<EstablecimientoEdificio> edificios = query.list();
        edificios.parallelStream().forEach((edi) -> {lazyInit(edi);});
        return edificios;
    }
    
    private void lazyInit(EstablecimientoEdificio e){
        Edificio edificio = e.getEdificioId();
        Hibernate.initialize(edificio);
        if(edificio!=null){
            Hibernate.initialize(edificio.getAmbitoId());
        }
    }
}
