/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo27.vistas;

import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo27.accesoADatos.AlumnoData;
import universidadgrupo27.accesoADatos.InscripcionData;
import universidadgrupo27.accesoADatos.MateriaData;
import universidadgrupo27.entidades.Alumno;
import universidadgrupo27.entidades.Inscripcion;
import universidadgrupo27.entidades.Materia;

/**
 *
 * @author Luis
 */
public class ActualizacionDeNotas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ActualizacionDeNotas
     */
    public ActualizacionDeNotas() {
        initComponents();
        armarCabecera();
        cargarCombo();
    }

    private DefaultTableModel modelo = new DefaultTableModel() {
        // Hacer que las columnas 1 y 2 no sean editables
        @Override
        public boolean isCellEditable(int row, int column) {

            if (column == 2) { //Columna 1 hasta 2
                return true;
            } else {
                return false;
            }

        }
    };

    private void armarCabecera() {

        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        jTabla.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Carga de Notas");
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setText("Seleccione un alumno:");

        jComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxItemStateChanged(evt);
            }
        });

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTabla);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jbSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Alumno alumno = (Alumno) jComboBox.getSelectedItem();
            cargarTabla(alumno.getIdAlumno());

        }

    }//GEN-LAST:event_jComboBoxItemStateChanged

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        InscripcionData inscData = new InscripcionData();
        Alumno alumno = (Alumno) jComboBox.getSelectedItem();
        try {
            Integer idMateria = (Integer) jTabla.getValueAt(jTabla.getSelectedRow(), 0);
            String nota = jTabla.getValueAt(jTabla.getSelectedRow(), 2).toString();
            Double notaAlumno = Double.parseDouble(nota);

            if (notaAlumno >= 0 && notaAlumno <= 10) {

                inscData.actualizarNota(alumno.getIdAlumno(), idMateria, notaAlumno);
            } else {
                JOptionPane.showMessageDialog(this, "La calificacion debe estar entre 0 y 10");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en el valor Nota " + ex.getMessage());
        }

    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTabla;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {

        AlumnoData aludat = new AlumnoData();

        List<Alumno> alumnos = aludat.listarAlumnos();

        for (Alumno alumno : alumnos) {

            jComboBox.addItem(alumno);

        }
    }

    private void cargarTabla(int idAlumno) {

        InscripcionData inscData = new InscripcionData();        
        List<Inscripcion> insc = inscData.obtenerInscripcionesPorAlumno(idAlumno);
        borrarFilas();

        for (Inscripcion inscripcion : insc) {

            modelo.addRow(new Object[]{inscripcion.getMateria().getIdMateria(), inscripcion.getMateria().getNombre(), inscripcion.getNota()});

        }
    }

    private void borrarFilas() {

        int filas = jTabla.getRowCount() - 1;

        for (int i = filas; i >= 0; i--) {

            modelo.removeRow(i);
        }
    }

}
