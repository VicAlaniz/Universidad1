/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Conectar {
    Connection conn = null;
    
    public Connection getConexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:/localhost/universidad", "root", "");
                    
            System.out.println("Conexión establecida con éxito");        
                    } 
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar drivers");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }
        
        
        return conn;
    }

    public PreparedStatement prepareStatement(String query, int RETURN_GENERATED_KEYS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
