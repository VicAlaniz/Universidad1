/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad1;

/**
 *
 * @author Administrador
 */
public class Cursada {
    private int id_cursada;
    private Materia materia;
    private Alumno alumno;
    private double nota;
    private boolean activo;

    public Cursada(int id_cursada, Materia materia, Alumno alumno, double nota, boolean activo) {
        this.id_cursada = id_cursada;
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
        this.activo = activo;
    }

    public Cursada(Materia materia, Alumno alumno, double nota, boolean activo) {
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
        this.activo = activo;
    }
    
    public Cursada(){
        
    }

    public Cursada(Materia materia, Alumno alumno, double nota) {
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

   

    public int getId_cursada() {
        return id_cursada;
    }

    public void setId_cursada(int id_cursada) {
        this.id_cursada = id_cursada;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActiva(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return id_cursada + "- " + materia + "- " + alumno;
    }
    
    
    
    
}
