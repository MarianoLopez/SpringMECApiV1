/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.models.votero;

import com.mec.models.Padron.EstablecimientoPost;

/**
 *
 * @author Mariano
 */
public class Establecimiento {
    private EstablecimientoPost establecimiento;
    private int desde, hasta, total;

    public Establecimiento(EstablecimientoPost establecimiento, int desde, int hasta, int total) {
        this.establecimiento = establecimiento;
        this.desde = desde;
        this.hasta = hasta;
        this.total = total;
    }

    public EstablecimientoPost getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(EstablecimientoPost establecimiento) {
        this.establecimiento = establecimiento;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
