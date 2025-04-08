/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.model.Employee;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class EmployeeController implements IEmployeeController{
private DBEmployee dbe = new DBEmployee();

    @Override
    public void insert(Employee employee) throws Exception {
        if(employee == null)
        {
            throw new Exception("El empleado es nulo");
        }
        
        if(employee.getDocument() == 0)
        {
            throw new Exception("El documento es oblogatorio");
        }
        
        if("".equals(employee.getFullname()))
        {
            throw new Exception("El nombre es oblogatorio");
        }
        
        if("".equals(employee.getDireccion()))
        {
            throw new Exception("La direccion es oblogatoria");
        }
        
        if("".equals(employee.getTelefono()))
        {
            throw new Exception("El telefono es oblogatorio");
        }
        
        //FK
        if(employee.getEmployeeType() == null)
        {
            throw new Exception("El tipo de empleado es oblogatorio");
        }
        
        //La FK no es autoincrementar, se debe validar existencia del empleado
        Employee employeeExists = dbe.findById(employee.getDocument());
        if(employeeExists != null)
        {
            throw new Exception("Ya existe un empleado con ese documento");
        }
        
        //insertar
        dbe.insert(employee);
    }

    @Override
    public void update(Employee employee) throws Exception {
        if(employee == null)
        {
            throw new Exception("El empleado es nulo");
        }
        
        if(employee.getDocument() == 0)
        {
            throw new Exception("El documento es oblogatorio");
        }
        
        if("".equals(employee.getFullname()))
        {
            throw new Exception("El nombre es oblogatorio");
        }
        
        if("".equals(employee.getDireccion()))
        {
            throw new Exception("La direccion es oblogatoria");
        }
        
        if("".equals(employee.getTelefono()))
        {
            throw new Exception("El telefono es oblogatorio");
        }
        
        //FK
        if(employee.getEmployeeType() == null)
        {
            throw new Exception("El tipo de empleado es oblogatorio");
        }
        
        
        Employee employeeExists = dbe.findById(employee.getDocument());
        if(employeeExists == null)
        {
            throw new Exception("El empleado no existe");
        }
        
        //actualizar
        dbe.update(employee);
    }

    @Override
    public void delete(long document) throws Exception {
        if(document == 0)
        {
            throw new Exception("El documento es oblogatorio");
        }
        
        Employee employeeExists = dbe.findById(document);
        if(employeeExists == null)
        {
            throw new Exception("El empleado no existe");
        }
        
        //eliiminar
        dbe.delete(document);
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return dbe.findAll();
    }

    @Override
    public Employee findById(long document) throws Exception {
       if(document == 0)
        {
            throw new Exception("El documento es oblogatorio");
        }
        
        Employee employeeExists = dbe.findById(document);
        if(employeeExists == null)
        {
            throw new Exception("El empleado no existe");
        }
        
        return dbe.findById(document);
    }
    
}
