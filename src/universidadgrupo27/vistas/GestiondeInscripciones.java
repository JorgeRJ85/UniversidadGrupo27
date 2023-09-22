/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package universidadgrupo27.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadgrupo27.accesoADatos.AlumnoData;
import universidadgrupo27.accesoADatos.InscripcionData;
import universidadgrupo27.entidades.Alumno;
import universidadgrupo27.entidades.Materia;

/**
 *
 * @author orell
 */
public class GestiondeInscripciones extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestiondeInscripciones
     */
    public GestiondeInscripciones() {
        initComponents();
        armarCabecera();
        cargarCombo();
    }

    private DefaultTableModel modelo = new DefaultTableModel();

    private void armarCabecera() {
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jrMateriaInscriptas = new javax.swing.JRadioButton();
        jrMateriasNoIncriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("INSCRIPCIONES");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Selecione un Alumno");

        jComboBox.setToolTipText("");
        jComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxMouseClicked(evt);
            }
        });
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrMateriaInscriptas);
        jrMateriaInscriptas.setText("Materias inscriptas");
        jrMateriaInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMateriaInscriptasActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrMateriasNoIncriptas);
        jrMateriasNoIncriptas.setText("Materias no inscriptas");
        jrMateriasNoIncriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMateriasNoIncriptasActionPerformed(evt);
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

        jbInscribir.setText("Inscribir");

        jbAnularInscripcion.setText("Anular Inscripcion");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jrMateriaInscriptas)
                        .addGap(18, 18, 18)
                        .addComponent(jrMateriasNoIncriptas))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbInscribir)
                        .addGap(18, 18, 18)
                        .addComponent(jbAnularInscripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrMateriaInscriptas)
                    .addComponent(jrMateriasNoIncriptas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbAnularInscripcion)
                    .addComponent(jbSalir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrMateriaInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMateriaInscriptasActionPerformed
        // TODO add your handling code here:

        Alumno alu = (Alumno) jComboBox.getSelectedItem();

        cargarTablaInscripta(alu.getIdAlumno());
    }//GEN-LAST:event_jrMateriaInscriptasActionPerformed

    private void jrMateriasNoIncriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMateriasNoIncriptasActionPerformed
        // TODO add your handling code here:
        Alumno alu = (Alumno) jComboBox.getSelectedItem();

        cargarTablaNoInscripta(alu.getIdAlumno());
        
    }//GEN-LAST:event_jrMateriasNoIncriptasActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Alumno> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrMateriaInscriptas;
    private javax.swing.JRadioButton jrMateriasNoIncriptas;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {

        AlumnoData aluData = new AlumnoData();

        List<Alumno> alumnos = aluData.listarAlumnos();

        for (Alumno alumno : alumnos) {

            jComboBox.addItem(alumno);

        }
        
    }

    private void cargarTablaInscripta(int idAlumno) {
        //AlumnoData aludata = new AlumnoData();

        InscripcionData insData = new InscripcionData(); // Instanciamos InscripcionData en "insData" para obtener sus metodos

        List<Materia> mate = insData.obtenerMateriaCursada(idAlumno); // Guardamos en "mate" el resultado del Metodos Obtener Materias Cursadas

        borrarFilas();
        for (Materia materia1 : mate) {
            modelo.addRow(new Object[]{materia1.getIdMateria(), materia1.getNombre(), materia1.getAnioMateria()});

        }
        
    }

    private void cargarTablaNoInscripta(int idAlumno) {

        InscripcionData insData = new InscripcionData();
        List<Materia> mate = insData.obtenerMateriaNoCursada(idAlumno);
        borrarFilas();

        for (Materia materia2 : mate) {
            modelo.addRow(new Object[]{materia2.getIdMateria(), materia2.getNombre(), materia2.getAnioMateria()});

        }

    }

    private void borrarFilas() {

        int filas = jTabla.getRowCount() - 1;

        for (int i = filas; i >= 0; i--) {

            modelo.removeRow(i);
        }
    }
}
