/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo27.entidades;

import java.time.LocalDate;

/**
 *
 * @author ilux
 */
public class Alumno {
    
    private int idAlumno;
    private int dni;
    private String Apellido;
    private String Nombre;
    private LocalDate fechaNac;
    private boolean activo;

    public Alumno() {
    }

    public Alumno(int dni, String Apellido, String Nombre, LocalDate fechaNac, boolean activo) {
        this.dni = dni;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public Alumno(int idAlumno, int dni, String Apellido, String Nombre, LocalDate fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   @Override
    public String toString() {
        return ""+ dni + " - " + Apellido + " - " + Nombre;
    }
}
