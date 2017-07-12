/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria.Postgre;

import com.mec.models.Padron.AmbitoTipo;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Padron.Localizacion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 36194445
 */
public class AmbitoCriteriaPostgre implements EstablecimientosCriteriaPostgre{

    @Override
    public List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos, Integer[] IDs) {
        List<EstablecimientoPost> filter = new ArrayList<>();
        List<Integer> list = Arrays.asList(IDs);
        establecimientos.forEach((establecimiento) -> {
            List<Localizacion> localizaciones = establecimiento.getLocalizacion();
            if(localizaciones!=null){
                boolean insert = true;//mismo establecimiento, multiples localizaciones
                for(Localizacion localizacion: localizaciones){
                    AmbitoTipo ambito = localizacion.getAmbito();
                    if(ambito!=null&&list.contains(ambito.getId().intValue())&&insert){
                        filter.add(establecimiento);
                        insert=false;
                    }
                }
            }
        });
        return filter;
    }
    
}
