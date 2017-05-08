/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author MarianoLopez
 */
@Entity
@Table(name = "Modali")
public class Modali implements Serializable {
    private static final long serialVersionUID = 1L;
    //@JsonIgnore
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id",columnDefinition = "TINYINT")
    private Integer id;
    @Size(max = 20)
    @Column(name = "Descr",columnDefinition = "CHAR")
    private String descripcion;
    
    /*@Column(name = "NivelEns")
    private Character nivelEns;
    @Column(name = "Orden",columnDefinition = "TINYINT")
    private Integer orden;*/

    public Modali() {
    }

    public Modali(Integer id) {
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

    /*public Character getNivelEns() {
        return nivelEns;
    }

    public void setNivelEns(Character nivelEns) {
        this.nivelEns = nivelEns;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
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
        if (!(object instanceof Modali)) {
            return false;
        }
        Modali other = (Modali) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Modali[ id=" + id + " ]";
    }
    
}
