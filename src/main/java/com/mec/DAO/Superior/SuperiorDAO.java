/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO.Superior;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mariano
 */
@Repository
public class SuperiorDAO {
    public Map<String,List<String>> getAll() throws IOException{
        Map<String,List<String>> s = new HashMap<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("superior.xlsx");
        Workbook workbook = new XSSFWorkbook(is);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        for (Row row : datatypeSheet) {
            Cell cue = row.getCell(0);
            Cell carrera = row.getCell(1);
            if(cue!=null && carrera !=null&&!cue.toString().isEmpty()){
                cue.setCellType(Cell.CELL_TYPE_STRING);
                if(s.containsKey(carrera.toString())){
                    s.get(carrera.toString()).add(cue.toString());
                }else{
                    List<String> aux = new ArrayList<>();
                    aux.add(cue.toString());
                    s.put(carrera.toString(),aux);
                }
                //list.add(new Superior(cue.toString(), carrera.toString()));
            }
        }
        return s;
    }
}
