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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "localidad_tipo")
@JsonPropertyOrder({"id","nombre"})
public class LocalidadTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_localidad")
    private Integer cLocalidad;
    @Basic(optional = false)
    /*@Column(name = "cod_localidad")
    private String codLocalidad;*/
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cod_loc_indec",columnDefinition = "bpchar(8)")
    private String codLocIndec;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "c_departamento", referencedColumnName = "c_departamento",columnDefinition = "int2")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Where(clause = "c_provincia = 18")
    private DepartamentoTipo cDepartamento;

    public LocalidadTipo() {
    }

    public LocalidadTipo(Integer cLocalidad) {
        this.cLocalidad = cLocalidad;
    }

    /*public LocalidadTipo(Integer cLocalidad, String codLocalidad) {
        this.cLocalidad = cLocalidad;
        this.codLocalidad = codLocalidad;
    }*/

    public Integer getId() {
        return cLocalidad;
    }

    public void setId(Integer cLocalidad) {
        this.cLocalidad = cLocalidad;
    }

    /*public String getCodLocalidad() {
        return codLocalidad;
    }

    public void setCodLocalidad(String codLocalidad) {
        this.codLocalidad = codLocalidad;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodLocIndec() {
        return codLocIndec;
    }

    public void setCodLocIndec(String codLocIndec) {
        this.codLocIndec = codLocIndec;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DepartamentoTipo getDepartamento() {
        return cDepartamento;
    }

    public void setDepartamento(DepartamentoTipo cDepartamento) {
        this.cDepartamento = cDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cLocalidad != null ? cLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalidadTipo)) {
            return false;
        }
        LocalidadTipo other = (LocalidadTipo) object;
        if ((this.cLocalidad == null && other.cLocalidad != null) || (this.cLocalidad != null && !this.cLocalidad.equals(other.cLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.z.mavenproject1.LocalidadTipo[ cLocalidad=" + cLocalidad + " ]";
    }
    
}
