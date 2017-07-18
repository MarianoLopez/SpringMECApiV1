/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "titulo_tipo")
@JsonPropertyOrder({"id","descripcion"})
public class TituloTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_titulo")
    private Integer cTitulo;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    /*@Column(name = "cod_rama")
    private Short codRama;
    @Column(name = "cod_disciplina")
    private Short codDisciplina;
    @Column(name = "cod_carrera")
    private Short codCarrera;
    @Column(name = "cod_titulo")
    private Short codTitulo;
    @Size(max = 2147483647)
    @Column(name = "descripcion_ampliada")
    private String descripcionAmpliada;
    @Column(name = "c_denominacion")
    private Short cDenominacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_carrera")
    private short cCarrera;
    @Column(name = "c_nivel_titulo")
    private Short cNivelTitulo;*/
    

    public TituloTipo() {
    }

    public TituloTipo(Integer cTitulo) {
        this.cTitulo = cTitulo;
    }

    /*public TituloTipo(Integer cTitulo, short cCarrera) {
        this.cTitulo = cTitulo;
        this.cCarrera = cCarrera;
    }*/

    public Integer getId() {
        return cTitulo;
    }

    public void setId(Integer cTitulo) {
        this.cTitulo = cTitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*public Short getCodRama() {
        return codRama;
    }

    public void setCodRama(Short codRama) {
        this.codRama = codRama;
    }

    public Short getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Short codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public Short getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Short codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Short getCodTitulo() {
        return codTitulo;
    }

    public void setCodTitulo(Short codTitulo) {
        this.codTitulo = codTitulo;
    }

    public String getDescripcionAmpliada() {
        return descripcionAmpliada;
    }

    public void setDescripcionAmpliada(String descripcionAmpliada) {
        this.descripcionAmpliada = descripcionAmpliada;
    }

    public Short getCDenominacion() {
        return cDenominacion;
    }

    public void setCDenominacion(Short cDenominacion) {
        this.cDenominacion = cDenominacion;
    }

    public short getCCarrera() {
        return cCarrera;
    }

    public void setCCarrera(short cCarrera) {
        this.cCarrera = cCarrera;
    }

    public Short getCNivelTitulo() {
        return cNivelTitulo;
    }

    public void setCNivelTitulo(Short cNivelTitulo) {
        this.cNivelTitulo = cNivelTitulo;
    }*/



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTitulo != null ? cTitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TituloTipo)) {
            return false;
        }
        TituloTipo other = (TituloTipo) object;
        if ((this.cTitulo == null && other.cTitulo != null) || (this.cTitulo != null && !this.cTitulo.equals(other.cTitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.TituloTipo[ cTitulo=" + cTitulo + " ]";
    }
    
}
