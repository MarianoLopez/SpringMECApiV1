/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO.Postgre;

import com.mec.Util.HibernateUtil;
import com.mec.models.Padron.AmbitoTipo;
import com.mec.models.Padron.CategoriaTipo;
import com.mec.models.Padron.DependenciaTipo;
import com.mec.models.Padron.EstadoTipo;
import com.mec.models.Padron.JornadaTipo;
import com.mec.models.Padron.Modalidad1Tipo;
import com.mec.models.Padron.OfertaBaseTipo;
import com.mec.models.Padron.OfertaTipo;
import com.mec.models.Padron.SectorTipo;
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
public class PostgreDAO extends HibernateUtil{
    public List<CategoriaTipo> getCategorias(){return get(CategoriaTipo.class);}
    public List<AmbitoTipo> getAmbitos(){return get(AmbitoTipo.class);}
    public List<DependenciaTipo> getDependencias(){return get(DependenciaTipo.class);}
    public List<EstadoTipo> getEstados(){return get(EstadoTipo.class);}
    public List<SectorTipo> getSectores(){return get(SectorTipo.class);}
    public List<OfertaTipo> getOfertas(){
        List<OfertaTipo> ofertas =  get(OfertaTipo.class);
        ofertas.forEach((o) -> {
            Hibernate.initialize(o.getBase());
            Hibernate.initialize(o.getModalidad());
        });
        return ofertas;
    }
    public List<JornadaTipo> getJornadas(){return get(JornadaTipo.class);}
    public List<Modalidad1Tipo> getModalidades(){return get(Modalidad1Tipo.class);}
    public List<OfertaBaseTipo> getBases(){return get(OfertaBaseTipo.class);}
    private List get(Class c){return getSessionPostgre().createCriteria(c).list();}
}
