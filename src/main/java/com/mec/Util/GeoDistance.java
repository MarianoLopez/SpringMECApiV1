/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Util;

/**
 *
 * @author Mariano
 */
public class GeoDistance {
    
    private float my_lat;
    private float my_lon;

    public GeoDistance(float my_lat, float my_lon) {
        this.my_lat = my_lat;
        this.my_lon = my_lon;
    }

    public float getMy_lat() {
        return my_lat;
    }

    public void setMy_lat(float my_lat) {
        this.my_lat = my_lat;
    }

    public float getMy_lon() {
        return my_lon;
    }

    public void setMy_lon(float my_lon) {
        this.my_lon = my_lon;
    }
    
    
    public double getDistanceTo(float lat, float lon){
        double latitud_radianes = my_lat * Math.PI / 180;
        double to_latitud_radianes = lat * Math.PI / 180;
        double delta_longitud = (my_lon - lon) * Math.PI / 180;
        return (Math.acos(
                Math.sin(latitud_radianes)
                * Math.sin(to_latitud_radianes)
                + Math.cos(latitud_radianes)
                * Math.cos(to_latitud_radianes)
                * Math.cos(delta_longitud)
        ) * 180 / Math.PI)*100;
    }
}
