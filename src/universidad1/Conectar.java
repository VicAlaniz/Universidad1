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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Conectar {
    Connection conn = null;
    
    public Connection getConexion() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:/localhost/universidad", "root", "");
                    
            System.out.println("Conexión establecida con éxito");        
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return conn;
    }

    public PreparedStatement prepareStatement(String query, int RETURN_GENERATED_KEYS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
