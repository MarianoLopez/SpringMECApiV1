package com.mec.Criteria.ConexionesEscuelas;

import com.mec.Criteria.EstablecimientosCriteria;
import com.mec.Models.ConexionesEscuelas.Conexiones;
import com.mec.Models.Padron.EstablecimientoPost;
import com.mec.Models.Padron.Localizacion;

import java.util.List;
import java.util.stream.Collectors;

public class InternetCriteria {
    public static List<EstablecimientoPost> filterCriteria(List<EstablecimientoPost> establecimientos, Boolean state) {
        return establecimientos.stream()
                .filter(e->{
                    List<Localizacion> loct = e.getLocalizacion().stream()
                            .filter(l->{
                                List<Conexiones> conexiones = l.getConexiones().stream()
                                        .filter(c->c.getActivo()==state)
                                        .collect(Collectors.toList());
                                if(conexiones.size()>0){l.setConexiones(conexiones);return true;}else{return false;}
                            })
                            .collect(Collectors.toList());//filtrado a lista
                    if(loct.size()>0){e.setLocalizacion(loct);return true;}else{return false;}
                }).collect(Collectors.toList());
    }
}
