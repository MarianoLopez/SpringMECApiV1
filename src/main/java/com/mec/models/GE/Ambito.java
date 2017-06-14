/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.GE;

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
@Table(name = "Ambito",schema = "infra")
public class Ambito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AmbitoId")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Descripcion")
    private String descripcion;
    

    public Ambito() {
    }

    public Ambito(Integer ambitoId) {
        this.id = ambitoId;
    }

    public Ambito(Integer ambitoId, String descripcion) {
        this.id = ambitoId;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer ambitoId) {
        this.id = ambitoId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambito)) {
            return false;
        }
        Ambito other = (Ambito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.GE.Ambito[ ambitoId=" + id + " ]";
    }
    
}
