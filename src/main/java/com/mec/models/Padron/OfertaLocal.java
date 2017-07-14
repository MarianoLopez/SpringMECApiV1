/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "oferta_local")
@JsonPropertyOrder({"id","oferta"})
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
    private Localizacion localizacion;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="c_oferta", insertable = false,updatable = false)
    private OfertaTipo ofertaTipo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="c_jornada", insertable = false,updatable = false)
    private JornadaTipo jornada;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion",columnDefinition = "date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
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

    public OfertaTipo getOferta() {
        return ofertaTipo;
    }

    public void setOferta(OfertaTipo ofertaTipo) {
        this.ofertaTipo = ofertaTipo;
    }

    public JornadaTipo getJornada() {
        return jornada;
    }

    public void setJornada(JornadaTipo jornada) {
        this.jornada = jornada;
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
