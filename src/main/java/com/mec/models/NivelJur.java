/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MarianoLopez
 */
@Entity
@Table(name = "NivelJur")
@NamedQueries({
    @NamedQuery(name = "NivelJur.findAll", query = "SELECT n FROM NivelJur n")})
public class NivelJur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id",columnDefinition = "TINYINT")
    private Integer id;
    @Size(max = 50)
    @Column(name = "Descr")
    private String descr;
    @Size(max = 50)
    @Column(name = "Mnemo")
    private String mnemo;
    @Column(name = "idJurisdiccion",columnDefinition = "TINYINT")
    private Integer idJurisdiccion;
    @Size(max = 5)
    @Column(name = "DepJur")
    private String depJur;
    @Column(name = "NivelJurisdiccionalId",columnDefinition = "TINYINT")
    private Integer nivelJurisdiccionalId;
    /*
    @JsonIgnore
    @OneToMany(mappedBy = "nivelJurisdiccional", fetch = FetchType.LAZY)
    private List<LuTrab> luTrabList;
    */
    public NivelJur() {
    }

    public NivelJur(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getMnemo() {
        return mnemo;
    }

    public void setMnemo(String mnemo) {
        this.mnemo = mnemo;
    }

    public Integer getIdJurisdiccion() {
        return idJurisdiccion;
    }

    public void setIdJurisdiccion(Integer idJurisdiccion) {
        this.idJurisdiccion = idJurisdiccion;
    }

    public String getDepJur() {
        return depJur;
    }

    public void setDepJur(String depJur) {
        this.depJur = depJur;
    }

    public Integer getNivelJurisdiccionalId() {
        return nivelJurisdiccionalId;
    }

    public void setNivelJurisdiccionalId(Integer nivelJurisdiccionalId) {
        this.nivelJurisdiccionalId = nivelJurisdiccionalId;
    }

   /* public List<LuTrab> getLuTrabList() {
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
        if (!(object instanceof NivelJur)) {
            return false;
        }
        NivelJur other = (NivelJur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.NivelJur[ id=" + id + " ]";
    }
    
}
