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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author MarianoLopez
 */
@Entity
@Table(name = "Departamento")
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @JsonIgnore
    @Column(name = "DepartamentoId",columnDefinition = "TINYINT")
    private Integer departamentoId;
    
    /*@OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<Localidad> localidadList;*/
    //@JsonIgnore
    @ApiModelProperty(notes = "Identificador Unico DB",dataType = "Integer",required = true)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id",columnDefinition = "TINYINT")
    private Integer id;
    
    @ApiModelProperty(notes = "Nombre del Departamento",dataType = "String(20)",required = true)
    @Size(max = 20)
    @Column(name = "Descr")
    private String descripcion;
    @ApiModelProperty(notes = "Nombre reducido del Departamento",dataType = "String(5)",required = true)
    @Size(max = 5)
    @Column(name = "Mnemo")
    private String mnemo;
    @JsonIgnore
    @Size(max = 6)
    @Column(name = "CodDepto",columnDefinition="NCHAR")
    private String codDepto;
    
    /*@Column(name = "NextLutrab")
    private Integer nextLutrab;*/
    /*@JsonIgnore
    @OneToMany(mappedBy = "idDepartamento", fetch = FetchType.LAZY)
    private List<LuTrab> luTrabList;*/

    public Departamento() {
    }

    public Departamento(Integer id) {
        this.id = id;
    }

    public int getId() {
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

    public String getMnemo() {
        return mnemo;
    }

    public void setMnemo(String mnemo) {
        this.mnemo = mnemo;
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    /*public Integer getNextLutrab() {
        return nextLutrab;
    }

    public void setNextLutrab(Integer nextLutrab) {
        this.nextLutrab = nextLutrab;
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
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Departamento[ id=" + id + " ]";
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

   /*public List<Localidad> getLocalidadList() {
        return localidadList;
    }

    public void setLocalidadList(List<Localidad> localidadList) {
        this.localidadList = localidadList;
    }*/
    
   
    
}
