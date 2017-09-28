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
public class EstablecimientoDTO {
    private String nombre;
    private String anexo;

    public EstablecimientoDTO(String nombre, String anexo) {
        this.nombre = nombre;
        this.anexo = anexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }
    
    
    
}
