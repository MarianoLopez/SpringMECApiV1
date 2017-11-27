/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Criteria;

import com.mec.Models.Padron.EstablecimientoPost;
import java.util.List;

/**
 *
 * @author 36194445
 */
public interface EstablecimientosCriteria {
    public List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos,Integer[] IDs);
}
