/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.ConexionesEscuelas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "conexiontipo")
@NamedQueries({
    @NamedQuery(name = "Conexiontipo.findAll", query = "SELECT c FROM Conexiontipo c")})
public class Conexiontipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ConexionTipoId")
    private Integer conexionTipoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Descripcion")
    private String descripcion;
//    @OneToMany(mappedBy = "conexionTipoId", fetch = FetchType.LAZY)
//    private List<Conexiones> conexionesList;

    public Conexiontipo() {
    }

    public Conexiontipo(Integer conexionTipoId) {
        this.conexionTipoId = conexionTipoId;
    }

    public Conexiontipo(Integer conexionTipoId, String descripcion) {
        this.conexionTipoId = conexionTipoId;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return conexionTipoId;
    }

    public void setId(Integer conexionTipoId) {
        this.conexionTipoId = conexionTipoId;
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
        hash += (conexionTipoId != null ? conexionTipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conexiontipo)) {
            return false;
        }
        Conexiontipo other = (Conexiontipo) object;
        if ((this.conexionTipoId == null && other.conexionTipoId != null) || (this.conexionTipoId != null && !this.conexionTipoId.equals(other.conexionTipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.ConexionesEscuelas.Conexiontipo[ conexionTipoId=" + conexionTipoId + " ]";
    }
    
}
