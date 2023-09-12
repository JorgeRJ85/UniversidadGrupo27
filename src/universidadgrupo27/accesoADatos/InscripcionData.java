
package universidadgrupo27.accesoADatos;

import java.sql.Connection;


public class InscripcionData {
    
     private Connection con = null;

    public InscripcionData() {

        con = Conexion.getConnection();
    }
    
    private MateriaData matData;
    private AlumnoData aluData;
    
    
    

    
    
    
    
}
