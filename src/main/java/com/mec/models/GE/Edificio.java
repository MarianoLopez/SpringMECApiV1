/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.GE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "Edificio",schema = "infra")
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EdificioId")
    private Integer edificioId;
    
    @Size(max = 150)
    @Column(name = "Domicilio")
    private String domicilio;
    @Size(max = 10)
    @Column(name = "CUI")
    private String cui;
   
    @JoinColumn(name = "AmbitoId", referencedColumnName = "AmbitoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ambito ambitoId;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edificioId", fetch = FetchType.LAZY)
    private List<EstablecimientoEdificio> establecimientoEdificioList;

    public Edificio() {
    }

    public Edificio(Integer edificioId) {
        this.edificioId = edificioId;
    }

    public Integer getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(Integer edificioId) {
        this.edificioId = edificioId;
    }

 

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public Ambito getAmbitoId() {
        return ambitoId;
    }

    public void setAmbitoId(Ambito ambitoId) {
        this.ambitoId = ambitoId;
    }

    public List<EstablecimientoEdificio> getEstablecimientoEdificioList() {
        return establecimientoEdificioList;
    }

    public void setEstablecimientoEdificioList(List<EstablecimientoEdificio> establecimientoEdificioList) {
        this.establecimientoEdificioList = establecimientoEdificioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edificioId != null ? edificioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.edificioId == null && other.edificioId != null) || (this.edificioId != null && !this.edificioId.equals(other.edificioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.GE.Edificio[ edificioId=" + edificioId + " ]";
    }
    
}
