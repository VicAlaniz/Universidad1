
package data_universidad;

import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String query = "INSERT INTO alumno(apellido, nombre, fechaNac, legajo, activo)VALUES (?,?,?,?,?,)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alum.getNombre());
            ps.setString(2, alum.getApellido());
            ps.setDate(3, Date.valueOf(alum.getFechaNac()));
            ps.setInt(4, alum.getLegajo());
            ps.setBoolean(5, alum.isActivo());
            
            ResultSet rst = ps.executeQuery();
        } catch (SQLException ex){
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
