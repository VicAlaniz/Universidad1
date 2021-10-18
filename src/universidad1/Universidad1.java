/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad1;

import data_universidad.AlumnoData;
import data_universidad.CursadaData;
import data_universidad.MateriaData;

/**
 *
 * @author Administrador
 */
public class Universidad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conectar conexion = new Conectar();
        AlumnoData ad = new AlumnoData(conexion);
        MateriaData md = new MateriaData(conexion);
        CursadaData cd = new CursadaData(conexion);
        
        /*Alumno v = new Alumno("Alaniz", "Vivky", LocalDate.of(1985, 10, 11), 001, true);
        Alumno p = new Alumno("Baigorria", "Pato", LocalDate.of(1978, 12 ,01), 002, true);
        Alumno r = new Alumno("Alaniz", "Rama", LocalDate.of(1982,04,25), 003, true);
        
        Materia m = new Materia ("Matemáticas", 1, true);
        Materia i = new Materia ("Ingles", 1, true);
        Materia w = new Materia ("Web", 1, true);
        
        ad.guardarAlumno(v);
        ad.guardarAlumno(p);
        ad.guardarAlumno(r);
        
        System.out.println("Alumno guardado correctamente");
        
        md.guardarMateria(m);
        md.guardarMateria(i);
        md.guardarMateria(w);

        System.out.println("Materia guardada correctamente");
        
        md.borrarMateria(1);
        Alumno r = new Alumno(3, "Alaniz", "Rama", LocalDate.of(1982,04,25), 003, false);
        r.setActivo(true);
        ad.actualizarAlumno(r);*/
        
        Alumno v = ad.buscarAlumno(1);
        Materia i = md.buscarMateria(2);
        
        Cursada cr = new Cursada(i, v, 10, true);
        
        cd.guardarCursada(cr);
        
        System.out.println("Inscripcion realizada");

    }
    
}
