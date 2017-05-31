/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.GE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "EstablecimientoDetalle")
@NamedQueries({
    @NamedQuery(name = "EstablecimientoDetalle.findAll", query = "SELECT e FROM EstablecimientoDetalle e")})
public class EstablecimientoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EstablecimientoDetalleId")
    private Integer establecimientoDetalleId;
    /*@Column(name = "Numero")
    private Short numero;
    @Size(max = 200)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "NombreEspecial")
    private String nombreEspecial;*/
    @Column(name = "OrganizacionId")
    private Integer organizacionId;
    @Column(name = "EstructuraOrganizativaId")
    private Integer estructuraOrganizativaId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "Email")
    private String email;
    @Size(max = 18)
    @Column(name = "Telefono")
    private String telefono;
    /*@Column(name = "Desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date desde;
    @Column(name = "Hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hasta;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "TieneJornadaExtendida")
    private Boolean tieneJornadaExtendida;
    @Size(max = 2147483647)
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "Cooperadora")
    private Boolean cooperadora;
    @Size(max = 250)
    @Column(name = "Patrocinador")
    private String patrocinador;
    @Column(name = "idLuTrab")
    private Integer idLuTrab;
    @Column(name = "TienePatrocinador")
    private Boolean tienePatrocinador;
    @Column(name = "LocalidadId")
    private Integer localidadId;
    @Column(name = "DepartamentoId")
    private Integer departamentoId;
    @Column(name = "TipoEntidadId")
    private Integer tipoEntidadId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FechaClausura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaClausura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsuarioId")
    private int usuarioId;*/
    /*@OneToMany(mappedBy = "establecimientoDetalleId", fetch = FetchType.LAZY)
    private List<Establecimiento> establecimientoList;*/
    
    @JsonIgnore
    @JoinColumn(name = "EstablecimientoId", referencedColumnName = "EstablecimientoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Establecimiento establecimientoId;


    public EstablecimientoDetalle() {
    }

    public EstablecimientoDetalle(Integer establecimientoDetalleId) {
        this.establecimientoDetalleId = establecimientoDetalleId;
    }

    public EstablecimientoDetalle(Integer establecimientoDetalleId, Date fechaCreacion, int usuarioId) {
        this.establecimientoDetalleId = establecimientoDetalleId;
        /*this.fechaCreacion = fechaCreacion;
        this.usuarioId = usuarioId;*/
    }

    public Integer getEstablecimientoDetalleId() {
        return establecimientoDetalleId;
    }

    public void setEstablecimientoDetalleId(Integer establecimientoDetalleId) {
        this.establecimientoDetalleId = establecimientoDetalleId;
    }

    /*public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEspecial() {
        return nombreEspecial;
    }

    public void setNombreEspecial(String nombreEspecial) {
        this.nombreEspecial = nombreEspecial;
    }*/

    public Integer getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Integer organizacionId) {
        this.organizacionId = organizacionId;
    }

    public Integer getEstructuraOrganizativaId() {
        return estructuraOrganizativaId;
    }

    public void setEstructuraOrganizativaId(Integer estructuraOrganizativaId) {
        this.estructuraOrganizativaId = estructuraOrganizativaId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   /* public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getTieneJornadaExtendida() {
        return tieneJornadaExtendida;
    }

    public void setTieneJornadaExtendida(Boolean tieneJornadaExtendida) {
        this.tieneJornadaExtendida = tieneJornadaExtendida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getCooperadora() {
        return cooperadora;
    }

    public void setCooperadora(Boolean cooperadora) {
        this.cooperadora = cooperadora;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Integer getIdLuTrab() {
        return idLuTrab;
    }

    public void setIdLuTrab(Integer idLuTrab) {
        this.idLuTrab = idLuTrab;
    }

    public Boolean getTienePatrocinador() {
        return tienePatrocinador;
    }

    public void setTienePatrocinador(Boolean tienePatrocinador) {
        this.tienePatrocinador = tienePatrocinador;
    }

    public Integer getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(Integer localidadId) {
        this.localidadId = localidadId;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Integer getTipoEntidadId() {
        return tipoEntidadId;
    }

    public void setTipoEntidadId(Integer tipoEntidadId) {
        this.tipoEntidadId = tipoEntidadId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaClausura() {
        return fechaClausura;
    }

    public void setFechaClausura(Date fechaClausura) {
        this.fechaClausura = fechaClausura;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }*/

   /* public List<Establecimiento> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<Establecimiento> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }*/

   

    public Establecimiento getEstablecimientoId() {
        return establecimientoId;
    }

    public void setEstablecimientoId(Establecimiento establecimientoId) {
        this.establecimientoId = establecimientoId;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (establecimientoDetalleId != null ? establecimientoDetalleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstablecimientoDetalle)) {
            return false;
        }
        EstablecimientoDetalle other = (EstablecimientoDetalle) object;
        if ((this.establecimientoDetalleId == null && other.establecimientoDetalleId != null) || (this.establecimientoDetalleId != null && !this.establecimientoDetalleId.equals(other.establecimientoDetalleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.GE.EstablecimientoDetalle[ establecimientoDetalleId=" + establecimientoDetalleId + " ]";
    }
    
}
