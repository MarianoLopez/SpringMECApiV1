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
@Table(name = "Turno")
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")})
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(notes = "Identificador Unico DB",dataType = "Integer",required = true)
    @JsonIgnore
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id",columnDefinition = "TINYINT")
    private Integer id;
    /*@Column(name = "TurnoCge")
    private Character turnoCge;*/
    
    @ApiModelProperty(notes = "Turno nombre reducido",dataType = "String(50)",required = true)
    @Size(max = 50)
    @Column(name = "Mnemo")
    private String mnemo;
    
    @ApiModelProperty(notes = "Turno nombre",dataType = "String(30)",required = true)
    @Size(max = 30)
    @Column(name = "Descr")
    private String descripcion;
    
    @ApiModelProperty(notes = "Turno simple",dataType = "Boolean",required = true)
    @Column(name = "EsSimple")
    private Boolean esSimple;
    
    /*@Column(name = "Plaza")
    private Boolean plaza;
    @Column(name = "TurnoSage",columnDefinition = "TINYINT")
    private Integer turnoSage;
   
    @Column(name = "TurnoId",columnDefinition = "TINYINT")
    private Integer turnoId;*/

    public Turno() {
    }

    public Turno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public Character getTurnoCge() {
        return turnoCge;
    }

    public void setTurnoCge(Character turnoCge) {
        this.turnoCge = turnoCge;
    }*/

    public String getMnemo() {
        return mnemo;
    }

    public void setMnemo(String mnemo) {
        this.mnemo = mnemo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descr) {
        this.descripcion = descr;
    }

    /*public Boolean getPlaza() {
        return plaza;
    }

    public void setPlaza(Boolean plaza) {
        this.plaza = plaza;
    }

    public Integer getTurnoSage() {
        return turnoSage;
    }

    public void setTurnoSage(Integer turnoSage) {
        this.turnoSage = turnoSage;
    }*/

    public Boolean getEsSimple() {
        return esSimple;
    }

    public void setEsSimple(Boolean esSimple) {
        this.esSimple = esSimple;
    }

   /* public Integer getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Integer turnoId) {
        this.turnoId = turnoId;
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
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Turno[ id=" + id + " ]";
    }
    
}
