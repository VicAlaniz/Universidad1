/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_universidad;

import com.mysql.jdbc.Statement;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import universidad1.Conectar;
import universidad1.Materia;

/**
 *
 * @author Familia
 */
public class MateriaData {
     private Connection conn = null;
    
    public MateriaData(Conectar conexionMateria) throws SQLException{
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
        
    /**
     *
     * @return
     */
    public List<Materia> listarMaterias(){
        ArrayList<Materia> listaMaterias = new ArrayList<>();
        
        String query = "SELECT * FROM materia WHERE activo = true";
        
         try { 
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    Materia m = new Materia();
                    
                    m.setId_materia(rs.getInt("id_materia"));
                    m.setNombreMateria(rs.getString("nombre"));
                    m.setAnio(rs.getInt("anio"));
                    m.setActivo(rs.getBoolean("activo"));
                    
                    listaMaterias.add(m);
                  }
                    ps.close();
                            
                
            } catch (SQLException ex) {
                 JOptionPane.showInternalMessageDialog(null, "Error al obtener materia");
            }
        return listaMaterias;
    }
    
    public void actualizarMateria(Materia m){
        String query = "UPDATE materia SET nombreMaterias = ?, anio = ?, activo = ?, WHERE id_materia = ?";
        
         try {
             PreparedStatement ps = conn.prepareStatement(query);
             
             ps.setInt(4, m.getId_materia());
             ps.setString(1, m.getNombreMateria());
             ps.setInt(2, m.getAnio());
             ps.setBoolean(3, m.isActivo());
             
             if (ps.executeUpdate()>0){
               JOptionPane.showInternalMessageDialog(null, "Materia actualizada correctamente");  
             }
             else {
                 JOptionPane.showInternalMessageDialog(null, "Materia no cargada en el registro");
             }
             ps.close();
             
         } catch (SQLException ex) {
             JOptionPane.showInternalMessageDialog(null, "Error al actualizar materia");
         }
        
    }
    
    public void borrarMateria(int id_materia){
        String query = "UPDATE materia SET activo = false WHERE id_materia = ?";
        
         try {
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setInt(1, id_materia);
             if (ps.executeUpdate()>0){
               JOptionPane.showInternalMessageDialog(null, "Materia borrada correctamente");  
             }
             else {
                 JOptionPane.showInternalMessageDialog(null, "No se realizaron cambios");
             }
             ps.close();
             
         } catch (SQLException ex) {
             
             JOptionPane.showInternalMessageDialog(null, "Error al borrar");
         }
        
    }
}
