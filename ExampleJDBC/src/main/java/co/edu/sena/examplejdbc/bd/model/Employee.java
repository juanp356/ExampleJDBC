/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.model;

/**

 * @author juanp
 fecha: 20/03/2025
 * @author Juan P

 * objetivo: representa la tabla employee
 */
public class Employee {
    private long document;
   private String fullname;
   private String direccion;
   private String telefono;
   private EmployeeType employeeType;

    public Employee() {
    }

    public Employee(long document, String fullname, String direccion, String telefono, EmployeeType employeeType) {
        this.document = document;
        this.fullname = fullname;
        this.direccion = direccion;
        this.telefono = telefono;
        this.employeeType = employeeType;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return  fullname;
    }
   
   
   
    
    
}
