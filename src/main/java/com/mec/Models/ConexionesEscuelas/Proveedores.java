/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Models.ConexionesEscuelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mariano
 */
@Entity
@Table(name = "proveedores")
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProveedorId")
    private Integer proveedorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
//    @OneToMany(mappedBy = "proveedorId", fetch = FetchType.LAZY)
//    private List<Conexiones> conexionesList;

    public Proveedores() {
    }

    public Proveedores(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Proveedores(Integer proveedorId, String descripcion) {
        this.proveedorId = proveedorId;
        this.descripcion = descripcion;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
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
        hash += (proveedorId != null ? proveedorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.proveedorId == null && other.proveedorId != null) || (this.proveedorId != null && !this.proveedorId.equals(other.proveedorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.Models.ConexionesEscuelas.Proveedores[ proveedorId=" + proveedorId + " ]";
    }
    
}
