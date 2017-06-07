/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria;

import com.mec.models.GE.Ambito;
import com.mec.models.GE.Edificio;
import com.mec.models.GE.EstablecimientoEdificio;
import com.mec.models.Pof2.LuTrab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 36194445
 */
public class AmbitoCriteria implements EstablecimientosCriteria{

    @Override
    public List<LuTrab> filterCriteria(List<LuTrab> establecimientos, Integer[] IDs) {
        List<LuTrab> filtro = new ArrayList<>();
        List<Integer> list = Arrays.asList(IDs);
        establecimientos.forEach((establecimiento) -> {
            List <EstablecimientoEdificio> edificios = establecimiento.getEdificios();
            if(edificios!=null){
                edificios.forEach((e) -> {
                   Edificio edificio = e.getEdificioId();
                   if(edificio!=null){
                       Ambito ambito = edificio.getAmbitoId();
                       if(ambito!=null&&list.contains(ambito.getAmbitoId())){
                           filtro.add(establecimiento);
                       }
                   }
                });
            }
        });
        return filtro;
    }
    
}
