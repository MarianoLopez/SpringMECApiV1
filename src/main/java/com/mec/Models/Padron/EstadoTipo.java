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
@Table(name = "estado_tipo")
@JsonPropertyOrder({"id"})
public class EstadoTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_estado")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    /*@Column(name = "orden")
    private Short orden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_estado")
    private Character codEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private List<EstablecimientoPost> establecimientoList;*/

    public EstadoTipo() {
    }

    public EstadoTipo(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
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

    public Character getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Character codEstado) {
        this.codEstado = codEstado;
    }

    public List<EstablecimientoPost> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<EstablecimientoPost> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoTipo)) {
            return false;
        }
        EstadoTipo other = (EstadoTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.Models.Padron.EstadoTipo[ id=" + id + " ]";
    }
    
}
