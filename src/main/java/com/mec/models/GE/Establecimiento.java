/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.GE;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "Establecimiento",schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Establecimiento.findAll", query = "SELECT e FROM Establecimiento e")})
public class Establecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EstablecimientoId")
    private Integer establecimientoId;
    @Column(name = "EdificioId")
    private Integer edificioId;
    @Size(max = 15)
    @Column(name = "CUE")
    private String cue;
    @Column(name = "Anexo")
    private Short anexo;
    @Column(name = "LuTrab")
    private Integer luTrab;
    /*@OneToMany(mappedBy = "establecimientoPadreId", fetch = FetchType.LAZY)
    private List<Establecimiento> establecimientoList;
    @JoinColumn(name = "EstablecimientoPadreId", referencedColumnName = "EstablecimientoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Establecimiento establecimientoPadreId;
    @JoinColumn(name = "EstablecimientoDetalleId", referencedColumnName = "EstablecimientoDetalleId")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstablecimientoDetalle establecimientoDetalleId;*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "establecimientoId", fetch = FetchType.LAZY)
    private List<EstablecimientoDetalle> establecimientoDetalleList;

    public Establecimiento() {
    }

    public Establecimiento(Integer establecimientoId) {
        this.establecimientoId = establecimientoId;
    }

    public Integer getEstablecimientoId() {
        return establecimientoId;
    }

    public void setEstablecimientoId(Integer establecimientoId) {
        this.establecimientoId = establecimientoId;
    }

    public Integer getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(Integer edificioId) {
        this.edificioId = edificioId;
    }

    public String getCue() {
        return cue;
    }

    public void setCue(String cue) {
        this.cue = cue;
    }

    public Short getAnexo() {
        return anexo;
    }

    public void setAnexo(Short anexo) {
        this.anexo = anexo;
    }

    public Integer getLuTrab() {
        return luTrab;
    }

    public void setLuTrab(Integer luTrab) {
        this.luTrab = luTrab;
    }

    /*public List<Establecimiento> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<Establecimiento> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }

    public Establecimiento getEstablecimientoPadreId() {
        return establecimientoPadreId;
    }

    public void setEstablecimientoPadreId(Establecimiento establecimientoPadreId) {
        this.establecimientoPadreId = establecimientoPadreId;
    }

    public EstablecimientoDetalle getEstablecimientoDetalleId() {
        return establecimientoDetalleId;
    }

    public void setEstablecimientoDetalleId(EstablecimientoDetalle establecimientoDetalleId) {
        this.establecimientoDetalleId = establecimientoDetalleId;
    }*/

    public List<EstablecimientoDetalle> getEstablecimientoDetalleList() {
        return establecimientoDetalleList;
    }

    public void setEstablecimientoDetalleList(List<EstablecimientoDetalle> establecimientoDetalleList) {
        this.establecimientoDetalleList = establecimientoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (establecimientoId != null ? establecimientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Establecimiento)) {
            return false;
        }
        Establecimiento other = (Establecimiento) object;
        if ((this.establecimientoId == null && other.establecimientoId != null) || (this.establecimientoId != null && !this.establecimientoId.equals(other.establecimientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.GE.Establecimiento[ establecimientoId=" + establecimientoId + " ]";
    }
    
}
