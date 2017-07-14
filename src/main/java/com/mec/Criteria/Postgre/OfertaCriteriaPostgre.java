/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria.Postgre;

import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Padron.Localizacion;
import com.mec.models.Padron.OfertaLocal;
import com.mec.models.Padron.OfertaTipo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 36194445
 */
public class OfertaCriteriaPostgre implements EstablecimientosCriteriaPostgre{

    @Override
    public List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos, Integer[] IDs) {
        List<EstablecimientoPost> filter = new ArrayList<>();
        List<Integer> list = Arrays.asList(IDs);
        establecimientos.forEach((establecimiento) -> {
            List<Localizacion> localizaciones = establecimiento.getLocalizacion();
            if(localizaciones!=null){
                boolean insert = true;//mismo establecimiento, multiples localizaciones
                for(Localizacion localizacion: localizaciones){
                    List<OfertaLocal> ofertas = localizacion.getOfertas();
                    if(ofertas!=null){
                        for(OfertaLocal oferta: ofertas){
                            OfertaTipo tipo = oferta.getOferta();
                            if(tipo!=null&&list.contains(tipo.getId())&&insert){
                                filter.add(establecimiento);
                                insert=false;
                            }
                        }
                    }
                }
            }
        });
        return filter;
    }
    
}
