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
@Table(name = "dependencia_tipo")
@NamedQueries({
    @NamedQuery(name = "DependenciaTipo.findAll", query = "SELECT d FROM DependenciaTipo d")})
public class DependenciaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_dependencia")
    private Short cDependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "orden")
    private Short orden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDependencia", fetch = FetchType.LAZY)
    private List<EstablecimientoPost> establecimientoList;

    public DependenciaTipo() {
    }

    public DependenciaTipo(Short cDependencia) {
        this.cDependencia = cDependencia;
    }

    public DependenciaTipo(Short cDependencia, String descripcion) {
        this.cDependencia = cDependencia;
        this.descripcion = descripcion;
    }

    public Short getCDependencia() {
        return cDependencia;
    }

    public void setCDependencia(Short cDependencia) {
        this.cDependencia = cDependencia;
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

    public List<EstablecimientoPost> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<EstablecimientoPost> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDependencia != null ? cDependencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependenciaTipo)) {
            return false;
        }
        DependenciaTipo other = (DependenciaTipo) object;
        if ((this.cDependencia == null && other.cDependencia != null) || (this.cDependencia != null && !this.cDependencia.equals(other.cDependencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.DependenciaTipo[ cDependencia=" + cDependencia + " ]";
    }
    
}
