/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria;

import com.mec.models.Pof2.LuTrab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mariano
 */
public class CueAnexoCriteria{
    public List<LuTrab> filterCriteria(List<LuTrab> establecimientos, List<Integer> list) {
        List<LuTrab> filtro = new ArrayList<>();
        System.out.println("lista: "+list);
        establecimientos.forEach((establecimiento) -> {
            if(list.contains(establecimiento.getCue())&&establecimiento.getAnexo()== 0){
                filtro.add(establecimiento);
            }
        });
        return filtro;
    }
    
}
