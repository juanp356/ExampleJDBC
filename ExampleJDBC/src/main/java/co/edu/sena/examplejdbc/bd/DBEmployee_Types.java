/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.bd.model.EmployeeType;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * fecha: 13/03/2025
 * @author Aprendiz
 * objetivo: permite consultas y transaciones en la tabla employee_type
 */
public class DBEmployee_Types extends DBConnection {

    public void insert(EmployeeType employeeType) {
        try {
            conect();
            String sql = "insert into employee_type (descript) values(?)"; 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeType.getDescript());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al insertar tipo de empleado" + e.getMessage());
        } finally {
            disconect();
        }
    }

    public void update(EmployeeType employeeType) {
        try {
            conect();
            String sql = "update employee_type set descript = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeType.getDescript());
            preparedStatement.setInt(2, employeeType.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al actualizar tipo de empleado" + e.getMessage());
        } finally {
            disconect();
        }
    }

    public void delete(int id) {
        try {
            conect();
            String sql = "delete from employee_type where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al eliminar tipo de empleado" + e.getMessage());
        } finally {
            disconect();
        }
    }

    public List<EmployeeType> findAll() {
        List<EmployeeType> results = new ArrayList();
        try {
            conect();
            String sql = "select * from employee_type";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmployeeType employeeType = new EmployeeType();
                employeeType.setId(resultSet.getInt("id"));
                employeeType.setDescript(resultSet.getString("descript"));
                results.add(employeeType);
            }
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipos de empleado" + e.getMessage());
        } finally {
            disconect();
        }
        return results;
    }

    public EmployeeType finById(int id) {
        EmployeeType employeeType = null;
        try {
            conect();
            String sql = "select * from employee_type where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employeeType = new EmployeeType();
                employeeType.setId(resultSet.getInt("id"));
                employeeType.setDescript(resultSet.getString("descript"));

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipo de empleado" + e.getMessage());
        } finally {
            disconect();
        }
        return employeeType;
    }
}
