/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_universidad;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidad1.Alumno;
import universidad1.Conectar;
import universidad1.Cursada;
import universidad1.Materia;

/**
 *
 * @author Administrador
 */
public class CursadaData {
    private Connection conn = null;
    private MateriaData md = null;
    private AlumnoData ad = null;

    public CursadaData(Conectar conn){
        this.conn = (Connection) conn.getConexion();
        md = new MateriaData(conn);
        ad = new AlumnoData(conn);
    }
    public void guardarCursada(Cursada c){
        String query = "INSERT INTO cursada(id_materia, id_alumno, nota, activo) VALUES (?,?,?,?)";
    
        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getMateria().getId_materia());
            ps.setInt(2, c.getAlumno().getId_alumno());
            ps.setDouble(3, c.getNota());
            ps.setBoolean(4, c.isActivo());
            
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                c.setId_cursada(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción realizada");
            }
            ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo efectuar la inscripción" + ex.getMessage());
        }
        
    }
    
    public void borrarCursada(int id_alumno, int id_materia) {
        String query = "DELETE FROM cursada WHERE id_materia = ? AND id_alumno = ?";
        
        
        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_materia);
            ps.setInt(2, id_alumno);
            
            if (ps.executeUpdate()>0){
               JOptionPane.showMessageDialog(null, "Inscripcion borrada");  
             }
             else {
                 JOptionPane.showMessageDialog(null, "Error al borrar inscripción");
             }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }     
    }
    
    public List<Cursada> obtenerInscripcion() {
         ArrayList<Cursada> listaCursadas = new ArrayList<>();
         String query = "SELECT * FROM cursada WHERE cursada.id_cursada = ? activo = true";

        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cursada c = new Cursada();

                c.setId_cursada(rs.getInt("id_cursada"));
                Alumno a = buscarAlumno(rs.getInt("id_alumno"));
                c.setAlumno(a);
                Materia m = buscarMateria(rs.getInt("id_materia"));
                c.setMateria(m);
                c.setNota(rs.getDouble("nota"));
                c.setActiva(rs.getBoolean("activo"));

                listaCursadas.add(c);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la lista");
        }
        return listaCursadas;
    }
        
    public List<Cursada> obtenerCursadasXAlumno(int id){
        Cursada ins=null;
        ArrayList<Cursada> cursadas = new ArrayList<>();

        String query = "SELECT * FROM cursada WHERE cursada.id_alumno = ? AND activo = true";
        try {
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id); 
            ResultSet rs = ps.executeQuery();            
            //Cursada cursada;
            while(rs.next()){
                ins = new Cursada();
                ins.setId_cursada(rs.getInt(1));
                
                Alumno a = buscarAlumno(rs.getInt("id_alumno"));
                ins.setAlumno(a);
                Materia m = buscarMateria(rs.getInt("id_materia"));
                ins.setMateria(m);
                
                ins.setNota(rs.getDouble("nota"));
                cursadas.add(ins);
            }      
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear la lista");
        }
        return cursadas;

        
    }
    public List<Materia> obtenerMateriasCursadas(int id_alumno) {
        ArrayList<Materia> listaMaterias = new ArrayList<>();
         String query = "SELECT materias.id_materia, materias.nombreMateria, materias.anio, materias.activo "
                    + "FROM materias, cursada "
                    + "WHERE materias.id_materia = cursada.id_materia "
                    + "AND cursada.activo = true "
                    + "AND cursada.id_alumno = ? ";

        try {

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id_alumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();

                m.setId_materia(rs.getInt("id_materia"));
                m.setNombreMateria(rs.getString("nombreMateria"));
                m.setAnio(rs.getInt("anio"));
                m.setActivo(rs.getBoolean("materias.activo"));

                listaMaterias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar materias" + ex);
        }
        return listaMaterias;
    }
    
    public List<Materia> obtenerMateriasNoCursadas(int id_alumno) {
        ArrayList<Materia> listaMaterias = new ArrayList<>();
           String query = "SELECT * "
                    + "FROM materias "
                    + "WHERE id_materia NOT IN (SELECT materias.id_materia "
                    + "FROM materias, cursada "
                    + "WHERE materias.id_materia = cursada.id_materia "
                    + "AND cursada.activo = true "
                    + "AND cursada.id_alumno = ?) ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id_alumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Materia m = new Materia();

                m.setId_materia(rs.getInt("id_materia"));
                m.setNombreMateria(rs.getString("nombreMateria"));
                m.setAnio(rs.getInt("anio"));
                m.setActivo(rs.getBoolean("activo"));

                listaMaterias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias" + ex);
        }
        return listaMaterias;
    }
    
    public List<Alumno> obtenerAlumnosXMateria(int id_materia) {
        ArrayList<Alumno> listaAlumnosXMateria = new ArrayList<>();
        String query = "SELECT alumnos.id_alumno, alumnos.apellido, alumnos.nombre, alumnos.fechaNac, alumnos.legajo, alumnos.activo "
                    + "FROM cursada, alumnos "
                    + "WHERE alumnos.id_alumno = cursada.id_alumno "
                    + "AND cursada.id_materia = ? "
                    + "AND alumnos.activo = true "
                    + "AND cursada.activo = true ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id_materia);
            ResultSet rst = ps.executeQuery();
            
            while(rst.next()){
                
                Alumno alum = new Alumno();
                alum.setId_alumno(rst.getInt("id_alumno"));
                alum.setApellido(rst.getString("apellido"));
                alum.setNombre(rst.getString("nombre"));
                alum.setFechaNac(rst.getDate("fechaNac").toLocalDate());
                alum.setLegajo(rst.getInt("legajo"));
                alum.setActivo(rst.getBoolean("activo"));
                
                listaAlumnosXMateria.add(alum);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR \nAlumnos No Encontrados");   
        }
        return listaAlumnosXMateria;
    }
    
        
   public void actualizarNotas(int id_cursada, double nota){
        String query = "UPDATE cursada SET nota = ? WHERE id_cursada = ?; ";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setDouble(1, nota); 
            ps.setInt(2, id_cursada);
            ps.executeUpdate();
            //if (ps.executeUpdate()>0){
               JOptionPane.showMessageDialog(null, "Nota Actualizada Correctamente");  
            // }
             //else {
               //  JOptionPane.showMessageDialog(null, "Error al cargar la nota");
             //}
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
       }

   public Alumno buscarAlumno(int id_alumno){
        Alumno a = new Alumno(); 
        String query = "SELECT a.id_alumno, a.apellido, a.nombre,  a.fechaNac, a.legajo, a.activo FROM cursada AS c, alumnos AS a WHERE c.id_alumno = a.id_alumno AND c.id_alumno = ?";
        try {
            PreparedStatement ps= conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_alumno);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                a.setLegajo(rs.getInt("legajo"));
                a.setActivo(rs.getBoolean("activo"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setId_alumno(rs.getInt("id_alumno"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion metodo buscar alumno");
        }
        return a;
    }
    public Materia buscarMateria(int id_materia){
        Materia m = new Materia(); 
        String query = "SELECT m.id_materia, m.nombreMateria, m.anio, m.activo FROM cursada AS c, materias AS m WHERE m.id_materia = c.id_materia AND m.id_materia = ?";
        try {
            PreparedStatement ps= conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_materia);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                m.setAnio(rs.getInt("anio"));
                m.setNombreMateria(rs.getString("nombreMateria"));
                m.setActivo(rs.getBoolean("activo"));
                m.setId_materia(rs.getInt("id_materia"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return m;
    }
}