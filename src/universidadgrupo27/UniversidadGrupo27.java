
package universidadgrupo27;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import universidadgrupo27.accesoADatos.AlumnoData;
import universidadgrupo27.accesoADatos.Conexion;
import universidadgrupo27.entidades.Alumno;


public class UniversidadGrupo27 {

    public static void main(String[] args) {
     
       //Connection con= Conexion.getConnection();
       
       //Alumno juan = new Alumno(12121212, "Sosa", "Juan Pascal", LocalDate.of(1991, 3 , 26), true);
       //Alumno luis = new Alumno(145789, "Bala", "Carlos", LocalDate.of(1995, 10, 15), true);
       
       AlumnoData alu = new AlumnoData();
       
       //alu.guardarAlumno(luis);
       
       //alu.modificarAlumno(juan);
       
       //alu.eliminarAlumno(1);
       
       //alu.buscarAlumno(2);
       //alu.buscarAlumnoPorDni(14579);
       alu.listarAlumnos();
       
        
        
        
    }
    
}
