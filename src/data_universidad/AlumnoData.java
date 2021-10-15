
package data_universidad;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import universidad1.Alumno;
import universidad1.Conectar;

public class AlumnoData {
    private Conectar conexion = null;

    public AlumnoData(Conectar conexion) throws SQLException {
        this.conexion = (Conectar) conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alum) throws SQLException{
        String query = "INSERT INTO alumno()VALUES (?,?,?,?,?,)";
        
        {
            PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alum.getNombre());
            ps.setString(2, alum.getApellido());
            
        }
        
    }  
    
}
