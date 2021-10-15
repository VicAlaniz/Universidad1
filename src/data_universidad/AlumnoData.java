
package data_universidad;

import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidad1.Alumno;
import universidad1.Conectar;

public class AlumnoData {
    private Conectar conn = null;

    public AlumnoData(Conectar conexion){
        try {
            this.conn = (Conectar) conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarAlumno(Alumno alum){
        String query = "INSERT INTO alumno(apellido, nombre, fechaNac, legajo, activo)VALUES (?,?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alum.getApellido());
            ps.setString(2, alum.getNombre());
            ps.setDate(3, Date.valueOf(alum.getFechaNac()));
            ps.setInt(4, alum.getLegajo());
            ps.setBoolean(5, alum.isActivo());
            
            ps.executeUpdate();
            ResultSet rst = ps.getGeneratedKeys();
            
            if(rst.next()){
                alum.setId_alumno(rst.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Guardado Correctamente");
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nAlumno No Guardado");
        }
    }
    
    public List<Alumno> listaDeAlumnos(){
        ArrayList<Alumno> listaDeAlumnos = new ArrayList<>();
        
        String query = "SELECT * FROM alumno WHERE activo = true";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, 0);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                Alumno alum = new Alumno();
                alum.setId_alumno(rst.getInt(1));
                alum.setApellido(rst.getString(2));
                alum.setNombre(rst.getString(3));
                alum.setFechaNac(rst.getDate(4).toLocalDate());
                alum.setLegajo(rst.getInt(5));
                alum.setActivo(rst.getBoolean(6));
                
                listaDeAlumnos.add(alum);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nAlumnos No Encontrados");   
        }
        return listaDeAlumnos;
    }
    
    public Alumno buscarAlumno(int idAlumno){
        Alumno alum = null;
        
        String query = "SELECT * FROM alumno WHERE idAlumno = ? AND activo = true";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, idAlumno);
            ps.setInt(1, idAlumno);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                alum = new Alumno();
                alum.setId_alumno(rst.getInt("id_alumno"));
                alum.setLegajo(rst.getInt("legajo"));
                alum.setNombre(rst.getString("nombre"));
                alum.setApellido(rst.getString("apellido"));
                alum.setFechaNac(rst.getDate("fechaNac").toLocalDate());
                alum.setActivo(rst.getBoolean("activo"));
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nAlumno No Encontrado");
        }
        return alum;
    }
    
    public void borrarAlumno(int idAlumno){
        String query = "UPDATE alumno SET activo = false WHERE id_alumno = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, idAlumno);
            ps.setInt(1, idAlumno);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Alumno Borrado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al intentar borrar el alumno");
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nAlumno No Encontrado");
        }
    }
    
    public void actualizarAlumno(Alumno alum){
        String query = "UPDATE alumno SET apellido = ?, nombre = ?, fechaNac = ?, legajo = ?,  WHERE id_alumno = ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, 0);
            ps.setInt(6, alum.getId_alumno());
            
            ps.setString(1, alum.getApellido());
            ps.setString(2, alum.getNombre());
            ps.setDate(3, Date.valueOf(alum.getFechaNac()));
            ps.setInt(4, alum.getLegajo());
            ps.setBoolean(5, alum.isActivo());
            
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Alumno Actualizado Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al intentar actualizar el alumno");
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nAlumno No Encontrado");
        }
    }
}
