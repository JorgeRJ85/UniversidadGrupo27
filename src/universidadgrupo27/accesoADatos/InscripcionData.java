
package universidadgrupo27.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    private MateriaData matData;
    private AlumnoData aluData;
    //private Alumno alumno;
    
    
    public void guardarInscripcion (Inscripcion inc){
        String sql="INSERT INTO `inscripcion`( nota, idAlumno, `idMateria`) "
                + "VALUES (?, ?, ?)";
        
        Alumno alumno=null;
        Materia materia=null;
         try {
             PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             
             ps.setDouble(1, inc.getNota());
             ps.setInt(2, inc.getAlumno().getIdAlumno() );
             ps.setInt(3, inc.getMateria().getIdMateria());
             
             ps.executeUpdate();
             
             ResultSet rs= ps.getGeneratedKeys();
             if (rs.next()) {
                 inc.setIdInscripcion(rs.getInt(1));
                 
                 JOptionPane.showMessageDialog(null, "Inscripcion agregadaa");
             }
             ps.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
        
        
        
        
    }
    
    
    

    
    
    
    
}
