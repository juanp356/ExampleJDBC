package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.model.Employee;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Aprendiz
 */
public interface IEmployeeController {
    public void insert(Employee employee) throws Exception;
    public void update(Employee employee)throws Exception;
    public void delete(long document) throws Exception;
    public List<Employee>findAll() throws Exception;
    public Employee findById(long document) throws Exception;
}

        

