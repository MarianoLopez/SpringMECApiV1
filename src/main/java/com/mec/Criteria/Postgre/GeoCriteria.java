package com.mec.Criteria.Postgre;

import com.mec.Util.GeoDistance;
import com.mec.models.Padron.Domicilio;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.Padron.Localizacion;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class GeoCriteria {
    public static List<EstablecimientoPost> criteria(List<EstablecimientoPost> establecimientos, float my_lat, float my_lon, double distanceKM){
        GeoDistance gd = new GeoDistance(my_lat,my_lon);
        //asd
        return establecimientos.stream()
                .filter(e->{
                    List<Localizacion> loct = e.getLocalizacion().stream()
                            .filter(l->{
                                List<Domicilio> d = l.getDomicilios().stream()
                                        .filter(dom -> dom.getGeo()!=null&&gd.getDistanceTo(((BigDecimal)dom.getGeo().getLatitud()).floatValue(),((BigDecimal)dom.getGeo().getLongitud()).floatValue())<=distanceKM)
                                        .collect(Collectors.toList());//filtrado a lista
                                if(d.size()>0){l.setDomicilios(d);return true;}else{return false;}//si posee domicilios despues del filtrado
                            }).collect(Collectors.toList());
                    if(loct.size()>0){e.setLocalizacion(loct);return true;}else{return false;}
                }).collect(Collectors.toList());
    }
}
