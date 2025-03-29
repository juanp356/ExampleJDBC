/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.test;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.bd.model.Key;

import co.edu.sena.examplejdbc.bd.model.Key;

/**
 *
 * @author juanp
 */
public class TestKey {
    public static void main(String[] args) {
         DBKey dBKey = new DBKey();
        
        Key key = new Key(5,"ARCHIVERO","SALON ARCHIVOS",1,"Llaves color rojo");
        
        //Insertar
        //dBKey.insert(key);
        
        
        //Actualizar
//        key.setId(5);
//        key.setName("BICENTENARIO");
//        key.setRoom("SALON 202");
//        key.setCount(1);
//        key.setObservation("Llaves con color negro");
//        dBKey.update(key);


        //Eliminar
        //dBKey.delete(5);
        
        
        //List<Key> findAll = dBKey.findAll();
        
       // for (Key k : findAll) {
           // System.out.println("id: "+k.getId()+ "  observacion: "+k.getObservation());
        //}
        
        // consultar por id 
    
         Key key1 = dBKey.findById(4);
         
         if(key1 != null){
             System.out.println("id: "+key1.getId()+ "  observacion: "+key1.getObservation() + 
                              " nombre: "+key1.getName());
         }else{
             System.out.println("no existe la Key con ese id");
         }
    
    }

}
