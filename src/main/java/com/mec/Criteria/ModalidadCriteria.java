/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria;

import com.mec.models.Pof2.LuTrab;
import com.mec.models.Pof2.Modali;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MarianoLopez
 */
public class ModalidadCriteria implements EstablecimientosCriteria{

    @Override
    public List<LuTrab> filterCriteria(List<LuTrab> establecimientos,Integer[] IDs) {
        List<LuTrab> filtro = new ArrayList<>();
        List<Integer> list = Arrays.asList(IDs);
        
        establecimientos.forEach((establecimiento) -> {
            Modali modalidad = establecimiento.getModalidad();
            if (modalidad!=null&&list.contains(modalidad.getId())) {
                filtro.add(establecimiento);
            }
        });
        
        return filtro;
    }
    
}
