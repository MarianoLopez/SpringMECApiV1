/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria.Padron;

import com.mec.Criteria.EstablecimientosCriteria;
import com.mec.Models.Padron.EstablecimientoPost;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 36194445
 */
public class SectorCriteria implements EstablecimientosCriteria {

    @Override
    public List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos, Integer[] IDs) {
       List<Integer> list = Arrays.asList(IDs);
        return establecimientos.stream()
            .filter(e->e.getSector()!=null&&list.contains(e.getSector().getId().intValue()))
            .collect(Collectors.toList());
    }
    
}
