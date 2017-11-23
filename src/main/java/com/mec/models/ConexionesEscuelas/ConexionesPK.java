/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.ConexionesEscuelas;

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
public class ConexionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ConexionId")
    private int conexionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movimientoID")
    private int movimientoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CUE")
    private String cue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Anexo")
    private short anexo;

    public ConexionesPK() {
    }

    public ConexionesPK(int conexionId, int movimientoID, String cue, short anexo) {
        this.conexionId = conexionId;
        this.movimientoID = movimientoID;
        this.cue = cue;
        this.anexo = anexo;
    }

    public int getConexionId() {
        return conexionId;
    }

    public void setConexionId(int conexionId) {
        this.conexionId = conexionId;
    }

    public int getMovimientoID() {
        return movimientoID;
    }

    public void setMovimientoID(int movimientoID) {
        this.movimientoID = movimientoID;
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
        hash += (int) conexionId;
        hash += (int) movimientoID;
        hash += (cue != null ? cue.hashCode() : 0);
        hash += (int) anexo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConexionesPK)) {
            return false;
        }
        ConexionesPK other = (ConexionesPK) object;
        if (this.conexionId != other.conexionId) {
            return false;
        }
        if (this.movimientoID != other.movimientoID) {
            return false;
        }
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
        return "com.mec.models.ConexionesEscuelas.ConexionesPK[ conexionId=" + conexionId + ", movimientoID=" + movimientoID + ", cue=" + cue + ", anexo=" + anexo + " ]";
    }
    
}
