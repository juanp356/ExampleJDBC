/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.model.EmployeeType;
import java.util.List;

/**
 * fecha:25/03/2025
 * @author Aprendiz
 * objetivo: interface para el modelo EmployeeType
 */
public interface IEmployeeTypeController {
    public void insert(EmployeeType employeeType) throws Exception;
    public void update(EmployeeType employeeType) throws Exception;
    public void delete(int id) throws Exception;
    public List<EmployeeType> findAll() throws Exception;
    public EmployeeType finById(int id) throws Exception;  
}


