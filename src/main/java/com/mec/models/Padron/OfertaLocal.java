/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Where;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "oferta_local")
@NamedQueries({
    @NamedQuery(name = "OfertaLocal.findAll", query = "SELECT o FROM OfertaLocal o")})
public class OfertaLocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oferta_local")
    private Integer idOfertaLocal;
    
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)   
    @JoinColumn(name = "id_localizacion")
    @Where(clause = "fecha_baja is null")
    private Localizacion localizacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    
    /*@Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;*/
    /*@Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;*/
    @Column(name = "matricula_total")
    private Integer matriculaTotal;
    /*@Size(max = 2147483647)
    @Column(name = "codigo_jurisdiccional")
    private String codigoJurisdiccional;*/
    /*@Basic(optional = false)
    @NotNull
    @Column(name = "c_estado")
    private short cEstado;*/
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_jornada")
    private short cJornada;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_oferta")
    private short cOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_subvencion")
    private short cSubvencion;

    public OfertaLocal() {
    }

    public OfertaLocal(Integer idOfertaLocal) {
        this.idOfertaLocal = idOfertaLocal;
    }


    public Integer getId() {
        return idOfertaLocal;
    }

    public void setId(Integer idOfertaLocal) {
        this.idOfertaLocal = idOfertaLocal;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
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

    public Integer getMatriculaTotal() {
        return matriculaTotal;
    }

    public void setMatriculaTotal(Integer matriculaTotal) {
        this.matriculaTotal = matriculaTotal;
    }

    public short getcJornada() {
        return cJornada;
    }

    public void setcJornada(short cJornada) {
        this.cJornada = cJornada;
    }

    public short getcOferta() {
        return cOferta;
    }

    public void setcOferta(short cOferta) {
        this.cOferta = cOferta;
    }

    public short getcSubvencion() {
        return cSubvencion;
    }

    public void setcSubvencion(short cSubvencion) {
        this.cSubvencion = cSubvencion;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfertaLocal != null ? idOfertaLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaLocal)) {
            return false;
        }
        OfertaLocal other = (OfertaLocal) object;
        if ((this.idOfertaLocal == null && other.idOfertaLocal != null) || (this.idOfertaLocal != null && !this.idOfertaLocal.equals(other.idOfertaLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.OfertaLocal[ idOfertaLocal=" + idOfertaLocal + " ]";
    }
    
}
