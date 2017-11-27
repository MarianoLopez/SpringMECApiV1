/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Models.Padron;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "departamento_tipo")
@JsonPropertyOrder({"id","nombre"})
public class DepartamentoTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_departamento")
    private Integer cDepartamento;
    /*@Basic(optional = false)
    @Column(name = "cod_departamento")
    private String codDepartamento;*/
    @Column(name = "nombre")
    private String nombre;
    
    @JsonIgnore
    @Column(name = "c_provincia",columnDefinition = "int2")
    private Integer c_provincia;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "cDepartamento", fetch = FetchType.LAZY)
    private List<LocalidadTipo> localidadTipoList;*/
    /*@JoinColumn(name = "c_provincia", referencedColumnName = "c_provincia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProvinciaTipo cProvincia;
    @JoinColumn(name = "c_zona", referencedColumnName = "c_zona")
    @ManyToOne(fetch = FetchType.LAZY)
    private ZonaTipo cZona;*/

    public DepartamentoTipo() {
    }

    public DepartamentoTipo(Integer cDepartamento) {
        this.cDepartamento = cDepartamento;
    }

    /*public DepartamentoTipo(Integer cDepartamento, String codDepartamento) {
        this.cDepartamento = cDepartamento;
        this.codDepartamento = codDepartamento;
    }*/

    public Integer getId() {
        return cDepartamento;
    }

    public void setId(Integer cDepartamento) {
        this.cDepartamento = cDepartamento;
    }

    public Integer getC_provincia() {
        return c_provincia;
    }

    public void setC_provincia(Integer c_provincia) {
        this.c_provincia = c_provincia;
    }
    
    

    /*public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public List<LocalidadTipo> getLocalidadTipoList() {
        return localidadTipoList;
    }

    public void setLocalidadTipoList(List<LocalidadTipo> localidadTipoList) {
        this.localidadTipoList = localidadTipoList;
    }*/

    /*public ProvinciaTipo getCProvincia() {
        return cProvincia;
    }

    public void setCProvincia(ProvinciaTipo cProvincia) {
        this.cProvincia = cProvincia;
    }

    public ZonaTipo getCZona() {
        return cZona;
    }

    public void setCZona(ZonaTipo cZona) {
        this.cZona = cZona;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDepartamento != null ? cDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentoTipo)) {
            return false;
        }
        DepartamentoTipo other = (DepartamentoTipo) object;
        if ((this.cDepartamento == null && other.cDepartamento != null) || (this.cDepartamento != null && !this.cDepartamento.equals(other.cDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.z.mavenproject1.DepartamentoTipo[ cDepartamento=" + cDepartamento + " ]";
    }
    
}
