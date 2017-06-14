/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Pof2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mec.models.GE.EstablecimientoEdificio;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author MarianoLopez
 */
@Entity
@Table(name = "LuTrab")
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.ANY, setterVisibility = Visibility.NONE)
public class LuTrab implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(notes = "Identificador Unico DB",dataType = "Integer",required = true)
    @JsonIgnore
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @JsonProperty("id")//solo afecta al JSON
    @Column(name = "LuTrab")
    @NotNull
    private Integer luTrab;
    
    @ApiModelProperty(notes = "Código de Anexo del Establecimiento",dataType = "Integer",required = true,example = "00")
    @Column(name = "Anexo",columnDefinition = "TINYINT")
    private Integer anexo;
    
    @ApiModelProperty(notes = "Número del Establecimiento",dataType = "Integer",required = false,example = "12")
    @Column(name = "Numero",columnDefinition = "SMALLINT")
    private Integer numero;
    
    @ApiModelProperty(notes = "Nombre del Establecimiento",dataType = "String",required = true,example = "ESCUELA Nº 12 \\\"ALTE.GUILLERMO BROWN\\\"")
    @Size(max = 250)
    @Column(name = "Nombre")
    private String nombre;
    
    @ApiModelProperty(notes = "Nombre del Establecimiento sin número",dataType = "String",required = true,example = "ALTE.GUILLERMO BROWN")
    @Size(max = 250)
    @Column(name = "NombreEspecial")
    private String nombreEspecial;
    
    @ApiModelProperty(notes = "Clave Única Establecimiento de 7 digitos",dataType = "Integer",required = true,example = "1800386")
    @Column(name = "CUE")
    private Integer cue;
    
    /*@Column(name = "JA")
    private Character ja;*/
    
    /* Preguntar -> (** No Asignado**,Primera,Segunda,Tercera,Cuarta)
    @Column(name = "idLutrabCategoria",columnDefinition = "TINYINT")
    private Integer idLutrabCategoria;*/
    /* EJ: RI-2112/95
    @Size(max = 20)
    @Column(name = "NLCategEstab")
    private String nLCategEstab;*/
    /*@Column(name = "idTurno",columnDefinition = "TINYINT")
    private Integer idTurno;*/
    
    @JoinColumn(name = "idTurno", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Turno turno;
    
    /* nivel de?
    @Column(name = "Nivel")
    private Character nivel;
    */
    /*@Size(max = 2)
    @Column(name = "Modali",columnDefinition = "CHAR")
    private Integer modali;*/
    
    @JoinColumn(name = "Modali", referencedColumnName = "id",columnDefinition = "CHAR")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modali modalidad;
    
    
    
    
    /*(No Relevante,No Numerosa,Numerosa,Muy Numerosa)
    @Column(name = "idLuTrabNumerosidad",columnDefinition = "TINYINT")
    private Integer idLuTrabNumerosidad;
    @Size(max = 20)
    @Column(name = "NLNumerosidad")
    private String nLNumerosidad;*/
    /* ej: R -  54/63
    @Size(max = 20)
    @Column(name = "NLZona")
    private String nLZona;*/
    
    //No Relevante,Publico,Privado Subvencionado,Privado No Subvencionado
    /*@Column(name = "idLuTrabRegimen",columnDefinition = "TINYINT")
    private Integer idLuTrabRegimen;*/
    
    @JoinColumn(name = "idLuTrabRegimen", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private LuTrabRegimen regimen;
    
    @JsonIgnore
    @ApiModelProperty(notes = "Fecha de creación",dataType = "Date",required = true)
    //@JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    /* ej: RL-4874/34
    @Size(max = 20)
    @Column(name = "NLCreacion")
    private String nLCreacion;*/
    @JsonIgnore
    @ApiModelProperty(notes = "Fecha de clausura",dataType = "Date",required = false)
    @Column(name = "FechaClausura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaClausura;
    /*
    @Size(max = 20)
    @Column(name = "NLClausura")
    private String nLClausura;*/
    
    /* ver por nivelJur
    @Column(name = "idJurisdiccion",columnDefinition = "TINYINT")
    private Integer idJurisdiccion;*/
    /* Preguntar
    @Column(name = "idOrg")
    private Integer idOrg;*/
    @ApiModelProperty(notes = "Fecha del último movimiento",dataType = "Date",required = true)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "Desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date desde;
    
    @JsonIgnore
    @Column(name = "Hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hasta;
    /*descripción del último movimiento
    @Column(name = "idLuTrabMovimiento",columnDefinition = "TINYINT")
    private Integer idLuTrabMovimiento;*/
    
    /* ej -> RI-2112/95
    @Size(max = 20)
    @Column(name = "NormaLegal")
    private String normaLegal;*/
    /*@Column(name = "idLocalidad")
    private Integer idLocalidad;*/
    
    /*Min. de Educ. de la Prov. de Corrientes,Universidad Tecnologica Nacional,Universidad Nacional de Nordeste
    @Column(name = "idLuTrabGrupo")
    private Integer idLuTrabGrupo;*/
    
    /*@Column(name = "EmiteTituloRegistrable")
    private Boolean emiteTituloRegistrable;
    @Column(name = "Importado")
    private Boolean importado;
    @Size(max = 2147483647)
    @Column(name = "Obs")
    private String obs;*/
    
    /* AUDITORIA
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "idUsuario")
    private Integer idUsuario;*/
    
    /*@Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "timestamp",columnDefinition = "BINARY")
    private byte[] timestamp;*/
    
    /* qué tabla usar?
    @Column(name = "EstablecimientoDetalleId")
    private Integer establecimientoDetalleId;*/
    
    /* obtener desde Localidad
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento idDepartamento;
    */
    @JoinColumn(name = "idEntidadTipo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EntidadTipo entidadTipo;
    /*
    @JoinColumn(name = "idLuTrabZona", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LuTrabZona idLuTrabZona;
    */
    @JoinColumn(name = "idNivelJur", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private NivelJur nivelJurisdiccional;
    
    
    @JoinColumn(name = "idLocalidad", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Localidad localidad;
    
    @Transient //The transient keyword in Java is used to indicate that a field should not be serialized. (hibernate)
    @JsonSerialize//jackson
    @JsonDeserialize
    private Geoposicion geo = null;
    
    @Transient //The transient keyword in Java is used to indicate that a field should not be serialized. (hibernate)
    @JsonSerialize//jackson
    @JsonDeserialize
    private List<EstablecimientoEdificio> edificios = null;
    
    public LuTrab() {
    }

    public LuTrab(Integer id) {
        this.id = id;
    }

    public List<EstablecimientoEdificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(List<EstablecimientoEdificio> edificios) {
        this.edificios = edificios;
    }
    
    public Geoposicion getGeo(){
        return this.geo;
    }
    
    public void setGeo(Geoposicion geo){
        this.geo = geo;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLuTrab() {
        return luTrab;
    }

    public void setLuTrab(Integer luTrab) {
        this.luTrab = luTrab;
    }

    public int getAnexo() {
        return anexo;
    }

    public void setAnexo(int anexo) {
        this.anexo = anexo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
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
    }

    public Integer getCue() {
        return cue;
    }

    public void setCue(Integer cue) {
        this.cue = cue;
    }

    /*public Character getJa() {
        return ja;
    }

    public void setJa(Character ja) {
        this.ja = ja;
    }

    public Integer getIdLutrabCategoria() {
        return idLutrabCategoria;
    }

    public void setIdLutrabCategoria(Integer idLutrabCategoria) {
        this.idLutrabCategoria = idLutrabCategoria;
    }

    public String getNLCategEstab() {
        return nLCategEstab;
    }

    public void setNLCategEstab(String nLCategEstab) {
        this.nLCategEstab = nLCategEstab;
    }*/

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno idTurno) {
        this.turno = idTurno;
    }

   /* public Character getNivel() {
        return nivel;
    }

    public void setNivel(Character nivel) {
        this.nivel = nivel;
    }*/

    public Modali getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modali modali) {
        this.modalidad = modali;
    }

   /* public Integer getIdLuTrabNumerosidad() {
        return idLuTrabNumerosidad;
    }

    public void setIdLuTrabNumerosidad(Integer idLuTrabNumerosidad) {
        this.idLuTrabNumerosidad = idLuTrabNumerosidad;
    }

    public String getNLNumerosidad() {
        return nLNumerosidad;
    }

    public void setNLNumerosidad(String nLNumerosidad) {
        this.nLNumerosidad = nLNumerosidad;
    }

    public String getNLZona() {
        return nLZona;
    }

    public void setNLZona(String nLZona) {
        this.nLZona = nLZona;
    }*/

    public LuTrabRegimen getRegimen() {
        return regimen;
    }

    public void setRegimen(LuTrabRegimen idLuTrabRegimen) {
        this.regimen = idLuTrabRegimen;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /*public String getNLCreacion() {
        return nLCreacion;
    }

    public void setNLCreacion(String nLCreacion) {
        this.nLCreacion = nLCreacion;
    }*/

    public Date getFechaClausura() {
        return fechaClausura;
    }

    public void setFechaClausura(Date fechaClausura) {
        this.fechaClausura = fechaClausura;
    }

    /*public String getNLClausura() {
        return nLClausura;
    }

    public void setNLClausura(String nLClausura) {
        this.nLClausura = nLClausura;
    }

    public Integer getIdJurisdiccion() {
        return idJurisdiccion;
    }

    public void setIdJurisdiccion(Integer idJurisdiccion) {
        this.idJurisdiccion = idJurisdiccion;
    }

    public Integer getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(Integer idOrg) {
        this.idOrg = idOrg;
    }*/

    public Date getDesde() {
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

    /*public Integer getIdLuTrabMovimiento() {
        return idLuTrabMovimiento;
    }

    public void setIdLuTrabMovimiento(Integer idLuTrabMovimiento) {
        this.idLuTrabMovimiento = idLuTrabMovimiento;
    }

    public String getNormaLegal() {
        return normaLegal;
    }

    public void setNormaLegal(String normaLegal) {
        this.normaLegal = normaLegal;
    }*/

    /*public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Integer getIdLuTrabGrupo() {
        return idLuTrabGrupo;
    }

    public void setIdLuTrabGrupo(Integer idLuTrabGrupo) {
        this.idLuTrabGrupo = idLuTrabGrupo;
    }

    public Boolean getEmiteTituloRegistrable() {
        return emiteTituloRegistrable;
    }

    public void setEmiteTituloRegistrable(Boolean emiteTituloRegistrable) {
        this.emiteTituloRegistrable = emiteTituloRegistrable;
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }*/

    /*public byte[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getEstablecimientoDetalleId() {
        return establecimientoDetalleId;
    }

    public void setEstablecimientoDetalleId(Integer establecimientoDetalleId) {
        this.establecimientoDetalleId = establecimientoDetalleId;
    }*/

    /*public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }*/

    public EntidadTipo getEntidadTipo() {
        return entidadTipo;
    }

    public void setIdEntidadTipo(EntidadTipo idEntidadTipo) {
        this.entidadTipo = idEntidadTipo;
    }

   /* public LuTrabZona getIdLuTrabZona() {
        return idLuTrabZona;
    }

    public void setIdLuTrabZona(LuTrabZona idLuTrabZona) {
        this.idLuTrabZona = idLuTrabZona;
    }*/

    public NivelJur getNivelJurisdiccional() {
        return nivelJurisdiccional;
    }

    public void setNivelJurisdiccional(NivelJur idNivelJur) {
        this.nivelJurisdiccional = idNivelJur;
    }
    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad idLocalidad) {
        this.localidad = idLocalidad;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LuTrab)) {
            return false;
        }
        LuTrab other = (LuTrab) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.LuTrab[ id=" + id + " ]";
    }
    
}
