
package universidadgrupo27;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import universidadgrupo27.accesoADatos.AlumnoData;
import universidadgrupo27.accesoADatos.Conexion;
import universidadgrupo27.accesoADatos.MateriaData;
import universidadgrupo27.entidades.Alumno;
import universidadgrupo27.entidades.Materia;


public class UniversidadGrupo27 {

    public static void main(String[] args) {
     
       Connection con= Conexion.getConnection();
       
       //Alumno juan = new Alumno(12121212, "Sosa", "Juan Pascal", LocalDate.of(1991, 3 , 26), true);
       //Alumno luis = new Alumno(145789, "Bala", "Carlos", LocalDate.of(1995, 10, 15), true);
       
//       AlumnoData alu = new AlumnoData();
       
       //alu.guardarAlumno(luis);
       
       //alu.modificarAlumno(juan);
       
//       alu.eliminarAlumno(1);
       
       //alu.buscarAlumno(2);
   
//       Alumno alumnoEncontrado = alu.buscarAlumnoPorDni(12121212);
//        if(alumnoEncontrado != null){
//        System.out.println("DNI: "+alumnoEncontrado.getDni());
//        System.out.println("Apellido: "+alumnoEncontrado.getApellido());
//        }
       
       //alu.listarAlumnos();
       
       // **********Listando Los Alumnos activos de la Base de datos ******
       
//       AlumnoData alu = new AlumnoData();
//       
//        for (Alumno alumno : alu.listarAlumnos()) {
//            System.out.println("==============================");
//            System.out.println("DNI: "+alumno.getDni());
//            System.out.println("Apellido: "+alumno.getApellido());
//            System.out.println("Nombre: "+alumno.getNombre());
//            System.out.println("Fecha de Nacimiento: "+alumno.getFechaNac());
//            System.out.println("==============================");
//                  
//            
//            
//        }
       

    Materia mat= new Materia("Lengua",2,true);
    MateriaData mateData= new MateriaData();    
    mateData.guardarMateria(mat);


        
        
        
    }
    
}
