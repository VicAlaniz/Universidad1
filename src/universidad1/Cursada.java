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
    int id_cursada;
    Materia id_materia;
    Alumno id_alumno;
    double nota;
    boolean activa;

    public Cursada(int id_cursada, Materia id_materia, Alumno id_alumno, double nota, boolean activa) {
        this.id_cursada = id_cursada;
        this.id_materia = id_materia;
        this.id_alumno = id_alumno;
        this.nota = nota;
        this.activa = activa;
    }

    public int getId_cursada() {
        return id_cursada;
    }

    public void setId_cursada(int id_cursada) {
        this.id_cursada = id_cursada;
    }

    public Materia getId_materia() {
        return id_materia;
    }

    public void setId_materia(Materia id_materia) {
        this.id_materia = id_materia;
    }

    public Alumno getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Alumno id_alumno) {
        this.id_alumno = id_alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    
    
    
}
