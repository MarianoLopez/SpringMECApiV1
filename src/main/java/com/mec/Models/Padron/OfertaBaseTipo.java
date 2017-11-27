/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Models.Padron;

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
@Table(name = "oferta_base_tipo")
@JsonPropertyOrder({"id","descripcion"})
public class OfertaBaseTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_oferta_base")
    private Short cOfertaBase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    /*@Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private short orden;
    @Size(max = 2147483647)
    @Column(name = "corto")
    private String corto;*/

    public OfertaBaseTipo() {
    }

    public OfertaBaseTipo(Short cOfertaBase) {
        this.cOfertaBase = cOfertaBase;
    }

    /*public OfertaBaseTipo(Short cOfertaBase, String descripcion, short orden) {
        this.cOfertaBase = cOfertaBase;
        this.descripcion = descripcion;
        this.orden = orden;
    }*/

    public Short getId() {
        return cOfertaBase;
    }

    public void setId(Short cOfertaBase) {
        this.cOfertaBase = cOfertaBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   /* public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public String getCorto() {
        return corto;
    }

    public void setCorto(String corto) {
        this.corto = corto;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cOfertaBase != null ? cOfertaBase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaBaseTipo)) {
            return false;
        }
        OfertaBaseTipo other = (OfertaBaseTipo) object;
        if ((this.cOfertaBase == null && other.cOfertaBase != null) || (this.cOfertaBase != null && !this.cOfertaBase.equals(other.cOfertaBase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.Models.Padron.OfertaBaseTipo[ cOfertaBase=" + cOfertaBase + " ]";
    }
    
}
