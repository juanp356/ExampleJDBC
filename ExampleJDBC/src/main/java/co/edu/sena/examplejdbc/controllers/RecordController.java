/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.bd.model.Record;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class RecordController implements IRecordController {

    private DBRecord dbr = new DBRecord();
    
    @Override
    public void insert(Record record) throws Exception {
       if(record == null){
           throw new Exception("El registro es obligatorio");
       }
       if(record.getId() == 0){
           throw new Exception("El ID es obligatorio");
       }
       if("".equals(record.getDate_record())){
           throw new Exception("la fecha de registro es obligatoria");
       }
       if("".equals(record.getStart_time())){
           throw new Exception("la hora de inicio del registro es obligatoria");
       }
       //FK
        if(record.getEmployee() == null){
           throw new Exception("el registro del empleado es obigatorio");
       }
       if(record.getKey() == null){
           throw new Exception("el registro de la llave es obigatorio");
       }
       dbr.insert(record);
    }

    @Override
    public void update(Record record) throws Exception {
         if(record == null){
           throw new Exception("El registro es obligatorio");
       }
       if(record.getId() == 0){
           throw new Exception("El ID es obligatorio");
       }
       if("".equals(record.getDate_record())){
           throw new Exception("la fecha de registro es obligatoria");
       }
       if("".equals(record.getStart_time())){
           throw new Exception("la hora de inicio del registro es obligatoria");
       }
       //FK
        if(record.getEmployee() == null){
           throw new Exception("el registro del empleado es obigatorio");
       }
       if(record.getKey() == null){
           throw new Exception("el registro de la llave es obigatorio");
       }
       
       Record rExists = dbr.findById(record.getId());
       if(rExists == null){
           throw new Exception("el registro no existe");
       }       
       dbr.update(record);
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0){
           throw new Exception("El ID es obligatorio");
       }
       Record rExists = dbr.findById(id);
       if(rExists == null){
           throw new Exception("el registro no existe");
       }  
       dbr.delete(id);
    }

    @Override
    public List<Record> findAll() throws Exception {
        return dbr.findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
       if(id == 0){
           throw new Exception("el id es obligatorio");
       }
       return dbr.findById(id);
    }
    
}
