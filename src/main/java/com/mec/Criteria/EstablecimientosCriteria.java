/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria;

import com.mec.models.Pof2.LuTrab;
import java.util.List;

/**
 *
 * @author MarianoLopez
 */
public interface EstablecimientosCriteria {
    public List<LuTrab> filterCriteria(List<LuTrab> establecimientos,Integer[] IDs);
}
