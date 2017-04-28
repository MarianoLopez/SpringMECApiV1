/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Geoposicion;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */
@NamedStoredProcedureQuery(name = "dbo.LuTrabGetCoordenadasByCueAnexo",procedureName = "dbo.LuTrabGetCoordenadasByCueAnexo", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "CueAnexo", type = Integer.class)
})
@Repository
@Transactional(readOnly = true)
public class GeoDAO extends HibernateUtil{
    /*public Object getByCueAnexo(int cue, int anexo){
        ProcedureCall call = getSession().createStoredProcedureCall("exec LuTrabGetCoordenadasByCueAnexo");
        call.registerParameter("CueAnexo", Integer.class, ParameterMode.IN);
        call.getParameterRegistration("CueAnexo").bindValue(Integer.parseInt(""+cue+anexo));
        ProcedureOutputs procedureOutputs = call.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
        Object o = resultSetOutput.getSingleResult();
        System.out.println(""+o.toString());
        return o;
    }*/
    
     public Geoposicion getByCueAnexo(int cue, int anexo){
        Query query = getSession().createSQLQuery("exec LuTrabGetCoordenadasByCueAnexo :CueAnexo");
        //System.out.println("anexo: "+anexo);
        int aux;
        if(String.valueOf(anexo).length()==1){
            aux  = Integer.parseInt(cue+"0"+anexo);
        }else if (String.valueOf(anexo).length()>1){
            aux  = Integer.parseInt(""+cue+anexo+"0");
        }else{
            aux  = Integer.parseInt(cue+"00");//anexo null
        }
        //System.out.println("CueAnexo: "+aux);
        query.setParameter("CueAnexo",aux);
        query.setResultTransformer(Transformers.aliasToBean(Geoposicion.class));
        return (Geoposicion)query.uniqueResult();
        //System.out.println(o.toString());
        //return o;
     }
}