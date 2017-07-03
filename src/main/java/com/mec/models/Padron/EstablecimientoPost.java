/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "establecimiento",catalog = "padron",schema = "public")
public class EstablecimientoPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_establecimiento")
    private Integer idEstablecimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cue")
    private String cue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @JoinColumn(name = "c_categoria", referencedColumnName = "c_categoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaTipo cCategoria;
    @JoinColumn(name = "c_dependencia", referencedColumnName = "c_dependencia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DependenciaTipo cDependencia;
    @JoinColumn(name = "c_estado", referencedColumnName = "c_estado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoTipo cEstado;
    
    @JoinColumn(name = "c_sector", referencedColumnName = "c_sector")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SectorTipo cSector;
   

    public EstablecimientoPost() {
    }

    public EstablecimientoPost(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public EstablecimientoPost(Integer idEstablecimiento, String cue, String nombre, Date fechaCreacion, Date fechaActualizacion) {
        this.idEstablecimiento = idEstablecimiento;
        this.cue = cue;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getCue() {
        return cue;
    }

    public void setCue(String cue) {
        this.cue = cue;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public CategoriaTipo getCCategoria() {
        return cCategoria;
    }

    public void setCCategoria(CategoriaTipo cCategoria) {
        this.cCategoria = cCategoria;
    }

    public DependenciaTipo getCDependencia() {
        return cDependencia;
    }

    public void setCDependencia(DependenciaTipo cDependencia) {
        this.cDependencia = cDependencia;
    }

    public EstadoTipo getCEstado() {
        return cEstado;
    }

    public void setCEstado(EstadoTipo cEstado) {
        this.cEstado = cEstado;
    }

    public SectorTipo getCSector() {
        return cSector;
    }

    public void setCSector(SectorTipo cSector) {
        this.cSector = cSector;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstablecimiento != null ? idEstablecimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstablecimientoPost)) {
            return false;
        }
        EstablecimientoPost other = (EstablecimientoPost) object;
        if ((this.idEstablecimiento == null && other.idEstablecimiento != null) || (this.idEstablecimiento != null && !this.idEstablecimiento.equals(other.idEstablecimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.Establecimiento[ idEstablecimiento=" + idEstablecimiento + " ]";
    }
    
}
