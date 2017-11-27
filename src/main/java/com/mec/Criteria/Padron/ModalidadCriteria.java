/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria.Padron;

import com.mec.Criteria.EstablecimientosCriteria;
import com.mec.Models.Padron.EstablecimientoPost;
import com.mec.Models.Padron.Localizacion;
import com.mec.Models.Padron.OfertaLocal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 36194445
 */
public class ModalidadCriteria implements EstablecimientosCriteria {

    @Override
    public List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos, Integer[] IDs) {
        List<Integer> list = Arrays.asList(IDs);
        return establecimientos.stream()
            .filter(e->{
                    List<Localizacion> loct = e.getLocalizacion().stream()
                        .filter(l->{
                            List<OfertaLocal> ofertas = l.getOfertas().stream()
                                .filter(oferta -> oferta.getOferta()!=null&&oferta.getOferta().getModalidad()!=null&&list.contains(oferta.getOferta().getModalidad().getId().intValue()))
                                .collect(Collectors.toList());//filtrado a lista
                            if(ofertas.size()>0){l.setOfertas(ofertas);return true;}else{return false;}//si posee domicilios despues del filtrado
                        }).collect(Collectors.toList());//localizacion
                    if(loct.size()>0){e.setLocalizacion(loct);return true;}else{return false;}
            }).collect(Collectors.toList());
    }
    
}
