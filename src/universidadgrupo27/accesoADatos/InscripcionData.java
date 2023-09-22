package universidadgrupo27.accesoADatos;

import com.sun.javafx.font.FontConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo27.entidades.Alumno;
import universidadgrupo27.entidades.Inscripcion;
import universidadgrupo27.entidades.Materia;

public class InscripcionData {

    private Connection con = null;

    public InscripcionData() {

        con = Conexion.getConnection();
    }

    private MateriaData matData = new MateriaData();

    private AlumnoData aluData = new AlumnoData();
    //private Alumno alumno;

    public void guardarInscripcion(Inscripcion inc) {
        String sql = "INSERT INTO `inscripcion`( nota, idAlumno, `idMateria`) "
                + "VALUES (?, ?, ?)";

        Alumno alumno = null;
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, inc.getNota());
            ps.setInt(2, inc.getAlumno().getIdAlumno());
            ps.setInt(3, inc.getMateria().getIdMateria());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inc.setIdInscripcion(rs.getInt(1));

                JOptionPane.showMessageDialog(null, "Inscripcion agregadaa");
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

        // String sql= "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?";
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();

            System.out.println(filas);
            if (filas > 0) {

                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla");
        }

    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? and idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> cursadas = new ArrayList<>();

        String sql = "SELECT * FROM  inscripcion";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu = aluData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mate = matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mate);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursadas;

    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
            ArrayList<Inscripcion> cursadas=new ArrayList<>();
            
            String sql= "SELECT * FROM  inscripcion WHERE idAlumno = ?";
             
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idAlumno);
             ResultSet rs=ps.executeQuery();
             
             while (rs.next()) {
                 Inscripcion insc=new Inscripcion();
                 insc.setIdInscripcion(rs.getInt("idInscripto"));
                 Alumno alu=aluData.buscarAlumno(rs.getInt("idAlumno"));
                 Materia mate=matData.buscarMateria(rs.getInt("idMateria"));
                 insc.setAlumno(alu);
                 insc.setMateria(mate);
                 insc.setNota(rs.getDouble("nota"));
                 cursadas.add(insc);
              }
             
             ps.close();
         } catch (SQLException ex) {
             Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
         }          
          return cursadas;
    }
    
    public List<Materia> obtenerMateriaCursada(int idAlumno){
        
        ArrayList<Materia> materias = new ArrayList<>();
        
        String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion,"
                + " materia WHERE inscripcion.idMateria = materia.idMateria"
                + " AND inscripcion.idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materia materia = new Materia();
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materias.add(materia);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return materias;
    }
    
    public List<Materia> obtenerMateriaNoCursada(int idAlumno){
        
        ArrayList<Materia> materias =new ArrayList<>();
        
        String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria not in "
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno =?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materia materia = new Materia();
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materias.add(materia);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        
        return materias;
        
    }

    public List<Alumno> obtenerAlumnoMateria(int idMateria){
        ArrayList<Alumno> alumnosMateria=new ArrayList<>();
        String sql= "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "
                + "FROM inscripcion i, alumno a WHERE i.idAlumno=a.idAlumno AND idMateria=? AND estado=1";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                
                alumnosMateria.add(alumno);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla  Materia");
        }
        return  alumnosMateria;
     
        
    }
}
