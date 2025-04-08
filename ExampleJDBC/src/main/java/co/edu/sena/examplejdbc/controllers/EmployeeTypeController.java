/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBEmployee_Types;
import co.edu.sena.examplejdbc.bd.model.EmployeeType;
import java.util.List;

/**
 * fecha:25/03/2025
 * @author Aprendiz
 * objetivo: implementar la interface para controlar el modelo employeetype
 */
public class EmployeeTypeController  implements IEmployeeTypeController{

    private DBEmployee_Types dbe = new DBEmployee_Types();
    
    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        if(employeeType == null)
        {
            throw new Exception("El tipo de emepleado es nulo");
        }
        if("".equals(employeeType.getDescript())){
             throw new Exception("la descripcion es obligatoria");
        }
        //insertar
        dbe.insert(employeeType);
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if(employeeType == null){
            throw new Exception("El tipo de emepleado es nulo");
        }
        if(employeeType.getId() == 0)
        {
            throw new Exception("el id es obligatorio");
        }
        if("".equals(employeeType.getDescript())){
             throw new Exception("la descripcion es obligatoria");
        }
        
        //consultar si el empleado existe en la bd
        
        EmployeeType employeeTypeExist = dbe.finById(employeeType.getId());
        if(employeeTypeExist == null){
            throw new Exception("el tipo de empleado no existe");
        }
        
        dbe.update(employeeType);
    }

    @Override
    public void delete(int id) throws Exception {
       if(id == 0){
           throw new Exception("el id es obligatorio");
       }
       //consultar si el empleado existe en la bd
        
        EmployeeType employeeTypeExist = dbe.finById(id);
        if(employeeTypeExist == null){
            throw new Exception("el tipo de empleado no existe");
        }
        //eliminar
        dbe.delete(id);
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
      return dbe.findAll();
    }

    @Override
    public EmployeeType finById(int id) throws Exception {
         if(id == 0){
           throw new Exception("el id es obligatorio");
       }
       return dbe.finById(id);
    }
    
}
