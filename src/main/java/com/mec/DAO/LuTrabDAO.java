/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Pof2.LuTrab;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerPof2")
public class LuTrabDAO extends HibernateUtil{
    private final String generalQuery = "from LuTrab where FechaClausura is null AND Hasta is null AND id != 12069 AND CUE is not null AND LEN(CUE)=7";//id=12069 --> pruebas pof
    
    public LuTrab getByCueAnexo(int Cue, int Anexo){
        Query query = this.getSessionPof2().createQuery(generalQuery+" AND CUE = :Cue AND Anexo = :Anexo");
        query.setParameter("Cue", Cue);
        query.setParameter("Anexo", Anexo);
        LuTrab l = (LuTrab)query.uniqueResult();
        lazyInit(l);
        return l;
    }
    
    public List<LuTrab> getAll(){
        List<LuTrab> lugares =  this.getSessionPof2().createQuery(generalQuery).setCacheable(true).list();
        lugares.parallelStream().forEach((lugar) -> {lazyInit(lugar);});
        return lugares;
    }
    
    //hibernate lazy init
    private void lazyInit(LuTrab l){
        if(l !=null){
            Hibernate.initialize(l.getEntidadTipo());
            //Hibernate.initialize(l.getIdLuTrabZona()); ej: {id: 4, descr: "Muy Desfavorable", mnemo: "D", porcentaje: 150}
            Hibernate.initialize(l.getNivelJurisdiccional());
            try{
                Hibernate.initialize(l.getLocalidad());
                if(Hibernate.isInitialized(l.getLocalidad())){
                    if(l.getLocalidad()!=null){
                        Hibernate.initialize(l.getLocalidad().getDepartamento());   
                    }
                }
            }catch(ObjectNotFoundException e){
                //System.out.println(e.toString());
                l.setLocalidad(null);
            }
            try{
                Hibernate.initialize(l.getRegimen());
            }catch(ObjectNotFoundException e){
                System.out.println(e.toString());
                l.setRegimen(null);
            }
            Hibernate.initialize(l.getModalidad());
            Hibernate.initialize(l.getTurno());
        }
    }
}
