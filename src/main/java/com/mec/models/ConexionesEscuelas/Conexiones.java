/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.ConexionesEscuelas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mariano
 */
@Entity
@Table(name = "conexiones")
public class Conexiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @JsonIgnore
    protected ConexionesPK conexionesPK;
    @Column(name = "ProgramaId")
    private Integer programaId;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "Pago")
    private Boolean pago;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "ConexionTipoId", referencedColumnName = "ConexionTipoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Conexiontipo conexionTipoId;
    @JoinColumn(name = "movimientoID", referencedColumnName = "movimientoID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Movimiento movimiento;
    @JoinColumn(name = "ProveedorId", referencedColumnName = "ProveedorId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedores proveedorId;

    public Conexiones() {
    }

    public Conexiones(ConexionesPK conexionesPK) {
        this.conexionesPK = conexionesPK;
    }

    public Conexiones(int conexionId, int movimientoID, String cue, short anexo) {
        this.conexionesPK = new ConexionesPK(conexionId, movimientoID, cue, anexo);
    }

    public ConexionesPK getConexionesPK() {
        return conexionesPK;
    }

    public void setConexionesPK(ConexionesPK conexionesPK) {
        this.conexionesPK = conexionesPK;
    }

    public Integer getProgramaId() {
        return programaId;
    }

    public void setProgramaId(Integer programaId) {
        this.programaId = programaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Conexiontipo getConexionTipo() {
        return conexionTipoId;
    }

    public void setConexionTipo(Conexiontipo conexionTipoId) {
        this.conexionTipoId = conexionTipoId;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public Proveedores getProveedor() {
        return proveedorId;
    }

    public void setProveedor(Proveedores proveedorId) {
        this.proveedorId = proveedorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conexionesPK != null ? conexionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conexiones)) {
            return false;
        }
        Conexiones other = (Conexiones) object;
        if ((this.conexionesPK == null && other.conexionesPK != null) || (this.conexionesPK != null && !this.conexionesPK.equals(other.conexionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.ConexionesEscuelas.Conexiones[ conexionesPK=" + conexionesPK + " ]";
    }
    
}
