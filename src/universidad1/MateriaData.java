/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad1;

import com.mysql.jdbc.Statement;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class MateriaData {
     private Connection conn = null;
    
    public MateriaData(Conectar conexionMateria){
        this.conn = conexionMateria.getConexion();
    }
    
    public void guardarMateria(Materia m){
        String query = "INSERT INTO materia(nombreMateria, anio, activo) VALUES(?, ?, ?)";
        
        
            try { 
                PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setNString(1, m.nombreMateria);
                ps.setInt(2, m.anio);
                ps.setBoolean(3, m.activo);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                
                if(rs.next())
                    m.setId_materia(rs.getInt(1));
                    JOptionPane.showInternalMessageDialog(null, "Materia Guardada");
                   
                    
                    ps.close();
                            
                
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "Error, no se pudo guardar la materia");
            }
    }
    
    public Materia buscarMateria(int id_materia){
        Materia m = null;
        String query = "SELECT * FROM materia WHERE id_materia = ? AND activo = true";
        
        try { 
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id_materia);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    m = new Materia();
                    
                    m.setId_materia(rs.getInt("id_materia"));
                    m.setNombreMateria(rs.getString("nombre"));
                    m.setAnio(rs.getInt("anio"));
                    m.setActivo(rs.getBoolean("activo"));
                    
                }
                    ps.close();
                            
                
            } catch (SQLException ex) {
                 JOptionPane.showInternalMessageDialog(null, "Error, no se pudo guardar la materia");
            }
        return m;
    }
        
        
    public List<Materia> listarMaterias(){
        
        Materia m = null;
        
        ArrayList<Materia> listaMaterias = new ArrayList<>();
        String query = "SELECT * FROM materia WHERE activo = true";
        
         try { 
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    m = new Materia();
                    
                    m.setId_materia(rs.getInt("id_materia"));
                    m.setNombreMateria(rs.getString("nombre"));
                    m.setAnio(rs.getInt("anio"));
                    m.setActivo(rs.getBoolean("activo"));
                    
                    listaMaterias.add(m);
                  }
                    ps.close();
                            
                
            } catch (SQLException ex) {
                 JOptionPane.showInternalMessageDialog(null, "Error, al obtener la materia");
            }
        return listaMaterias;
    }
    
    public void actualizarMateria(Materia m){
        
    }
    
    public void borrarMateria(int id){
        
    }
}
