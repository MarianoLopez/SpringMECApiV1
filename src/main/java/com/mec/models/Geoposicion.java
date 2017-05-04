/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;


/**
 *
 * @author MarianoLopez
 */
@JsonPropertyOrder({"latitud","longitud","zoom"})
public class Geoposicion{

    @JsonIgnore
    @Column(name = "cueanexo")
    private Object cueanexo;
    
    @Column(name = "Longitud")
    private Object Longitud;
    
    
    @Column(name = "Latitud")
    private Object Latitud;
    
    //@JsonIgnore
    @Column(name = "Zoom")
    private Object Zoom;
    
    @JsonIgnore
    @Column(name = "CueAnexoAsociado")
    private Object CueAnexoAsociado;
    @JsonIgnore
    @Column(name = "Fecha")
    private Object Fecha;
    @JsonIgnore
    @Column(name = "idUsuario")
    private Object idUsuario;
     
    public Geoposicion(){
        
    }
    
    public Object getCueanexo() {
        return cueanexo;
    }

    public void setCueanexo(Object Cueanexo) {
        this.cueanexo = Cueanexo;
    }

    public Object getLongitud() {
        return Longitud;
    }

    public void setLongitud(Object Longitud) {
        this.Longitud = Longitud;
    }

    public Object getLatitud() {
        return Latitud;
    }

    public void setLatitud(Object Latitud) {
        this.Latitud = Latitud;
    }

    public Object getZoom() {
        return Zoom;
    }

    public void setZoom(Object Zoom) {
        this.Zoom = Zoom;
    }
   
    
}
