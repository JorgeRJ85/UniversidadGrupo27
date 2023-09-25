/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo27.vistas;

import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadgrupo27.accesoADatos.InscripcionData;
import universidadgrupo27.accesoADatos.MateriaData;
import universidadgrupo27.entidades.Alumno;
import universidadgrupo27.entidades.Materia;

/**
 *
 * @author ilux
 */
public class ConsultaDeAlumnoPorMateria extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaDeAlumnoPorMateria
     */
    public ConsultaDeAlumnoPorMateria() {
        initComponents();
        cargarCombo();
        armarTabla();
        borrarFilas();
    }
    private DefaultTableModel modelo= new DefaultTableModel();
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de alumno por Materia");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione una Materia");

        jComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxItemStateChanged(evt);
            }
        });

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTabla.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jTablaComponentHidden(evt);
            }
        });
        jScrollPane1.setViewportView(jTabla);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(80, 80, 80))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jbSalir)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jTablaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTablaComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablaComponentHidden

    private void jComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxItemStateChanged
        // TODO add your handling code here:
        try{
            if (evt.getStateChange()==ItemEvent.SELECTED){
            Materia materia =(Materia) jComboBox.getSelectedItem();
            cargarTabla(materia.getIdMateria());
        }  
        }catch(ArrayIndexOutOfBoundsException ar){
            System.out.println(ar.getMessage());
        }   
    }//GEN-LAST:event_jComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTabla;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables

private void cargarCombo(){ 
    MateriaData matData= new MateriaData();
    
    List<Materia> mate = matData.listamateria();
    
    for (Materia materia : mate) {
        jComboBox.addItem(materia);
        
    }
}
private void cargarTabla(int idMateria){
        InscripcionData insData= new InscripcionData();
        List<Alumno> alu=insData.obtenerAlumnoMateria(idMateria);
        borrarFilas();
        for(Alumno alu1:alu){
        modelo.addRow(new Object[]{alu1.getIdAlumno(), alu1.getDni(), alu1.getApellido(), alu1.getNombre()});
        }
}

private void armarTabla(){
    modelo.addColumn("ID");
    modelo.addColumn("DNI");
    modelo.addColumn("Apellido");
    modelo.addColumn("Nombre");
    
    jTabla.setModel(modelo);
}

    private void borrarFilas() {

        int filas = jTabla.getRowCount() - 1;

        for (int i = filas; i >= 0; i--) {

            modelo.removeRow(i);
        }
    }
}
