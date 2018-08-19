/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristopher
 */
public class Conexion {

    Connection cnn;   //Conectar a la base de datos
    Statement state; //Ejecutar una query 
    ResultSet res; //Guarda el resultado de un select 

    public Conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");//Driver de conexion
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad?zeroDateTimeBehavior=convertToNull",
                    "root",
                    ""); //url,usuario,password
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int insertar(Persona p) {

        int bandera = 0;
        try {
            String query = "insert into persona (rut,nombre,edad) "
                    + "values('" + p.getRut() + "','" + p.getNombre() + "'," + p.getEdad() + ")";

            state = cnn.createStatement();
            bandera = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bandera;
    }
    
     public ResultSet consultarTodo(){
        
        try {
            String queryConsulta = "select* from persona";
            state = cnn.createStatement();
            res = state.executeQuery(queryConsulta); //resultset, retorna filas y columnas
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res; 
    }

}
