/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Localidad;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true)
public class LocalidadDAO extends HibernateUtil{
    public List<Localidad> getAll(){
        List<Localidad> localidades = getSession().createQuery("from Localidad where idProvincia = 8 order by Descr").list();
        return localidades;
    }
    
    public Localidad getById(int id){
        return getSession().get(Localidad.class, id);
    }
    
    /*public List<Localidad> getByDepartamentoId(int id){
        Query query = getSession().createQuery("from Localidad where idProvincia = 8 AND idDepartamento = :id order by Descr");
        query.setParameter("id", id);
        List<Localidad> localidades = query.list();
        return localidades;
    }*/
    
}
