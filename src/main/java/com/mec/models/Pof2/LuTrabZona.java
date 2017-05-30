/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Pof2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "LuTrabZona")
@NamedQueries({
    @NamedQuery(name = "LuTrabZona.findAll", query = "SELECT l FROM LuTrabZona l")})
public class LuTrabZona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id",columnDefinition = "TINYINT")
    private Integer id;
    @Size(max = 25)
    @Column(name = "Descr")
    private String descr;
    @Size(max = 2)
    @Column(name = "Mnemo")
    private String mnemo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Porcentaje")
    private BigDecimal porcentaje;
    /*
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLuTrabZona", fetch = FetchType.LAZY)
    private List<LuTrab> luTrabList;
    */
    public LuTrabZona() {
    }

    public LuTrabZona(Integer id) {
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

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

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
        if (!(object instanceof LuTrabZona)) {
            return false;
        }
        LuTrabZona other = (LuTrabZona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.LuTrabZona[ id=" + id + " ]";
    }
    
}
