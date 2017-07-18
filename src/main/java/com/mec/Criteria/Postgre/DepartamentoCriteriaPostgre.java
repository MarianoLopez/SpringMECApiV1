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
    /*
        verificar http://localhost:8080/API/v2/establecimientos?departamentos=215
        http://localhost:8080/API/v2/establecimientos/1801705
        solo filtra saladas "215"
    
    */
    @Override
    public List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos, Integer[] IDs) {
        List<EstablecimientoPost> filter = new ArrayList<>();
        List<Integer> list = Arrays.asList(IDs);
        establecimientos.forEach((establecimiento) -> {
            List<Localizacion> localizaciones = establecimiento.getLocalizacion();
            if(localizaciones!=null){
                boolean insert = false;
                List<Localizacion> localizaciones_filter = new ArrayList<>();//para los anexos que cumplen el criterio
                for(Localizacion localizacion: localizaciones){
                    List<Domicilio> domicilios = localizacion.getDomicilios();
                    if(domicilios!=null){
                        List<Domicilio> domicilios_filter = new ArrayList<>();//para los los domicilios que cumplen el criterio de los establecimientos
                        for(Domicilio domicilio: domicilios){
                            LocalidadTipo localidad = domicilio.getLocalidad();
                            if(localidad!=null){
                                DepartamentoTipo departamento = localidad.getDepartamento();
                                if(departamento!=null&&list.contains(departamento.getId())){
                                    //filter.add(establecimiento);
                                    domicilios_filter.add(domicilio);//domicilio en ese departamento
                                    insert=true;
                                }
                            }
                        }
                        if(!domicilios_filter.isEmpty()){
                            localizacion.setDomicilios(domicilios_filter);
                            localizaciones_filter.add(localizacion);
                        }
                    }
                }//localizaciones
                if(insert){
                    establecimiento.setLocalizacion(localizaciones_filter);
                    filter.add(establecimiento);}//agregar establecimiento
            }
        });
      
        return filter;
    }
    
}
