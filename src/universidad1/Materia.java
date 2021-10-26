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
public class Materia {
    int id_materia;
    String nombreMateria;
    int anio;
    boolean activo;

    public Materia(int id_materia, String nombreMateria, int anio, boolean activo) {
        this.id_materia = id_materia;
        this.nombreMateria = nombreMateria;
        this.anio = anio;
        this.activo = activo;
    }

    public Materia(String nombreMateria, int anio, boolean activo) {
        this.nombreMateria = nombreMateria;
        this.anio = anio;
        this.activo = activo;
    }

    
    public Materia(){
        
    }

    public Materia(int id_materia, String nombreMateria, int anio) {
       //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return id_materia + "- " + nombreMateria;
    }
    
    
}
