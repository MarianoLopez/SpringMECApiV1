/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria;

import com.mec.models.LuTrab;
import com.mec.models.LuTrabRegimen;
import com.mec.models.NivelJur;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MarianoLopez
 */
public class JurisdiccionCriteria implements EstablecimientosCriteria{
    @Override
    public List<LuTrab> filterCriteria(List<LuTrab> establecimientos, Integer[] IDs) {
        List<LuTrab> filtro = new ArrayList<>();
        List<Integer> list = Arrays.asList(IDs);
        establecimientos.forEach((establecimiento) -> {
            NivelJur jurisdiccion = establecimiento.getNivelJurisdiccional();
            if (jurisdiccion!=null&&list.contains(jurisdiccion.getId())) {
                filtro.add(establecimiento);
            }
        });
        return filtro;
    }
    
}
