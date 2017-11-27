/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Models.ConexionesEscuelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mariano
 */
@Embeddable
public class ElectricidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CUE")
    private String cue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Anexo")
    private short anexo;

    public ElectricidadPK() {
    }

    public ElectricidadPK(String cue, short anexo) {
        this.cue = cue;
        this.anexo = anexo;
    }

    public String getCue() {
        return cue;
    }

    public void setCue(String cue) {
        this.cue = cue;
    }

    public short getAnexo() {
        return anexo;
    }

    public void setAnexo(short anexo) {
        this.anexo = anexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cue != null ? cue.hashCode() : 0);
        hash += (int) anexo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElectricidadPK)) {
            return false;
        }
        ElectricidadPK other = (ElectricidadPK) object;
        if ((this.cue == null && other.cue != null) || (this.cue != null && !this.cue.equals(other.cue))) {
            return false;
        }
        if (this.anexo != other.anexo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.Models.ConexionesEscuelas.ElectricidadPK[ cue=" + cue + ", anexo=" + anexo + " ]";
    }
    
}
