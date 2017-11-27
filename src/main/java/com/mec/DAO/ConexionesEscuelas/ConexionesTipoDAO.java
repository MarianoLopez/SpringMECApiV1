package com.mec.DAO.ConexionesEscuelas;

import com.mec.Models.ConexionesEscuelas.Conexiontipo;
import com.mec.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true,transactionManager = "managerConexionesEscuelas")
public class ConexionesTipoDAO extends HibernateUtil {
    public List<Conexiontipo> getAll(){
        Criteria cr = this.getSessionConexionesEscuelas().createCriteria(Conexiontipo.class);
        return cr.list();
    }
}
