/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder({"id"})
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
    @Column(name = "fecha_creacion",columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date fechaActualizacion;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @JsonFormat(pattern = "dd-MM-yyyy")
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

    public Integer getId() {
        return idEstablecimiento;
    }

    public void setId(Integer idEstablecimiento) {
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

    public CategoriaTipo getCategoria() {
        return cCategoria;
    }

    public void setCategoria(CategoriaTipo cCategoria) {
        this.cCategoria = cCategoria;
    }

    public DependenciaTipo getDependencia() {
        return cDependencia;
    }

    public void setDependencia(DependenciaTipo cDependencia) {
        this.cDependencia = cDependencia;
    }

    public EstadoTipo getEstado() {
        return cEstado;
    }

    public void setEstado(EstadoTipo cEstado) {
        this.cEstado = cEstado;
    }

    public SectorTipo getSector() {
        return cSector;
    }

    public void setSector(SectorTipo cSector) {
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
