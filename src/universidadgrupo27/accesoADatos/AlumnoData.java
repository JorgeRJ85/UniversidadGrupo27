/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo27.accesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo27.entidades.Alumno;

/**
 *
 * @author Luis
 */
public class AlumnoData {
    
    private Connection con = null;
    
    public AlumnoData(){
        
        con = Conexion.getConnection();
    }
    
    public void guardarAlumno(Alumno alumno){
        
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado)"
                + "VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                
                JOptionPane.showMessageDialog(null, "Alumno Insertado con exito");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Alumno");
        }
        
        
        
    }
}
