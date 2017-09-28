/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Services;

import com.mec.DAO.GeoDAO;
import com.mec.DAO.Postgre.EstablecimientoPostgreDAO;
import com.mec.Util.GeoDistance;
import com.mec.models.Padron.EstablecimientoPost;
import com.mec.models.votero.Establecimiento;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mariano
 */
@Service
public class VoteroService {
    @Autowired
    private EstablecimientoPostgreDAO establecimientosDAO;
    @Autowired
    private GeoDAO geoDAO;
    
    private Map<String,List<Establecimiento>> TODO;
    
    public Map<String,List<Establecimiento>> withFilter(float my_lat, float my_lon,double distanceKM) throws IOException{
        Map<String,List<Establecimiento>> todo = getAll();
        //Map<String,List<Establecimiento>> filter = new HashMap<>();
        GeoDistance gd = new GeoDistance(my_lat,my_lon);
        todo.forEach((k, v) -> {
            v.stream().forEach(est->{
                //List<Establecimiento> est_filter = new ArrayList();
                est.getEstablecimiento().getLocalizacion().forEach(l->{
                    l.getDomicilios().forEach(d->{
                        if(d.getGeo()!=null){
                            double distancia = gd.getDistanceTo(((BigDecimal)d.getGeo().getLatitud()).floatValue(), ((BigDecimal)d.getGeo().getLongitud()).floatValue());
                            est.setDistancia(distancia);
                            //est_filter.add(est);
                        }else{
                            System.out.println("geo null: "+est.getEstablecimiento().getCue());
                        }
                    });
                });
                //if(est_filter.size()>0){filter.put(k, est_filter);}
            });//establecimientos
        });
        return todo;
    }
    public Map<String,List<Establecimiento>> getAll() throws IOException{
        if(TODO==null){
            TODO = getFromExcel();
        }
        return TODO;
    }

    private Map<String,List<Establecimiento>> getFromExcel() throws IOException{
        Map<String,List<Establecimiento>> s = new HashMap<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("votero.xlsx");
        Workbook workbook = new XSSFWorkbook(is);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        for (Row row : datatypeSheet) {
            Cell cue = row.getCell(0);
            Cell anexo = row.getCell(1);
            Cell circuito = row.getCell(3);
            Cell desde = row.getCell(4);
            Cell hasta = row.getCell(5);
            Cell total = row.getCell(6);
            if(cue!=null && anexo !=null&&!cue.toString().isEmpty()){
                cue.setCellType(Cell.CELL_TYPE_STRING);
                anexo.setCellType(Cell.CELL_TYPE_STRING);
                circuito.setCellType(Cell.CELL_TYPE_STRING);
                desde.setCellType(Cell.CELL_TYPE_STRING);
                hasta.setCellType(Cell.CELL_TYPE_STRING);
                total.setCellType(Cell.CELL_TYPE_STRING);
                
                if(s.containsKey(circuito.toString())){
                    EstablecimientoPost est = establecimientosDAO.getByCueAnexo(Integer.parseInt(cue.toString()), Integer.parseInt(anexo.toString()));
                    setGeo(est);
                    s.get(circuito.toString()).add(new Establecimiento(est, Integer.parseInt(desde.toString()), Integer.parseInt(hasta.toString()), Integer.parseInt(total.toString())));
                }else{
                    List<Establecimiento> aux = new ArrayList<>();
                    EstablecimientoPost est = establecimientosDAO.getByCueAnexo(Integer.parseInt(cue.toString()), Integer.parseInt(anexo.toString()));
                    setGeo(est);
                    aux.add(new Establecimiento(
                            est,Integer.parseInt(desde.toString()), Integer.parseInt(hasta.toString()), Integer.parseInt(total.toString())));
                    s.put(circuito.toString(),aux);
                }
            }
        }
        return s;
    }
     
    private void setGeo(EstablecimientoPost establecimiento){
        establecimiento.getLocalizacion().forEach((loc) -> {
                loc.getDomicilios().forEach((dom) -> {
                   try{
                        dom.setGeo(geoDAO.getByCueAnexo(Integer.parseInt(establecimiento.getCue()), Integer.parseInt(loc.getAnexo())));
                    }catch(NumberFormatException e){
                        System.out.println("NumberFormatException: "+e.toString());
                    } 
                });
            });   
    }
}
