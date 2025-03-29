/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.bd.model.Key;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class KeyController implements IKeyController{
    
     DBKey dbk = new DBKey();
    
    @Override
    public void insert(Key key) throws Exception {
        if(key == null){
            throw new Exception("la llave es nula");
        }
        if(key.getId() == 0){
             throw new Exception("El id es oblogatorio");
        }
        if("".equals(key.getName())){
            throw new Exception("El nombre es oblogatorio");
        }
        if("".equals(key.getRoom())){
            throw new Exception("El salon es oblogatorio");
        }
        if(key.getCount() == -1){
             throw new Exception("la cantidad de llaves es incorrecta");
        }
        dbk.insert(key);
    }

    @Override
    public void update(Key key) throws Exception {
        if(key == null){
            throw new Exception("la llave es nula");
        }
        if(key.getId() == 0){
             throw new Exception("El id es oblogatorio");
        }
        if("".equals(key.getName())){
            throw new Exception("El nombre es oblogatorio");
        }
        if("".equals(key.getRoom())){
            throw new Exception("El salon es oblogatorio");
        }
        if(key.getCount() == -1){
             throw new Exception("la cantidad de llaves es incorrecta");
        }
        
        Key kExist = dbk.findById(key.getId());
        if(kExist == null){
             throw new Exception("la llave no existe");
        }
        
        dbk.update(key);
    }

    @Override
    public void delete(int id) throws Exception {
     if(id == 0){
         throw new Exception("el id es obligatorio");
     }
       Key kExist = dbk.findById(id);
        if(kExist == null){
             throw new Exception("el id no existe en la bd");
        }
        dbk.delete(id);
    }

    @Override
    public List<Key> findAll() throws Exception {
        return dbk.findAll();
    }

    @Override
    public Key findById(int id) throws Exception {
        if(id == 0){
         throw new Exception("el id es obligatorio");
     }
       Key kExist = dbk.findById(id);
        if(kExist == null){
             throw new Exception("el id no existe en la bd");
        }
        return dbk.findById(id);
    }
    
}
