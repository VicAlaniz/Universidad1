/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad1;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Alumno {
    private int id_alumno;
    private String apellido;
    private String nombre;
    private LocalDate fechaNac;
    private int legajo;
    private boolean activo;
    

    public Alumno(int id_alumno, String apellido, String nombre, LocalDate fechaNac, int legajo, boolean activo) {
        this.id_alumno = id_alumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.legajo = legajo;
        this.activo = activo;
    }

    public Alumno(String apellido, String nombre, LocalDate fechaNac, int legajo, boolean activo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.legajo = legajo;
        this.activo = activo;
    }
    
    public Alumno(){
        
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return id_alumno + "- " + apellido + ", " + nombre;
    }
    
    
}
