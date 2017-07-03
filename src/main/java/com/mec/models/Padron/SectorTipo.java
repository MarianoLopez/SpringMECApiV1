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
@Table(name = "sector_tipo")
@NamedQueries({
    @NamedQuery(name = "SectorTipo.findAll", query = "SELECT s FROM SectorTipo s")})
public class SectorTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_sector")
    private Short cSector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "orden")
    private Short orden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cSector", fetch = FetchType.LAZY)
    private List<EstablecimientoPost> establecimientoList;

    public SectorTipo() {
    }

    public SectorTipo(Short cSector) {
        this.cSector = cSector;
    }

    public SectorTipo(Short cSector, String descripcion) {
        this.cSector = cSector;
        this.descripcion = descripcion;
    }

    public Short getCSector() {
        return cSector;
    }

    public void setCSector(Short cSector) {
        this.cSector = cSector;
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
        hash += (cSector != null ? cSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectorTipo)) {
            return false;
        }
        SectorTipo other = (SectorTipo) object;
        if ((this.cSector == null && other.cSector != null) || (this.cSector != null && !this.cSector.equals(other.cSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.SectorTipo[ cSector=" + cSector + " ]";
    }
    
}
