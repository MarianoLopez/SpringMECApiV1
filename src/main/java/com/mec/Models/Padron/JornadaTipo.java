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
@Table(name = "jornada_tipo")
@JsonPropertyOrder({"id","descripcion"})
public class JornadaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_jornada")
    private Short cJornada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    /*@Column(name = "orden")
    private Short orden;
    @Size(max = 2147483647)
    @Column(name = "cod_anterior")
    private String codAnterior;*/

    public JornadaTipo() {
    }

    public JornadaTipo(Short cJornada) {
        this.cJornada = cJornada;
    }

    public JornadaTipo(Short cJornada, String descripcion) {
        this.cJornada = cJornada;
        this.descripcion = descripcion;
    }

    public Short getId() {
        return cJornada;
    }

    public void setId(Short cJornada) {
        this.cJornada = cJornada;
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
    }

    public String getCodAnterior() {
        return codAnterior;
    }

    public void setCodAnterior(String codAnterior) {
        this.codAnterior = codAnterior;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cJornada != null ? cJornada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JornadaTipo)) {
            return false;
        }
        JornadaTipo other = (JornadaTipo) object;
        if ((this.cJornada == null && other.cJornada != null) || (this.cJornada != null && !this.cJornada.equals(other.cJornada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.Models.Padron.JornadaTipo[ cJornada=" + cJornada + " ]";
    }
    
}
