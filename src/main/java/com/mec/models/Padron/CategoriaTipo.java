/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import com.mec.models.GE.Establecimiento;
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
@Table(name = "categoria_tipo")
@NamedQueries({
    @NamedQuery(name = "CategoriaTipo.findAll", query = "SELECT c FROM CategoriaTipo c")})
public class CategoriaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_categoria")
    private Short cCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "orden")
    private Short orden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoria", fetch = FetchType.LAZY)
    private List<EstablecimientoPost> establecimientoList;

    public CategoriaTipo() {
    }

    public CategoriaTipo(Short cCategoria) {
        this.cCategoria = cCategoria;
    }

    public CategoriaTipo(Short cCategoria, String descripcion) {
        this.cCategoria = cCategoria;
        this.descripcion = descripcion;
    }

    public Short getCCategoria() {
        return cCategoria;
    }

    public void setCCategoria(Short cCategoria) {
        this.cCategoria = cCategoria;
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
        hash += (cCategoria != null ? cCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaTipo)) {
            return false;
        }
        CategoriaTipo other = (CategoriaTipo) object;
        if ((this.cCategoria == null && other.cCategoria != null) || (this.cCategoria != null && !this.cCategoria.equals(other.cCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.CategoriaTipo[ cCategoria=" + cCategoria + " ]";
    }
    
}
