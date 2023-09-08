
package universidadgrupo27;

import java.sql.Connection;
import java.time.LocalDate;
import universidadgrupo27.accesoADatos.AlumnoData;
import universidadgrupo27.accesoADatos.Conexion;
import universidadgrupo27.entidades.Alumno;


public class UniversidadGrupo27 {

    public static void main(String[] args) {
     
       //Connection con= Conexion.getConnection();
       
       Alumno juan = new Alumno(12121212, "Sosa", "Juan", LocalDate.of(1991, 3 , 26), true);
       
       AlumnoData alu = new AlumnoData();
       
       alu.guardarAlumno(juan);
       
        
        
        
    }
    
}
