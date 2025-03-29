/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.test;

import co.edu.sena.examplejdbc.bd.DBConnection;

/**
 *
 * @author Aprendiz
 */
public class TestConnection {
   public static void main(String[] args) {
        DBConnection connection = new  DBConnection();
        connection.conect();
        connection.disconect();
    }
}
