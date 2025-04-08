/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.model;

/**
 * fecha: 13/03/2025
 * @author Juan P
 * objetivo: representa la tabla employee_type
 */
public class EmployeeType {
    private int id;
    private String descript;

    public EmployeeType() {
    }

    public EmployeeType(int id, String descript) {
        this.id = id;
        this.descript = descript;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public String toString() {
        return descript ;
    }
    
    
    
    
}
