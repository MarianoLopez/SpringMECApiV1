/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.ConexionesEscuelas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mariano
 */
@Entity
@Table(name = "movimiento")
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movimientoID")
    private Integer movimientoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movimiento", fetch = FetchType.LAZY)
//    private List<Conexiones> conexionesList;

    public Movimiento() {
    }

    public Movimiento(Integer movimientoID) {
        this.movimientoID = movimientoID;
    }

    public Movimiento(Integer movimientoID, String descripcion) {
        this.movimientoID = movimientoID;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return movimientoID;
    }

    public void setId(Integer movimientoID) {
        this.movimientoID = movimientoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public List<Conexiones> getConexionesList() {
//        return conexionesList;
//    }
//
//    public void setConexionesList(List<Conexiones> conexionesList) {
//        this.conexionesList = conexionesList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movimientoID != null ? movimientoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.movimientoID == null && other.movimientoID != null) || (this.movimientoID != null && !this.movimientoID.equals(other.movimientoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.ConexionesEscuelas.Movimiento[ movimientoID=" + movimientoID + " ]";
    }
    
}
