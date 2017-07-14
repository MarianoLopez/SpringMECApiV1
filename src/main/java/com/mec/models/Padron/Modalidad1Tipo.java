/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "modalidad1_tipo")
@JsonPropertyOrder({"id","descripcion"})
public class Modalidad1Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_modalidad1")
    private Short cModalidad1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    /*@Column(name = "orden")
    private Short orden;*/

    public Modalidad1Tipo() {
    }

    public Modalidad1Tipo(Short cModalidad1) {
        this.cModalidad1 = cModalidad1;
    }

    public Modalidad1Tipo(Short cModalidad1, String descripcion) {
        this.cModalidad1 = cModalidad1;
        this.descripcion = descripcion;
    }

    public Short getId() {
        return cModalidad1;
    }

    public void setId(Short cModalidad1) {
        this.cModalidad1 = cModalidad1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cModalidad1 != null ? cModalidad1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidad1Tipo)) {
            return false;
        }
        Modalidad1Tipo other = (Modalidad1Tipo) object;
        if ((this.cModalidad1 == null && other.cModalidad1 != null) || (this.cModalidad1 != null && !this.cModalidad1.equals(other.cModalidad1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.Modalidad1Tipo[ cModalidad1=" + cModalidad1 + " ]";
    }
    
}
