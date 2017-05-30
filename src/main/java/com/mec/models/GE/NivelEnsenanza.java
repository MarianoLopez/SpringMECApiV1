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
@Table(name = "NivelEnsenanza",schema = "Matricula")
public class NivelEnsenanza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelEnsenanzaId")
    private Integer nivelEnsenanzaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Mnemo")
    private String mnemo;
    @Column(name = "idNivelEducativo")
    private Integer idNivelEducativo;

    public NivelEnsenanza() {
    }

    public NivelEnsenanza(Integer nivelEnsenanzaId) {
        this.nivelEnsenanzaId = nivelEnsenanzaId;
    }

    public NivelEnsenanza(Integer nivelEnsenanzaId, String descripcion, String mnemo) {
        this.nivelEnsenanzaId = nivelEnsenanzaId;
        this.descripcion = descripcion;
        this.mnemo = mnemo;
    }

    public Integer getNivelEnsenanzaId() {
        return nivelEnsenanzaId;
    }

    public void setNivelEnsenanzaId(Integer nivelEnsenanzaId) {
        this.nivelEnsenanzaId = nivelEnsenanzaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMnemo() {
        return mnemo;
    }

    public void setMnemo(String mnemo) {
        this.mnemo = mnemo;
    }

    public Integer getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(Integer idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivelEnsenanzaId != null ? nivelEnsenanzaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEnsenanza)) {
            return false;
        }
        NivelEnsenanza other = (NivelEnsenanza) object;
        if ((this.nivelEnsenanzaId == null && other.nivelEnsenanzaId != null) || (this.nivelEnsenanzaId != null && !this.nivelEnsenanzaId.equals(other.nivelEnsenanzaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.GE.NivelEnsenanza[ nivelEnsenanzaId=" + nivelEnsenanzaId + " ]";
    }
    
}
