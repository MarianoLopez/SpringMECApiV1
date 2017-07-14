/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.Padron;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 36194445
 */
@Entity
@Table(name = "oferta_tipo")
@JsonPropertyOrder({"id","descripcion"})
public class OfertaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_oferta",columnDefinition = "int2")
    private Integer cOferta;
       
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    /*@Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private short orden;*/
    @Size(max = 2147483647)
    @Column(name = "corto")
    private String corto;

    public OfertaTipo() {
    }

    public OfertaTipo(Integer cOferta) {
        this.cOferta = cOferta;
    }



    public Integer getId() {
        return cOferta;
    }

    public void setId(Integer cOferta) {
        this.cOferta = cOferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getCorto() {
        return corto;
    }

    public void setCorto(String corto) {
        this.corto = corto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cOferta != null ? cOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaTipo)) {
            return false;
        }
        OfertaTipo other = (OfertaTipo) object;
        if ((this.cOferta == null && other.cOferta != null) || (this.cOferta != null && !this.cOferta.equals(other.cOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mec.models.Padron.OfertaTipo[ cOferta=" + cOferta + " ]";
    }
    
}
