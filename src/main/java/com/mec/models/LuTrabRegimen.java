/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
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

/**
 *
 * @author MarianoLopez
 */
@Entity
@Table(name = "LuTrabRegimen")
@NamedQueries({
    @NamedQuery(name = "LuTrabRegimen.findAll", query = "SELECT l FROM LuTrabRegimen l")})
public class LuTrabRegimen implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(notes = "Identificador Unico DB",dataType = "Integer",required = true)
    //@JsonIgnore
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id",columnDefinition = "TINYINT")
    private Integer id;
    
    @ApiModelProperty(notes = "Regimen nombre",dataType = "String(25)",required = true)
    @Size(max = 25)
    @Column(name = "Descr")
    private String descripcion;
    
    @ApiModelProperty(notes = "Regimen nombre reducido",dataType = "String(3)",required = true)
    @Size(max = 3)
    @Column(name = "Mnemo")
    private String mnemo;

    public LuTrabRegimen() {
    }

    public LuTrabRegimen(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descr) {
        this.descripcion = descr;
    }

    public String getMnemo() {
        return mnemo;
    }

    public void setMnemo(String mnemo) {
        this.mnemo = mnemo;
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
        if (!(object instanceof LuTrabRegimen)) {
            return false;
        }
        LuTrabRegimen other = (LuTrabRegimen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.LuTrabRegimen[ id=" + id + " ]";
    }
    
}
