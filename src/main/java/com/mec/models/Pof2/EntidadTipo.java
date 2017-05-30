/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Pof2;

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
@Table(name = "EntidadTipo")
@NamedQueries({
    @NamedQuery(name = "EntidadTipo.findAll", query = "SELECT e FROM EntidadTipo e")})
public class EntidadTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(notes = "Identificador Unico DB",dataType = "Integer",required = true)
    @JsonIgnore
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id",columnDefinition = "TINYINT")
    private Integer id;
    @ApiModelProperty(notes = "Nombre del tipo de Entidad",dataType = "String(40)",required = true)
    @Size(max = 40)
    @Column(name = "Descr")
    private String descripcion;
    
    /*@Column(name = "TipoEntidadId",columnDefinition = "TINYINT")
    private Integer tipoEntidadId;*/
    /*
    @JsonIgnore
    @OneToMany(mappedBy = "entidadTipo", fetch = FetchType.LAZY)
    private List<LuTrab> luTrabList;
    */
    public EntidadTipo() {
    }

    public EntidadTipo(Integer id) {
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

    /*public Integer getTipoEntidadId() {
        return tipoEntidadId;
    }

    public void setTipoEntidadId(Integer tipoEntidadId) {
        this.tipoEntidadId = tipoEntidadId;
    }*/

    /*public List<LuTrab> getLuTrabList() {
        return luTrabList;
    }

    public void setLuTrabList(List<LuTrab> luTrabList) {
        this.luTrabList = luTrabList;
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
        if (!(object instanceof EntidadTipo)) {
            return false;
        }
        EntidadTipo other = (EntidadTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.EntidadTipo[ id=" + id + " ]";
    }
    
}
