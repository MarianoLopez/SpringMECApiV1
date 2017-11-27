package com.mec.DAO.ConexionesEscuelas;

import com.mec.Models.ConexionesEscuelas.Electricidad;
import com.mec.Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true,transactionManager = "managerConexionesEscuelas")
public class ElectricidadDAO extends HibernateUtil {
    public Electricidad getByCueAnexo(String cue, short anexo){
        Criteria cr = this.getSessionConexionesEscuelas().createCriteria(Electricidad.class);
        cr.add(Restrictions.eq("electricidadPK.cue", cue));
        cr.add(Restrictions.eq("electricidadPK.anexo", anexo));
        return (Electricidad)cr.uniqueResult();
    }
}
