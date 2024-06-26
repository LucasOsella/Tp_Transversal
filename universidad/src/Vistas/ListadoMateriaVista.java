/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesosDatos.AlumnoData;
import AccesosDatos.InscripcionData;
import AccesosDatos.MateriaData;
import Entidades.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan fua el Diego
 */
public class ListadoMateriaVista extends javax.swing.JInternalFrame {
private DefaultTableModel modelo = new DefaultTableModel();
private List<Materia>materias;
private List<Alumno>alumnos;
private AlumnoData almD;
private MateriaData mtd;
private InscripcionData insD;
    /**
     * Creates new form ListadoMateria
     */
    public ListadoMateriaVista() {
        initComponents();
        almD=new AlumnoData();
        mtd=new MateriaData();
        insD=new InscripcionData();
        armarLista();
        alumnos=almD.listarAlumno();
        materias=mtd.listarMateria();
        
        cargarAlumnos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
     private void armarLista() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        jtListaMaterias.setModel(modelo);             
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        Titulo = new javax.swing.JLabel();
        jLabelSeleccion = new javax.swing.JLabel();
        jComboBoxAlumno = new javax.swing.JComboBox<>();
        Titulo1 = new javax.swing.JLabel();
        JRBInscriptas = new javax.swing.JRadioButton();
        JRBnoInscrpitas = new javax.swing.JRadioButton();
        jB_inscribir = new javax.swing.JButton();
        jB_AnularInscripcion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtListaMaterias = new javax.swing.JTable();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable3);

        Titulo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        Titulo.setText("Formulario de Inscripcion");

        jLabelSeleccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSeleccion.setText("Seleccione un alumno");

        jComboBoxAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAlumnoItemStateChanged(evt);
            }
        });

        Titulo1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        Titulo1.setText("Listado de Materias ");

        JRBInscriptas.setText("Materias Inscriptas");
        JRBInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBInscriptasActionPerformed(evt);
            }
        });

        JRBnoInscrpitas.setText("Materias no Inscriptas");
        JRBnoInscrpitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBnoInscrpitasActionPerformed(evt);
            }
        });

        jB_inscribir.setText("Inscribir");
        jB_inscribir.setEnabled(false);
        jB_inscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_inscribirActionPerformed(evt);
            }
        });

        jB_AnularInscripcion.setText("Anular Inscripcion");
        jB_AnularInscripcion.setEnabled(false);
        jB_AnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AnularInscripcionActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtListaMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jtListaMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelSeleccion)
                            .addComponent(JRBInscriptas))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JRBnoInscrpitas))
                            .addComponent(jComboBoxAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(Titulo1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(Titulo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jB_inscribir)
                .addGap(157, 157, 157)
                .addComponent(jB_AnularInscripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSeleccion)
                    .addComponent(jComboBoxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(Titulo1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRBInscriptas)
                    .addComponent(JRBnoInscrpitas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_inscribir)
                    .addComponent(jB_AnularInscripcion)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRBnoInscrpitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBnoInscrpitasActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        JRBInscriptas.setSelected(false);
        cargarDatosNoInscripto();
        jB_AnularInscripcion.setEnabled(false);
        jB_inscribir.setEnabled(true);
       
    }//GEN-LAST:event_JRBnoInscrpitasActionPerformed

    private void jComboBoxAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAlumnoItemStateChanged
        // TODO add your handling code here:          
    }//GEN-LAST:event_jComboBoxAlumnoItemStateChanged

    private void JRBInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBInscriptasActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        JRBnoInscrpitas.setSelected(false);
        cargarDatosInscriptas();
        jB_AnularInscripcion.setEnabled(true);
        jB_inscribir.setEnabled(false);
        
    }//GEN-LAST:event_JRBInscriptasActionPerformed

    private void jB_inscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_inscribirActionPerformed
        // TODO add your handling code here:
        int filaSelectionada=jtListaMaterias.getSelectedRow();
        if (filaSelectionada!=-1) {
            
            Alumno a=(Alumno)jComboBoxAlumno.getSelectedItem();
            
            int id_materia =(Integer) modelo.getValueAt(filaSelectionada, 0);
            String nombre_materia=(String) modelo.getValueAt(filaSelectionada, 1);
            int año_materia=(Integer) modelo.getValueAt(filaSelectionada, 2);
            Materia m=new Materia(id_materia,nombre_materia,año_materia,true);
            
            Inscripcion ins=new Inscripcion(0,a,m);
            insD.guardarInscripcion(ins);
            borrarFilas();
        }
    }//GEN-LAST:event_jB_inscribirActionPerformed

    private void jB_AnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AnularInscripcionActionPerformed
        // TODO add your handling code here:
        int filaSelectionada=jtListaMaterias.getSelectedRow();
        
        if (filaSelectionada!=-1) {
            Alumno a=(Alumno)jComboBoxAlumno.getSelectedItem();
            int id_materia =(Integer) modelo.getValueAt(filaSelectionada, 0);
            
            insD.borrarInscripcionMateriaAlumno(a.getId_alumno(), id_materia);
            borrarFilas();
            
        }
       
        
        
    }//GEN-LAST:event_jB_AnularInscripcionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void borrarFilas(){
        int filas = jtListaMaterias.getRowCount() - 1;
        
        for(int f = filas; f >= 0; f-- ){
            modelo.removeRow(f);
        }
    }
    
    private void cargarDatosNoInscripto(){
     Alumno alumnos= (Alumno) jComboBoxAlumno.getSelectedItem();
     
    List<Materia> materias= insD.obtenerMateriasNoCursadas(alumnos.getId_alumno());
     
        for (Materia m : materias) {
            modelo.addRow(new Object[]{m.getId_materia(),m.getNombre(),m.getAño()});
            
        }
    }
            
   private void cargarDatosInscriptas(){
   Alumno alumnos=(Alumno) jComboBoxAlumno.getSelectedItem();
   
   List <Materia>materias=insD.obtenerMateriasCursadas(alumnos.getId_alumno());
   
       for (Materia m : materias) {
           modelo.addRow(new Object[]{m.getId_materia(),m.getNombre(),m.getAño()});
       }
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JRBInscriptas;
    private javax.swing.JRadioButton JRBnoInscrpitas;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel Titulo1;
    private javax.swing.JButton jB_AnularInscripcion;
    private javax.swing.JButton jB_inscribir;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Alumno> jComboBoxAlumno;
    private javax.swing.JLabel jLabelSeleccion;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jtListaMaterias;
    // End of variables declaration//GEN-END:variables

    private void cargarAlumnos() {
        for (Alumno item:alumnos) {
            jComboBoxAlumno.addItem(item);            
        }
    }
}
