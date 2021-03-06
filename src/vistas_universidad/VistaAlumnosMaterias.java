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
import javax.swing.table.DefaultTableModel;
import universidad1.Alumno;
import universidad1.Conectar;
import universidad1.Cursada;
import universidad1.Materia;

/**
 *
 * @author Administrador
 */
@SuppressWarnings("serial")
public final class VistaAlumnosMaterias extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private ArrayList<Cursada> listaCursadas;
    private ArrayList<Materia> listaMaterias;
    private CursadaData cursadaData;
    private MateriaData materiaData;
    private AlumnoData alumnoData;
    private ArrayList<Alumno> listaAlumnos;
    private Conectar conexion;
    /**
     * Creates new form VistaAlumnosMaterias
     */
    @SuppressWarnings("unchecked")
    public VistaAlumnosMaterias() {
        initComponents();
        
        conexion = new Conectar();
        modelo = new DefaultTableModel();
        
        cursadaData = new CursadaData(conexion);
        listaCursadas = (ArrayList)cursadaData.obtenerInscripcion();
        
        materiaData = new MateriaData(conexion);
        listaMaterias = (ArrayList)materiaData.listarMaterias();
        
        alumnoData = new AlumnoData(conexion);
        listaAlumnos = (ArrayList)alumnoData.listaDeAlumnos();
        
        cargarMaterias();
        armaCabeceraTabla();
        cargarDatos();  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jlMateria = new javax.swing.JLabel();
        jcMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jlTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlTitulo.setText("LISTADO DE ALUMNOS POR MATERIA");

        jlMateria.setText("MATERIAS:");

        jcMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMateriasActionPerformed(evt);
            }
        });

        jtAlumnos = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtAlumnos);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jlMateria)
                        .addGap(33, 33, 33)
                        .addComponent(jcMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlTitulo)
                        .addGap(216, 216, 216))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbSalir)
                        .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMateria)
                    .addComponent(jcMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMateriasActionPerformed
        // TODO add your handling code here:
        cargarDatos();
    }//GEN-LAST:event_jcMateriasActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
         dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    public void cargarMaterias() {
        
        for(Materia item: listaMaterias) {
            jcMaterias.addItem(item);
        }
    }
    
    public void armaCabeceraTabla() {
        jtAlumnos.getTableHeader().setReorderingAllowed(false);
        ArrayList<Object> columns = new ArrayList<Object>();
        
        columns.add("ID");
        columns.add("Nombre");
        columns.add("Nota");
        for (Object it:columns) {
            modelo.addColumn(it);
        }
        jtAlumnos.setModel(modelo);
    }
    
    public void borrarFilasTabla() {
        int a = modelo.getRowCount()-1;
        
        for(int i=a; i>=0; i--) {
            modelo.removeRow(i);
        }
    }
    
    public void cargarDatos() {
        borrarFilasTabla();
        
        Materia mat = (Materia)jcMaterias.getSelectedItem();
        
        for (Cursada m: listaCursadas) {
            if(m.getMateria().getId_materia()==mat.getId_materia()) {
                modelo.addRow(new Object[]{m.getAlumno().getId_alumno(), m.getAlumno().getNombre(), m.getNota()});
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Materia> jcMaterias;
    private javax.swing.JLabel jlMateria;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTable jtAlumnos;
    // End of variables declaration//GEN-END:variables
}
