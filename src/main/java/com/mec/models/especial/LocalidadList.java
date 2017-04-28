/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.especial;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author MarianoLopez
 */

@Entity
@Table(name = "Localidad")
public class LocalidadList implements Serializable {
    private static final long serialVersionUID = 1L;
    //@JsonIgnore
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 50)
    @Column(name = "Descr")
    private String descripcion;
    /*
    @Size(max = 20)
    @Column(name = "CodPostal")
    private String codPostal;*/
    
    /*AUDITORIA
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "idUsuario")
    private Integer idUsuario;
   */
    
    /*@Column(name = "LocalidadId")
    private Integer localidadId;*/
    
    
    @JsonIgnore
    @JoinColumn(name = "idDepartamento", referencedColumnName = "DepartamentoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dep departamento;
   

    public LocalidadList() {
    }

    public LocalidadList(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return StringUtils.stripEnd(descripcion, " ");
    }

    public void setDescripcion(String descr) {
        this.descripcion = descr;
    }

    /*public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
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

   /* public byte[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }*/

   /* public Integer getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(Integer localidadId) {
        this.localidadId = localidadId;
    }*/

    /*public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento idDepartamento) {
        this.departamento = idDepartamento;
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
        if (!(object instanceof LocalidadList)) {
            return false;
        }
        LocalidadList other = (LocalidadList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Localidad[ id=" + id + " ]";
    }
    
}
