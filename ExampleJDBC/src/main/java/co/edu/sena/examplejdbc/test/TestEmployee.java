/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBEmployee_Types;
import co.edu.sena.examplejdbc.bd.model.Employee;
import co.edu.sena.examplejdbc.bd.model.EmployeeType;
import java.util.List;

/**
 * @author juan p
 * Objective: probar consulta/transacciones en tabla employee
 */
public class TestEmployee {
    public static void main(String[] args){
      DBEmployee dbe = new DBEmployee();
        DBEmployee_Types dbet = new DBEmployee_Types();
        
        //insertar
        EmployeeType employeeType = dbet.finById(1);
        Employee employee = new Employee(111625896, "ELSA BROSÓN", "Av 5a", "310", employeeType);
//        dbe.insert(employee);
        
        //modificar
        employee.setFullname("BARRANCA BERMEJA");
        employeeType = dbet.finById(2);  //FK
        employee.setEmployeeType(employeeType);
        dbe.update(employee);
//        
//        //eliminar
//        dbe.delete(111625896);
        
        //consultar todos
        List<Employee> employees = dbe.findAll();
        for (Employee e : employees){
            System.out.println("document: " + e.getDocument() + " fullname: " + e.getFullname() + " direccion: " + e.getDireccion()+ " telefono: " + e.getTelefono() + " type: " + e.getEmployeeType().getDescript());
        }
        
        //consultar por id
        System.out.println("***********");
        Employee employee2 = dbe.findById(1115);
        System.out.println("document: "+ employee2.getDocument() + " fullname: " + employee2.getFullname() + " direccion: " + employee2.getDireccion() + " telefono: " + employee2.getTelefono() + " type: " + employee2.getEmployeeType().getDescript());
        
        

    }
        
    }


    