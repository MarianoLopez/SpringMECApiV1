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
                boolean insert = true;//el establecimiento puede tener más de 1 edificio, no se lo debe incluir n veces al establecimiento
                for(EstablecimientoEdificio e:edificios){
                    Edificio edificio = e.getEdificio();
                    if(edificio!=null){
                        Ambito ambito = edificio.getAmbito();
                        if(ambito!=null&&list.contains(ambito.getId())&&insert){
                            filtro.add(establecimiento);
                            insert=false;
                        }
                    }
                }
            }
        });
        return filtro;
    }
    
}
