package com.mec.Criteria.ConexionesEscuelas;

import com.mec.Criteria.EstablecimientosCriteria;
import com.mec.Models.ConexionesEscuelas.Conexiones;
import com.mec.Models.Padron.EstablecimientoPost;
import com.mec.Models.Padron.Localizacion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProveedorCriteria implements EstablecimientosCriteria {
    @Override
    public List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos, Integer[] IDs) {
        List<Integer> list = Arrays.asList(IDs);
        return establecimientos.stream()
                .filter(e->{
                    List<Localizacion> loct = e.getLocalizacion().stream()
                            .filter(l->{
                                List<Conexiones> proveedores = l.getConexiones().stream()
                                        .filter(c->c.getProveedor()!=null && list.contains(c.getProveedor().getProveedorId()))
                                        .collect(Collectors.toList());
                                if(proveedores.size()>0){l.setConexiones(proveedores);return true;}else{return false;}
                            })
                            .collect(Collectors.toList());//filtrado a lista
                    if(loct.size()>0){e.setLocalizacion(loct);return true;}else{return false;}
                }).collect(Collectors.toList());
    }
}
