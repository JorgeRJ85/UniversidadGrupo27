
package universidadgrupo27;

import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import universidadgrupo27.accesoADatos.AlumnoData;
import universidadgrupo27.accesoADatos.Conexion;
import universidadgrupo27.accesoADatos.InscripcionData;
import universidadgrupo27.accesoADatos.MateriaData;
import universidadgrupo27.entidades.Alumno;
import universidadgrupo27.entidades.Inscripcion;
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
       

    //Materia mat= new Materia("Fisica", 1,true);
    
    //mateData.guardarMateria(mat);
    
//    Materia materiabuscada = mateData.buscarMateria(2);
//   if (materiabuscada != null){
//       System.out.println("Nombre: " + materiabuscada.getNombre() );
//       System.out.println("Año: " + materiabuscada.getAnioMateria());
//   }
//        
//    }    
    
//    Materia quimica= new Materia (1, "Quimica", 2, true);
//
//    mateData.modificarMateria(quimica);

  //  mateData.eliminarMateria(1);
  
  //////////////////////////Materia lista//////////////////
//        for (Materia mm : mateData.listamateria()) {
//            System.out.println("IdMateria: " + mm.getIdMateria());
//            System.out.println("Nombre: " + mm.getNombre());
//            System.out.println("Año: " + mm.getAnioMateria());
//            System.out.println("_________________");
//        }
        
        MateriaData mateData= new MateriaData();   
        AlumnoData alData= new AlumnoData();
        InscripcionData InsData= new InscripcionData();
        
        
        Alumno alu1= alData.buscarAlumno(2);
        Materia mat1= mateData.buscarMateria(2);
        
        //Inscripcion ins1=new Inscripcion(alu1,mat1,8);
        //InsData.guardarInscripcion(ins1);
        
       //InsData.actualizarNota(2, 1, 6);
        
        //InsData.borrarInscripcionMateriaAlumno(2, 1);
        
//        for (Inscripcion inscripcion  : InsData.obtenerInscripciones()) {
//            
//            System.out.println("Id: "+inscripcion.getIdInscripcion());
//            System.out.println("Apellido: "+inscripcion.getAlumno().getApellido());
//            System.out.println("Nombre: "+inscripcion.getAlumno().getNombre());
//            System.out.println("Materia: "+inscripcion.getMateria().getNombre());
//        }
//        
     

        for (Alumno alumno : InsData.obtenerAlumnoMateria(3) ) {
            System.out.println("nombre: "+ alumno.getNombre());
            
        }

        
        

  }
  



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }  

