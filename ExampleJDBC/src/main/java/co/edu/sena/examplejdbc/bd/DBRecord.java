/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.bd.model.Employee;
import co.edu.sena.examplejdbc.bd.model.Key;
import co.edu.sena.examplejdbc.bd.model.Record;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanp
 */
public class DBRecord extends DBConnection{
    
    public void insert(Record record){
        try {
            conect();
            String sql = "INSERT INTO `record` (`id`, `date_record`, `start_time`, `end_time`, `employee_id`, `key_id`, `status`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, record.getId());
            preparedStatement.setString(2, record.getDate_record());
            preparedStatement.setString(3, record.getStart_time());
            preparedStatement.setString(4, record.getEnd_time());
            preparedStatement.setLong(5, record.getEmployee().getDocument());
            preparedStatement.setInt(6, record.getKey().getId());
            preparedStatement.setString(7, record.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
             MessageUtils.showErrorMessage("Error al insertar registro "+e.getMessage());
        }finally{
            disconect();
        }
    }
    
    public void update(Record record){
        try {
            conect();
            String sql = "UPDATE `record` SET `date_record`=?,`start_time`=?,`end_time`=?,`employee_id`=?,`key_id`=?,`status`=? WHERE`id`=?;";
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getDate_record());
            preparedStatement.setString(2, record.getStart_time());
            preparedStatement.setString(3, record.getEnd_time());
            preparedStatement.setLong(4, record.getEmployee().getDocument());
            preparedStatement.setInt(5, record.getKey().getId());
            preparedStatement.setString(6, record.getStatus());
            preparedStatement.setInt(7, record.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al actualizar registro "+e.getMessage());
        }finally{
            disconect();
        }
    }
    
    public void delete(int id){
        try {
            conect();
            String sql = "delete from record where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
             MessageUtils.showErrorMessage("Error al eliminar registro: "+ e.getMessage());
        }finally{
            disconect();
        }
    }
    
    public List<Record>findAll(){
        List<Record> results = new ArrayList<>();
        DBEmployee Dbe = new DBEmployee();
        DBKey Dbk = new DBKey();
        
        try {
            conect();
            String sql = "select * from record";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setStart_time(resultSet.getString("start_time"));
                record.setEnd_time(resultSet.getString("end_time"));
                Employee employee = Dbe.findById(resultSet.getLong("employee_id")); //FK
                Key key = Dbk.findById(resultSet.getInt("key_id")); //FK
                record.setStatus(resultSet.getString("status"));
                record.setEmployee(employee);
                record.setKey(key);
                results.add(record);
            }
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar registros "+ e.getMessage());
        }finally{
            
        }
        return results;
    }
    
    public Record findById(int id){
        Record record = null;
        DBEmployee Dbe = new DBEmployee();
        DBKey Dbk = new DBKey();
        try {
            conect();
            String sql = "select * from record where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setStart_time(resultSet.getString("start_time"));
                record.setEnd_time(resultSet.getString("end_time"));
                Employee employee = Dbe.findById(resultSet.getLong("employee_id")); //FK
                Key key = Dbk.findById(resultSet.getInt("key_id")); //FK
                record.setStatus(resultSet.getString("status"));
                record.setEmployee(employee);
                record.setKey(key);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar registro "+ e.getMessage());
        }finally{
            disconect();
        }
         return record;
    }
   
}
