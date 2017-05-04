/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.Util.HibernateUtil;
import com.mec.models.Geoposicion;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MarianoLopez
 */

@Repository
@Transactional(readOnly = true)
public class GeoDAO extends HibernateUtil{
     public Geoposicion getByCueAnexo(int cue, int anexo){
        Query query = getSession().createSQLQuery("exec [mapa].[paEntidadGetByCueAnexo] :CueAnexo");
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
        List<Geoposicion> g = query.list();
        return (g.isEmpty()?null:g.get(0));
     }
}