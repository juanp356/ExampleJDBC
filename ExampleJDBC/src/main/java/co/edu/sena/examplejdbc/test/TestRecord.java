/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.bd.model.Employee;
import co.edu.sena.examplejdbc.bd.model.Key;
import co.edu.sena.examplejdbc.bd.model.Record;
import java.util.List;
/**
 *
 * @author juanp
 */
//
public class TestRecord {
    public static void main(String[] args) {
        DBRecord Dbr = new DBRecord();
        DBEmployee Dbe = new DBEmployee();
        DBKey Dbk = new DBKey();
        
        Employee employee = Dbe.findById(1118);
        Key key = Dbk.findById(3);
        Record record = new Record(6, "2025-03-19", "07:00:00", "13:00:00", employee, key, "ENTREGADO");
//        Dbr.insert(record);
        

      //Actualizar
      record.setStatus("PENDIENTE");
      employee = Dbe.findById(1116);
      key = Dbk.findById(3);
      record.setEmployee(employee);
      record.setKey(key);
     // Dbr.update(record);
     
     //Eliminar
//     Dbr.delete(4);


//     List<Record> records = Dbr.findAll();
//        for (Record r : records) {
//            System.out.println("id: "+r.getId()+" || date_record: "+r.getDate_record()+
//                               " || start_time: "+r.getStart_time()+" || end_time: "+r.getEnd_time()+
//                               " || status: "+r.getStatus()+" || employee: "+r.getEmployee().getDocument()+ " || key: "+r.getKey().getId());
//        }
        
        
    //Consultar por id
   
//    System.out.println("***********************");    
//    Record r2 = Dbr.findById(1);
//    System.out.println("id: "+r2.getId()+" || date_record: "+r2.getDate_record()+
//                               " || start_time: "+r2.getStart_time()+" || end_time: "+r2.getEnd_time()+
//                               " || status: "+r2.getStatus()+" || employee: "+r2.getEmployee().getDocument()+ " || key: "+r2.getKey().getId());
//    


     
      
    }
}
