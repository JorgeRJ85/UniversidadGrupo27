
package universidadgrupo27.accesoADatos;

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

import universidadgrupo27.entidades.Materia;


public class MateriaData {
    
    private Connection con = null;
    
    public MateriaData (){
        con=Conexion.getConnection();
    }
    
    
    public void guardarMateria(Materia materia) {
        String sql="INSERT INTO materia( nombre, anio, estado)" 
        +"VALUES (? , ?, ?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"No se puede conectar a la tabla materia");
        }
        
    }
    
    public Materia buscarMateria (int id) {
         
        String sql = "SELECT `nombre`, `anio`, `estado` FROM `materia` WHERE idmateria = ? AND estado = 1";
        
        Materia materia = null;
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materia.setActivo(true);
                
                
            } else {JOptionPane.showMessageDialog(null, "La matería no existe!");}
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La tabla matería no se encuentra");
       }
        return materia;  
    }
    
   public void  modificarMateria (Materia materia){
       String sql="UPDATE materia SET nombre= ?,anio= ? "
               + "WHERE idMateria= ?";
       
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setInt(3, materia.getIdMateria());
            
            
            int exito= ps.executeUpdate();
             if (exito==1) {
                JOptionPane.showMessageDialog(null, "Materia modificada con exito");
                 
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void eliminarMateria(int id){
       
       String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Materia eliminada con exito");        
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La tabla matería no se encuentra");
        }
       
       
   }
   
   public List<Materia> listamateria(){
       
       
       String sql = "SELECT * FROM `materia` WHERE estado = 1";
       ArrayList<Materia> materias = new ArrayList<>();
       
       
       try {
           
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               
               Materia materia = new Materia();
               materia.setIdMateria(rs.getInt("idMateria"));
               materia.setNombre(rs.getNString("nombre"));
               materia.setAnioMateria(rs.getInt("anio"));
               materia.setActivo(true);
               
               materias.add(materia);
              
           }
           ps.close();
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
           
        }
       return materias;
       
   }
   
   
   
   
   
   
    
}
