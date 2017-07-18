/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO.Postgre;

import com.mec.Util.HibernateUtil;
import com.mec.models.Padron.Domicilio;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Padron.LocalidadTipo;
import com.mec.models.Padron.Localizacion;
import com.mec.models.Padron.OfertaLocal;
import com.mec.models.Padron.OfertaTipo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 36194445
 */
@Repository
@Transactional(readOnly = true,transactionManager = "managerPostgre")
public class EstablecimientoPostgreDAO extends HibernateUtil{
    
    //@Cacheable("establecimientos")
    public List<EstablecimientoPost> getAll(){
        Criteria cr = this.getSessionPostgre().createCriteria(EstablecimientoPost.class);
        cr.add(Restrictions.isNull("fechaBaja"));
        return lazyInit(cr.list());
    }
    public EstablecimientoPost getByCue(int Cue){
        Criteria cr = this.getSessionPostgre().createCriteria(EstablecimientoPost.class);
        cr.add(Restrictions.eq("cue", String.valueOf(Cue)));
        EstablecimientoPost e =(EstablecimientoPost)cr.uniqueResult();
        init(e);
        return e;
    }
    public EstablecimientoPost getByCueAnexo(int Cue, int Anexo){
        EstablecimientoPost e = getByCue(Cue);
        List<Localizacion> anexo = new ArrayList<>();
        for(Localizacion l:e.getLocalizacion()){if(Integer.parseInt(l.getAnexo())==Anexo){anexo.add(l);}}
        e.setLocalizacion(anexo);
        return e;
    }
    
    /*@CacheEvict(allEntries = true, value = {"establecimientos"})
    @Scheduled(fixedRate = 600000)//10min en ms
    public void reportCacheEvict() {
        System.out.println("Flush establecimientos Cache " + new Date());
    }*/
    
    private List<EstablecimientoPost> lazyInit(List<EstablecimientoPost> establecimientos){
        establecimientos.forEach((t) -> {init(t);});
        return establecimientos;
    }
    private void init(EstablecimientoPost t){
         Hibernate.initialize(t.getCategoria());
            Hibernate.initialize(t.getDependencia());
            Hibernate.initialize(t.getEstado());
            Hibernate.initialize(t.getSector());
            List<Localizacion> loc = t.getLocalizacion();
            Hibernate.initialize(loc);
            if(loc!=null){
                loc.forEach((l) -> {
                    Hibernate.initialize(l.getAmbito());
                    List<Domicilio> dom = l.getDomicilios();
                    if(dom!=null){
                        dom.forEach((d) -> {
                            LocalidadTipo localidad = d.getLocalidad();
                            Hibernate.initialize(localidad);
                            if(localidad!=null){
                                Hibernate.initialize(localidad.getDepartamento());
                            }
                        });
                    }
                    List<OfertaLocal> oferta = l.getOfertas();
                    Hibernate.initialize(oferta);
                    if(oferta!=null){
                        oferta.forEach((o) -> {
                            Hibernate.initialize(o.getJornada());
                            OfertaTipo ot = o.getOferta();
                            Hibernate.initialize(ot);
                            if(ot!=null){
                                Hibernate.initialize(ot.getModalidad());
                                Hibernate.initialize(ot.getBase());
                                //Hibernate.initialize(ot.getTitulos());
                            }
                        });
                    }
                });
            }
    }
}