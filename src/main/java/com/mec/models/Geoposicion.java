/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;

/**
 *
 * @author MarianoLopez
 */
@JsonPropertyOrder({"lon","lat"})
public class Geoposicion{
    
    @Column(name = "x")
    @JsonProperty("lat")
    private Object x;
    
    @JsonProperty("lon")
    @Column(name = "y")
    private Object y;
    
    @JsonIgnore
    @Column(name = "zoom")
    private Object zoom;
    
    public Geoposicion(){
        
    }
    public Geoposicion(Object x, Object y, Object zoom) {
        this.x = x;
        this.y = y;
        this.zoom = zoom;
    }
    
    public Object getZoom(){
        return this.zoom;
    }
    public void setZoom(Object obj){
        this.zoom = obj;
    }
    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x+","+y;
    }
    
    
}
