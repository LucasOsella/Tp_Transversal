/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesosDatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class Conexion {
    private static final String url="jdbc:mysql://localhost/";
    private static final String db="universidad";
    private static final String usuario="root";
    private static final String password="";
    
    
    public static Connection conexion;
    
    private Conexion(){
    }
    
    public static Connection getConexion(){
        if (conexion==null) {
             try {
                 Class.forName("org.mariadb.jdbc.Driver");
                 
                conexion= DriverManager.getConnection(url+db + "?useLegacyDatetimeCode=false&serverTimezone=UTC" +
                "&user=" + usuario + "&password=" + password);
                 //conexion = DriverManager.getConnection(url+db+usuario+password);
                 JOptionPane.showMessageDialog(null, "Conectado");
                
            } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "Error al conectar a la BD "+e);
            }catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null, "Error al cargar los drivers "+ex);            
        }       
    }
         return conexion;
    }
    
    
    
}//FIN

    

