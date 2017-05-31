/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.GE.Establecimiento;
import com.mec.models.GE.EstablecimientoDetalle;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 36194445
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerGE")
public class EstablecimientoDAO extends HibernateUtil{
    
    
    public List<Establecimiento> getAll(){
        List<Establecimiento> list = getSessionGE().createQuery("from Establecimiento").list();
        init(list);
        return list;
    }
    
    private void init(List<Establecimiento> list){
        list.parallelStream().forEach((e) -> {
            Hibernate.initialize(e.getEstablecimientoDetalleList());
            /*List<EstablecimientoDetalle> detalle = e.getEstablecimientoDetalleList();
            detalle.parallelStream().forEach((d) -> {
                Hibernate.initialize(d.getCategoriaEstablecimientoId());
            });*/
        });
    }
}
