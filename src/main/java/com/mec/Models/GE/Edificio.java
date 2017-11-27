/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Models.GE;

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
    private Integer id;
    
    @Size(max = 150)
    @Column(name = "Domicilio")
    private String domicilio;
    @Size(max = 10)
    @Column(name = "CUI")
    private String cui;
   
    @JoinColumn(name = "AmbitoId", referencedColumnName = "AmbitoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ambito ambito;
    
    /*@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edificioId", fetch = FetchType.LAZY)
    private List<EstablecimientoEdificio> establecimientoEdificioList;*/

    public Edificio() {
    }

    public Edificio(Integer edificioId) {
        this.id = edificioId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer edificioId) {
        this.id = edificioId;
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

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbitoId(Ambito ambitoId) {
        this.ambito = ambitoId;
    }

    /*public List<EstablecimientoEdificio> getEstablecimientoEdificioList() {
        return establecimientoEdificioList;
    }

    public void setEstablecimientoEdificioList(List<EstablecimientoEdificio> establecimientoEdificioList) {
        this.establecimientoEdificioList = establecimientoEdificioList;
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
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.Models.GE.Edificio[ edificioId=" + id + " ]";
    }
    
}
