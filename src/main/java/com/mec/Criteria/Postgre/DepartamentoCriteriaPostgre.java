/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria.Postgre;

import com.mec.models.Padron.DepartamentoTipo;
import com.mec.models.Padron.Domicilio;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Padron.LocalidadTipo;
import com.mec.models.Padron.Localizacion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 36194445
 */
public class DepartamentoCriteriaPostgre implements EstablecimientosCriteriaPostgre{

    @Override
    public List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos, Integer[] IDs) {
        List<EstablecimientoPost> filter = new ArrayList<>();
        List<Integer> list = Arrays.asList(IDs);
        establecimientos.forEach((establecimiento) -> {
            List<Localizacion> localizaciones = establecimiento.getLocalizacion();
            if(localizaciones!=null){
                boolean insert = true;//mismo establecimiento, multiples localizaciones
                for(Localizacion localizacion: localizaciones){
                    List<Domicilio> domicilios = localizacion.getDomicilios();
                    if(domicilios!=null){
                        for(Domicilio domicilio: domicilios){
                            LocalidadTipo localidad = domicilio.getLocalidad();
                            if(localidad!=null){
                                DepartamentoTipo departamento = localidad.getDepartamento();
                                if(departamento!=null&&list.contains(departamento.getId())&&insert){
                                    filter.add(establecimiento);
                                    insert=false;
                                }
                            }
                        }
                    }
                }
            }
        });
        return filter;
    }
    
}
