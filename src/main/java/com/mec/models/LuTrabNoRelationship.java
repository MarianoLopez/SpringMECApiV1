/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MarianoLopez
 */
@Entity
@Table(name = "LuTrab")
public class LuTrabNoRelationship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "LuTrab")
    private Integer luTrab;
    @Column(name = "Anexo",columnDefinition = "TINYINT")
    private Integer anexo;
    @Column(name = "Numero",columnDefinition = "SMALLINT")
    private Integer numero;
    @Size(max = 250)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "NombreEspecial")
    private String nombreEspecial;
    @Column(name = "CUE")
    private Integer cue;
    @Column(name = "JA")
    private Character ja;
    @Column(name = "idLutrabCategoria",columnDefinition = "TINYINT")
    private Integer idLutrabCategoria;
    @Size(max = 20)
    @Column(name = "NLCategEstab")
    private String nLCategEstab;
    @Column(name = "idTurno",columnDefinition = "TINYINT")
    private Integer idTurno;
    @Column(name = "Nivel")
    private Character nivel;
    @Size(max = 2)
    @Column(name = "Modali",columnDefinition = "CHAR")
    private String modali;
    @Column(name = "idLuTrabNumerosidad",columnDefinition = "TINYINT")
    private Integer idLuTrabNumerosidad;
    @Size(max = 20)
    @Column(name = "NLNumerosidad")
    private String nLNumerosidad;
    @Size(max = 20)
    @Column(name = "NLZona")
    private String nLZona;
    @Column(name = "idLuTrabRegimen",columnDefinition = "TINYINT")
    private Integer idLuTrabRegimen;
    /*@Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;*/
    /*@Size(max = 20)
    @Column(name = "NLCreacion")
    private String nLCreacion;*/
    @Column(name = "FechaClausura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaClausura;
    /*@Size(max = 20)
    @Column(name = "NLClausura")
    private String nLClausura;*/
    @Column(name = "idJurisdiccion",columnDefinition = "TINYINT")
    private Integer idJurisdiccion;
    @Column(name = "idOrg")
    private Integer idOrg;
    /*@Column(name = "Desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date desde;
    @Column(name = "Hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hasta;*/
    /*@Column(name = "idLuTrabMovimiento",columnDefinition = "TINYINT")
    private Integer idLuTrabMovimiento;*/
    /*@Size(max = 20)
    @Column(name = "NormaLegal")
    private String normaLegal;*/
    @Column(name = "idLocalidad")
    private Integer idLocalidad;
    @Column(name = "idLuTrabGrupo")
    private Integer idLuTrabGrupo;
   /* @Column(name = "EmiteTituloRegistrable")
    private Boolean emiteTituloRegistrable;
    @Column(name = "Importado")
    private Boolean importado;
    @Size(max = 2147483647)
    @Column(name = "Obs")
    private String obs;
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
    private byte[] timestamp;
    @Column(name = "EstablecimientoDetalleId")
    private Integer establecimientoDetalleId;
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento idDepartamento;
    @JoinColumn(name = "idEntidadTipo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EntidadTipo idEntidadTipo;
    @JoinColumn(name = "idLuTrabZona", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LuTrabZona idLuTrabZona;
    @JoinColumn(name = "idNivelJur", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private NivelJur idNivelJur;*/

    public LuTrabNoRelationship() {
    }

    public LuTrabNoRelationship(Integer id) {
        this.id = id;
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

    public Character getJa() {
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
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Character getNivel() {
        return nivel;
    }

    public void setNivel(Character nivel) {
        this.nivel = nivel;
    }

    public String getModali() {
        return modali;
    }

    public void setModali(String modali) {
        this.modali = modali;
    }

    public Integer getIdLuTrabNumerosidad() {
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
    }

    public Integer getIdLuTrabRegimen() {
        return idLuTrabRegimen;
    }

    public void setIdLuTrabRegimen(Integer idLuTrabRegimen) {
        this.idLuTrabRegimen = idLuTrabRegimen;
    }

   /* public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNLCreacion() {
        return nLCreacion;
    }

    public void setNLCreacion(String nLCreacion) {
        this.nLCreacion = nLCreacion;
    }
    */
    public Date getFechaClausura() {
        return fechaClausura;
    }

    public void setFechaClausura(Date fechaClausura) {
        this.fechaClausura = fechaClausura;
    }
    /*
    public String getNLClausura() {
        return nLClausura;
    }

    public void setNLClausura(String nLClausura) {
        this.nLClausura = nLClausura;
    }*/

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

    public Integer getIdLuTrabMovimiento() {
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

    public Integer getIdLocalidad() {
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

    /*public Boolean getEmiteTituloRegistrable() {
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
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public EntidadTipo getIdEntidadTipo() {
        return idEntidadTipo;
    }

    public void setIdEntidadTipo(EntidadTipo idEntidadTipo) {
        this.idEntidadTipo = idEntidadTipo;
    }

    public LuTrabZona getIdLuTrabZona() {
        return idLuTrabZona;
    }

    public void setIdLuTrabZona(LuTrabZona idLuTrabZona) {
        this.idLuTrabZona = idLuTrabZona;
    }

    public NivelJur getIdNivelJur() {
        return idNivelJur;
    }

    public void setIdNivelJur(NivelJur idNivelJur) {
        this.idNivelJur = idNivelJur;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LuTrabNoRelationship)) {
            return false;
        }
        LuTrabNoRelationship other = (LuTrabNoRelationship) object;
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
