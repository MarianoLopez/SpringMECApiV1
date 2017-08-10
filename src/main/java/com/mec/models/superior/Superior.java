/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.superior;

/**
 *
 * @author Mariano
 */
public class Superior {
    private String cueAnexo;
    private String nombreCarrera;

    public String getCueAnexo() {
        return cueAnexo;
    }

    public void setCueAnexo(String cueAnexo) {
        this.cueAnexo = cueAnexo;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Superior(String cueAnexo, String nombreCarrera) {
        this.cueAnexo = cueAnexo;
        this.nombreCarrera = nombreCarrera;
    }
    
    
}
