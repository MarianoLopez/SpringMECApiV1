/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.GE;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "Ambito",schema = "infra")
public class Ambito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AmbitoId")
    private Integer ambitoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Descripcion")
    private String descripcion;
    

    public Ambito() {
    }

    public Ambito(Integer ambitoId) {
        this.ambitoId = ambitoId;
    }

    public Ambito(Integer ambitoId, String descripcion) {
        this.ambitoId = ambitoId;
        this.descripcion = descripcion;
    }

    public Integer getAmbitoId() {
        return ambitoId;
    }

    public void setAmbitoId(Integer ambitoId) {
        this.ambitoId = ambitoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ambitoId != null ? ambitoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambito)) {
            return false;
        }
        Ambito other = (Ambito) object;
        if ((this.ambitoId == null && other.ambitoId != null) || (this.ambitoId != null && !this.ambitoId.equals(other.ambitoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.GE.Ambito[ ambitoId=" + ambitoId + " ]";
    }
    
}
