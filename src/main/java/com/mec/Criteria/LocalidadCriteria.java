/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria;

import com.mec.models.Pof2.Localidad;
import com.mec.models.Pof2.LuTrab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MarianoLopez
 */
public class LocalidadCriteria implements EstablecimientosCriteria{

    @Override
    public List<LuTrab> filterCriteria(List<LuTrab> establecimientos, Integer[] IDs) {
        List<LuTrab> filtro = new ArrayList<>();
        List<Integer> list = Arrays.asList(IDs);
        
        establecimientos.forEach((establecimiento) -> {
            Localidad localidad = establecimiento.getLocalidad();
            if (localidad!=null&&list.contains(localidad.getId())) {
                filtro.add(establecimiento);
            }   
        });
        
        return filtro;
    }
    
}
