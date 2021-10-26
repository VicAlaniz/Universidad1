/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas_universidad;

import data_universidad.AlumnoData;
import data_universidad.CursadaData;
import data_universidad.MateriaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidad1.Alumno;
import universidad1.Conectar;
import universidad1.Cursada;
import universidad1.Materia;

/**
 *
 * @author rataq
 */
public class VistaInscripciones extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    private ArrayList<Cursada> listaCursada;
    private ArrayList<Materia> listaMaterias;
    private ArrayList<Alumno> listaAlumnos;
    private CursadaData cursadaData;
    private MateriaData materiaData;
    private AlumnoData alumnoData;
    private Conectar conexion;
    
    /**
     * Creates new form VistaInscripciones
     */

    public VistaInscripciones() {
        initComponents();
        conexion = new Conectar();
        alumnoData = new AlumnoData(conexion);
        cargarAlumnos();
        armarCabecera();
      
 
        materiaData = new MateriaData(conexion);
        listaMaterias = (ArrayList)materiaData.listarMaterias();
       
    }
    
    public void cargarAlumnos() {
        List <Alumno> alumnos = alumnoData.listaDeAlumnos();
        
        for (Alumno a:alumnos){
            jcbAlumnos.addItem(a);
        }
    }
    public void armarCabecera() {
        //jtMaterias.getTableHeader().setReorderingAllowed(false);
        ArrayList<Object> columnas = new ArrayList<Object>();
        
        columnas.add("ID");
        columnas.add("Nombre");
        columnas.add("Año");
        
        for(Object it: columnas) {
            modelo.addColumn(it);
        }
        jtMaterias.setModel(modelo);
    }
    
     public void borrarFilasTabla() {
        int a = modelo.getRowCount()-1;
        
        for(int i=a; i>=0; i--) {
            modelo.removeRow(i);
        }
    }
     public void cargarDatosInscriptas() {
         borrarFilasTabla();
         
         CursadaData cd = new CursadaData(conexion);
         
         Alumno select = (Alumno) jcbAlumnos.getSelectedItem();
         listaMaterias = (ArrayList)cd.obtenerMateriasCursadas(select.getId_alumno());
         
         for(Materia m: listaMaterias) {
             modelo.addRow(new Object[]{m.getId_materia(), m.getNombreMateria(), m.getAnio()});
         }
     }
     public void cargarDatosNoInscriptas() {
         borrarFilasTabla();
         
         CursadaData cd = new CursadaData(conexion);
         
         Alumno select = (Alumno) jcbAlumnos.getSelectedItem();
         listaMaterias = (ArrayList)cd.obtenerMateriasNoCursadas(select.getId_alumno());
         
         for(Materia m: listaMaterias) {
             modelo.addRow(new Object[]{m.getId_materia(), m.getNombreMateria(), m.getAnio()});
         }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gbBotones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumnos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jrbInscripta = new javax.swing.JRadioButton();
        jrbNoInscripta = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbAnular = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Alumno");

        jcbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnosActionPerformed(evt);
            }
        });

        jLabel3.setText("LISTA DE MATERIAS");

        gbBotones.add(jrbInscripta);
        jrbInscripta.setText("Inscripta");
        jrbInscripta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInscriptaActionPerformed(evt);
            }
        });

        gbBotones.add(jrbNoInscripta);
        jrbNoInscripta.setText("No Inscripta");
        jrbNoInscripta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNoInscriptaActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ));
        jScrollPane1.setViewportView(jtMaterias);

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbAnular.setText("Anular Inscripción");
        jbAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(154, 154, 154))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jrbNoInscripta)
                                    .addComponent(jLabel1))
                                .addGap(82, 82, 82))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbInscripta)
                            .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jbInscribir)
                .addGap(39, 39, 39)
                .addComponent(jbAnular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbInscripta)
                    .addComponent(jrbNoInscripta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbAnular)
                    .addComponent(jbSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAlumnosActionPerformed

    private void jrbInscriptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInscriptaActionPerformed
        // TODO add your handling code here:
        jrbInscripta.setSelected(false);
        cargarDatosInscriptas();
        jbAnular.setEnabled(true);
        jbInscribir.setEnabled(false);
    }//GEN-LAST:event_jrbInscriptaActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        // TODO add your handling code here:
        int filaSelect = jtMaterias.getSelectedRow();
        
        if (filaSelect !=-1) {
            Alumno a = (Alumno) jcbAlumnos.getSelectedItem();
            
            int id_materia = (Integer)modelo.getValueAt(filaSelect, 0);
            String nombreMateria = (String)modelo.getValueAt(filaSelect, 1);
            int anio = (Integer)modelo.getValueAt(filaSelect, 2);
            
            Materia mat = new Materia(id_materia, nombreMateria, anio);
            Cursada cur = new Cursada(mat, a, 0, true);
            CursadaData cd = new CursadaData(conexion);
            cd.guardarCursada(cur);
            borrarFilasTabla();
        }
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jbAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularActionPerformed
        // TODO add your handling code here:
         int filaSelect = jtMaterias.getSelectedRow();
        
        if (filaSelect !=-1) {
            Alumno a = (Alumno) jcbAlumnos.getSelectedItem();
            
            int id_materia = (Integer)modelo.getValueAt(filaSelect, 0);
           
            
            CursadaData cd = new CursadaData(conexion);
            cd.borrarCursada(a.getId_alumno(), id_materia);
            borrarFilasTabla();
        }
    }//GEN-LAST:event_jbAnularActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jrbNoInscriptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNoInscriptaActionPerformed
        // TODO add your handling code here:
        jrbInscripta.setSelected(false);
        cargarDatosNoInscriptas();
        jbAnular.setEnabled(false);
        jbInscribir.setEnabled(true);
    }//GEN-LAST:event_jrbNoInscriptaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gbBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnular;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumnos;
    private javax.swing.JRadioButton jrbInscripta;
    private javax.swing.JRadioButton jrbNoInscripta;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables
}
