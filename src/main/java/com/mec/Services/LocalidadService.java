/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.LocalidadDAO;
import com.mec.models.Localidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarianoLopez
 */
@Service
public class LocalidadService {
    private LocalidadDAO localidadDAO;
    private List<Localidad> localidades;
    
    @Autowired
    public LocalidadService(LocalidadDAO localidadDAO){
        this.setLocalidadDAO(localidadDAO);
        this.initLocalidades();
    }

    private void initLocalidades(){
        new Thread(() -> {
            this.setLocalidades(this.getLocalidadDAO().getAll());
            System.out.println("initLocalidades() listo");
        }).start();
    }
    
    private LocalidadDAO getLocalidadDAO() {
        return localidadDAO;
    }
    
    private void setLocalidadDAO(LocalidadDAO localidadDAO) {
        this.localidadDAO = localidadDAO;
    }
    
    
    public List<Localidad> getLocalidades() {return localidades;}

    private void setLocalidades(List<Localidad> localidades) {this.localidades = localidades;}
    
    public Localidad getById(int id){return localidadDAO.getById(id);}
    
}
