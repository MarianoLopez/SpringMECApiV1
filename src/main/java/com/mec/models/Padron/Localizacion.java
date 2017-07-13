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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "localizacion")
@JsonPropertyOrder({"anexo","nombre","ambito","domicilios"})
public class Localizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_localizacion")
    private Integer idLocalizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "anexo")
    private String anexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 2147483647)
    @Column(name = "telefono_cod_area")
    private String telefonoCodArea;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "sitio_web")
    private String sitioWeb;
    @Column(name = "sede")
    private Boolean sede;
    @Column(name = "sede_administrativa")
    private Boolean sedeAdministrativa;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JsonIgnore
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    /*@Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;*/
    @Size(max = 2147483647)
    @Column(name = "codigo_jurisdiccional")
    private String codigoJurisdiccional;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_establecimiento")
    @Where(clause = "fechaBaja is null")
    private EstablecimientoPost establecimiento;
    @JoinColumn(name = "c_ambito", referencedColumnName = "c_ambito")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AmbitoTipo cAmbito;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "localizacion_domicilio",
            joinColumns = {@JoinColumn(name = "id_localizacion")},inverseJoinColumns = {@JoinColumn(name = "id_domicilio")})
    private List<Domicilio> domicilios;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localizacion", fetch = FetchType.LAZY)
    private List<OfertaLocal> ofertas;
    
    
  
    public Localizacion() {
    }

    public Localizacion(Integer idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public List<OfertaLocal> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertaLocal> ofertas) {
        this.ofertas = ofertas;
    }

    
    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    /*public Geoposicion getGeo() {
        return geo;
    }

    public void setGeo(Geoposicion geo) {
        this.geo = geo;
    }*/
    
    

    /*public Localizacion(Integer idLocalizacion, String anexo, String nombre, Date fechaActualizacion, Date fechaCreacion) {
        this.idLocalizacion = idLocalizacion;
        this.anexo = anexo;
        this.nombre = nombre;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaCreacion = fechaCreacion;
    }*/

    public EstablecimientoPost getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(EstablecimientoPost establecimiento) {
        this.establecimiento = establecimiento;
    }
    
    

    public Integer getId() {
        return idLocalizacion;
    }

    public void setId(Integer idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoCodArea() {
        return telefonoCodArea;
    }

    public void setTelefonoCodArea(String telefonoCodArea) {
        this.telefonoCodArea = telefonoCodArea;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public Boolean getSede() {
        return sede;
    }

    public void setSede(Boolean sede) {
        this.sede = sede;
    }

    public Boolean getSedeAdministrativa() {
        return sedeAdministrativa;
    }

    public void setSedeAdministrativa(Boolean sedeAdministrativa) {
        this.sedeAdministrativa = sedeAdministrativa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    /*public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }*/

    public String getCodigoJurisdiccional() {
        return codigoJurisdiccional;
    }

    public void setCodigoJurisdiccional(String codigoJurisdiccional) {
        this.codigoJurisdiccional = codigoJurisdiccional;
    }

    public AmbitoTipo getAmbito() {
        return cAmbito;
    }

    public void setAmbito(AmbitoTipo cAmbito) {
        this.cAmbito = cAmbito;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalizacion != null ? idLocalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacion)) {
            return false;
        }
        Localizacion other = (Localizacion) object;
        if ((this.idLocalizacion == null && other.idLocalizacion != null) || (this.idLocalizacion != null && !this.idLocalizacion.equals(other.idLocalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.Localizacion_1[ idLocalizacion=" + idLocalizacion + " ]";
    }
    
}
