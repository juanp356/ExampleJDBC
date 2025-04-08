/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;


import static co.edu.sena.examplejdbc.bd.DBConnection.connection;
import static co.edu.sena.examplejdbc.bd.DBConnection.statement;

import co.edu.sena.examplejdbc.bd.model.Employee;
import co.edu.sena.examplejdbc.bd.model.EmployeeType;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 *fecha: 20/03/2025
 * @author Juan P
 * objetivo: Permite consultas y transacciones de la tabla employee
 */
public class DBEmployee extends DBConnection{
 
    
    public void insert (Employee employee){
        try {
            conect();
            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employee.getDocument());
            preparedStatement.setString(2, employee.getFullname());
            preparedStatement.setString(3, employee.getDireccion());
            preparedStatement.setString(4, employee.getTelefono());
            preparedStatement.setInt(5, employee.getEmployeeType().getId());  //FK
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
               MessageUtils.showErrorMessage("Error al insertar  empleado"+ e.getMessage());
        }finally{
            disconect();
        }  
    }
    
   public void update(Employee employee){
       try {
           conect();
           String sql = "UPDATE employee SET fullname=?, direccion=?, telefono=?, type_id=? WHERE document=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getFullname());
            preparedStatement.setString(2, employee.getDireccion());
            preparedStatement.setString(3, employee.getTelefono());
            preparedStatement.setInt(4, employee.getEmployeeType().getId());  //FK
            preparedStatement.setLong(5, employee.getDocument() ); 
            preparedStatement.executeUpdate();
            preparedStatement.close();
       } catch (SQLException e) {
           MessageUtils.showErrorMessage("Error al actualizar tipo de empleado: "+ e.getMessage());
       }finally{
           disconect();
       }
   }
   
   public void delete(long document){
       try {
           conect();
            String sql = "delete from employee where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, document);
            preparedStatement.executeUpdate();
            preparedStatement.close();
       } catch (Exception e) {
           MessageUtils.showErrorMessage("Error al eliminar tipo de empleado: "+ e.getMessage());
       }finally{
           disconect();
       } 
   }
    public List<Employee> findAll() {
        List<Employee> results = new ArrayList<>();
        DBEmployee_Types dbet = new DBEmployee_Types();

        try {
            conect();
            String sql = "select * from employee";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setDocument(resultSet.getLong("document"));
                employee.setFullname(resultSet.getString("fullname"));
                employee.setDireccion(resultSet.getString("direccion"));
                employee.setTelefono(resultSet.getString("telefono"));
                //FK
                EmployeeType employeeType = dbet.finById(resultSet.getInt("type_id"));
                employee.setEmployeeType(employeeType);
                results.add(employee);
            }
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipos de empleados " + e.getMessage());
        } finally {
            disconect();
        }
        return results;
    }
    
    public Employee findById(long document){
        Employee employee = null;
        DBEmployee_Types dbet = new DBEmployee_Types();
        
        try {
            conect();
            String sql = "select * from employee where document = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, document);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                employee = new Employee();
                employee.setDocument(resultSet.getLong("document"));
                employee.setFullname(resultSet.getString("fullname"));
                employee.setDireccion(resultSet.getString("direccion"));
                employee.setTelefono(resultSet.getString("telefono"));
                //FK
                EmployeeType employeeType = dbet.finById(resultSet.getInt("type_id"));
                employee.setEmployeeType(employeeType);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipo de empleados "+ e.getMessage());
            
        }finally{
            disconect();
        }
        return employee;
    }
   
}

    
 



