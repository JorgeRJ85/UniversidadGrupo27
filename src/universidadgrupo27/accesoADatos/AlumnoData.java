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
    
    public AlumnoData() {

        con = Conexion.getConnection();
    }

    public void guardarAlumno(Alumno alumno) {

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

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));

                JOptionPane.showMessageDialog(null, "Alumno Insertado con exito");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Alumno");
        }
    }

    public void modificarAlumno(Alumno alumno) {
        String sql = "Update alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=? "
                + "Where idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }

    public void eliminarAlumno(int id){
        
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "Alumno 'eliminado'");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public void buscarAlumno(int id){
        
        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet exito = ps.executeQuery();
            
            if (exito.next()){
             
                int idAlu = exito.getInt("idAlumno");
                String apellido = exito.getString("apellido");
                String nombre = exito.getNString("nombre");
                Boolean estado = exito.getBoolean("estado");
                
                System.out.println("idAlumno: "+idAlu);
                System.out.println("Apellido: "+apellido);
                System.out.println("Nombre: "+nombre);
                System.out.println("Estado: "+estado);    
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public void buscarAlumnoPorDni(int dni){
        
        String sql = "SELECT * FROM alumno WHERE dni = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet exito = ps.executeQuery();
            
            if(exito.next()){
                
                int idAlu = exito.getInt("idAlumno");
                String apellido = exito.getString("apellido");
                String nombre = exito.getNString("nombre");
                Boolean estado = exito.getBoolean("estado");
                
                System.out.println("idAlumno: "+idAlu);
                System.out.println("Apellido: "+apellido);
                System.out.println("Nombre: "+nombre);
                System.out.println("Estado: "+estado); 
                
            }else System.out.println("Alumno inexistente");            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public void listarAlumnos(){
        
        String sql = "SELECT * FROM alumno";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet exito = ps.executeQuery();
            
            while(exito.next()){
                
                int idAlu = exito.getInt("idAlumno");
                String apellido = exito.getString("apellido");
                String nombre = exito.getNString("nombre");
                Boolean estado = exito.getBoolean("estado");
                
                System.out.println("idAlumno: "+idAlu);
                System.out.println("Apellido: "+apellido);
                System.out.println("Nombre: "+nombre);
                System.out.println("Estado: "+estado); 
                System.out.println("--------------------");
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        
                
    }
    
}
