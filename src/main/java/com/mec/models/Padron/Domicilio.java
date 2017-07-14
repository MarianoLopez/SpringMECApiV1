/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mec.models.Pof2.Geoposicion;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "domicilio")
@JsonPropertyOrder({"id","calle","nro","barrio","codPostal","referencia","geo","calleFondo","calleDerecha","calleIzquierda","localidad"})
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    //@JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_domicilio")
    private Integer idDomicilio;
    @Size(max = 2147483647)
    @Column(name = "calle")
    private String calle;
    @Size(max = 2147483647)
    @Column(name = "nro")
    private String nro;
    @Size(max = 2147483647)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 2147483647)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 2147483647)
    @Column(name = "cod_postal")
    private String codPostal;
    @Size(max = 2147483647)
    @Column(name = "cui")
    private String cui;
    /*@Size(max = 2147483647)
    @Column(name = "radio")
    private String radio;
    @Size(max = 2147483647)
    @Column(name = "fraccion")
    private String fraccion;*/
    @Size(max = 2147483647)
    @Column(name = "calle_fondo")
    private String calleFondo;
    @Size(max = 2147483647)
    @Column(name = "calle_derecha")
    private String calleDerecha;
    @Size(max = 2147483647)
    @Column(name = "calle_izquierda")
    private String calleIzquierda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    /*@Column(name = "x_longitud")
    private Double xLongitud;
    @Column(name = "y_latitud")
    private Double yLatitud;*/
     
    @Transient //The transient keyword in Java is used to indicate that a field should not be serialized. (hibernate)
    @JsonSerialize//jackson
    @JsonDeserialize
    private Geoposicion geo = null;
    @JoinColumn(name = "c_localidad", referencedColumnName = "c_localidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocalidadTipo localidad;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date fechaActualizacion;
    

    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domicilio(Integer idDomicilio, Date fechaActualizacion) {
        this.idDomicilio = idDomicilio;
        this.fechaActualizacion = fechaActualizacion;
    }

    public LocalidadTipo getLocalidad() {
        return localidad;
    }

    public void setLocalidad(LocalidadTipo localidad) {
        this.localidad = localidad;
    }
    
    
    public Geoposicion getGeo() {
        return geo;
    }

    public void setGeo(Geoposicion geo) {
        this.geo = geo;
    }
    
    
    public Integer getId() {
        return idDomicilio;
    }

    public void setId(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    /*public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getFraccion() {
        return fraccion;
    }

    public void setFraccion(String fraccion) {
        this.fraccion = fraccion;
    }*/

    public String getCalleFondo() {
        return calleFondo;
    }

    public void setCalleFondo(String calleFondo) {
        this.calleFondo = calleFondo;
    }

    public String getCalleDerecha() {
        return calleDerecha;
    }

    public void setCalleDerecha(String calleDerecha) {
        this.calleDerecha = calleDerecha;
    }

    public String getCalleIzquierda() {
        return calleIzquierda;
    }

    public void setCalleIzquierda(String calleIzquierda) {
        this.calleIzquierda = calleIzquierda;
    }

    /*public Double getXLongitud() {
        return xLongitud;
    }

    public void setXLongitud(Double xLongitud) {
        this.xLongitud = xLongitud;
    }

    public Double getYLatitud() {
        return yLatitud;
    }

    public void setYLatitud(Double yLatitud) {
        this.yLatitud = yLatitud;
    }*/

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomicilio != null ? idDomicilio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.idDomicilio == null && other.idDomicilio != null) || (this.idDomicilio != null && !this.idDomicilio.equals(other.idDomicilio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.Domicilio[ idDomicilio=" + idDomicilio + " ]";
    }
    
}
