/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "estado_tipo")
@NamedQueries({
    @NamedQuery(name = "EstadoTipo.findAll", query = "SELECT e FROM EstadoTipo e")})
public class EstadoTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_estado")
    private Short cEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "orden")
    private Short orden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_estado")
    private Character codEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cEstado", fetch = FetchType.LAZY)
    private List<EstablecimientoPost> establecimientoList;

    public EstadoTipo() {
    }

    public EstadoTipo(Short cEstado) {
        this.cEstado = cEstado;
    }

    public EstadoTipo(Short cEstado, String descripcion, Character codEstado) {
        this.cEstado = cEstado;
        this.descripcion = descripcion;
        this.codEstado = codEstado;
    }

    public Short getCEstado() {
        return cEstado;
    }

    public void setCEstado(Short cEstado) {
        this.cEstado = cEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getOrden() {
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
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cEstado != null ? cEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoTipo)) {
            return false;
        }
        EstadoTipo other = (EstadoTipo) object;
        if ((this.cEstado == null && other.cEstado != null) || (this.cEstado != null && !this.cEstado.equals(other.cEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.EstadoTipo[ cEstado=" + cEstado + " ]";
    }
    
}
