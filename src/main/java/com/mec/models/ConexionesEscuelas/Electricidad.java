/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.ConexionesEscuelas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mariano
 */
@Entity
@Table(name = "electricidad")
@NamedQueries({
    @NamedQuery(name = "Electricidad.findAll", query = "SELECT e FROM Electricidad e")})
public class Electricidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ElectricidadPK electricidadPK;
    @Column(name = "TieneElectricidad")
    private Boolean tieneElectricidad;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Electricidad() {
    }

    public Electricidad(ElectricidadPK electricidadPK) {
        this.electricidadPK = electricidadPK;
    }

    public Electricidad(String cue, short anexo) {
        this.electricidadPK = new ElectricidadPK(cue, anexo);
    }

    public ElectricidadPK getElectricidadPK() {
        return electricidadPK;
    }

    public void setElectricidadPK(ElectricidadPK electricidadPK) {
        this.electricidadPK = electricidadPK;
    }

    public Boolean getTieneElectricidad() {
        return tieneElectricidad;
    }

    public void setTieneElectricidad(Boolean tieneElectricidad) {
        this.tieneElectricidad = tieneElectricidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (electricidadPK != null ? electricidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Electricidad)) {
            return false;
        }
        Electricidad other = (Electricidad) object;
        if ((this.electricidadPK == null && other.electricidadPK != null) || (this.electricidadPK != null && !this.electricidadPK.equals(other.electricidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.ConexionesEscuelas.Electricidad[ electricidadPK=" + electricidadPK + " ]";
    }
    
}
