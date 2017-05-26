/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;


/**
 *
 * @author MarianoLopez
 */
@JsonPropertyOrder({"latitud","longitud","zoom"})
public class Geoposicion{

    @ApiModelProperty(notes = "CueAnexo del Establecimiento",dataType = "Integer",required = true)
    @JsonIgnore
    @Column(name = "cueanexo")
    private Object cueanexo;
    
    @ApiModelProperty(notes = "Longitud del Establecimiento",dataType = "float",required = true)
    @Column(name = "Longitud")
    private Object longitud;
    
    @ApiModelProperty(notes = "Latitud del Establecimiento",dataType = "float",required = true)
    @Column(name = "Latitud")
    private Object latitud;
    
    @ApiModelProperty(notes = "Nivel de Zoom",dataType = "Integer",required = true)
    //@JsonIgnore
    @Column(name = "Zoom")
    private Object zoom;
    
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
        return longitud;
    }

    public void setLongitud(Object Longitud) {
        this.longitud = Longitud;
    }

    public Object getLatitud() {
        return latitud;
    }

    public void setLatitud(Object Latitud) {
        this.latitud = Latitud;
    }

    public Object getZoom() {
        return zoom;
    }

    public void setZoom(Object Zoom) {
        this.zoom = Zoom;
    }
   
    
}
