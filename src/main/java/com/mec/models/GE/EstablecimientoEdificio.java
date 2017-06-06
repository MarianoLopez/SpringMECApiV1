/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.GE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "EstablecimientoEdificio",schema = "infra")
public class EstablecimientoEdificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EstablecimientoEdificioId")
    private Integer establecimientoEdificioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EstablecimientoId")
    private int establecimientoId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "EsPrincipal")
    private boolean esPrincipal;
    
    
    @JoinColumn(name = "EdificioId", referencedColumnName = "EdificioId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Edificio edificioId;

    public EstablecimientoEdificio() {
    }

    public EstablecimientoEdificio(Integer establecimientoEdificioId) {
        this.establecimientoEdificioId = establecimientoEdificioId;
    }

    public EstablecimientoEdificio(Integer establecimientoEdificioId, int establecimientoId, boolean esPrincipal) {
        this.establecimientoEdificioId = establecimientoEdificioId;
        this.establecimientoId = establecimientoId;
        this.esPrincipal = esPrincipal;
    }

    public Integer getEstablecimientoEdificioId() {
        return establecimientoEdificioId;
    }

    public void setEstablecimientoEdificioId(Integer establecimientoEdificioId) {
        this.establecimientoEdificioId = establecimientoEdificioId;
    }

    public int getEstablecimientoId() {
        return establecimientoId;
    }

    public void setEstablecimientoId(int establecimientoId) {
        this.establecimientoId = establecimientoId;
    }

   

    public boolean getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(boolean esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    public Edificio getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(Edificio edificioId) {
        this.edificioId = edificioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (establecimientoEdificioId != null ? establecimientoEdificioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstablecimientoEdificio)) {
            return false;
        }
        EstablecimientoEdificio other = (EstablecimientoEdificio) object;
        if ((this.establecimientoEdificioId == null && other.establecimientoEdificioId != null) || (this.establecimientoEdificioId != null && !this.establecimientoEdificioId.equals(other.establecimientoEdificioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.GE.EstablecimientoEdificio[ establecimientoEdificioId=" + establecimientoEdificioId + " ]";
    }
    
}
