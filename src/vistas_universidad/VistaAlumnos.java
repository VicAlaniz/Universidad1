/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas_universidad;

import data_universidad.AlumnoData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import universidad1.Alumno;
import universidad1.Conectar;

/**
 *
 * @author Administrador
 */
public class VistaAlumnos extends javax.swing.JInternalFrame {
    private AlumnoData alumnoData;
    private Conectar conexion;

    /**
     * Creates new form VistaAlumnos
     */
    public VistaAlumnos() {
        
        initComponents();
        conexion = new Conectar();
        alumnoData = new AlumnoData(conexion);
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
        jlId = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlApellido = new javax.swing.JLabel();
        jlFechaNac = new javax.swing.JLabel();
        jlLegajo = new javax.swing.JLabel();
        jlActivo = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jtId = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        chActivo = new javax.swing.JCheckBox();
        jtLegajo = new javax.swing.JTextField();
        jdFechaNac = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jlTitulo.setText("ALUMNO");

        jlId.setText("ID");

        jlNombre.setText("NOMBRE");

        jlApellido.setText("APELLIDO");

        jlFechaNac.setText("FECHA NACIMIENTO");

        jlLegajo.setText("LEGAJO");

        jlActivo.setText("ACTIVO");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlActivo)
                                .addGap(18, 18, 18)
                                .addComponent(chActivo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlNombre)
                                    .addComponent(jlApellido))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlLegajo)
                                .addGap(34, 34, 34)
                                .addComponent(jtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(jbBorrar)
                                .addGap(18, 18, 18)
                                .addComponent(jbActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jbLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jlId)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtId))
                                    .addComponent(jlFechaNac, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbBuscar)
                            .addComponent(jlTitulo))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlTitulo)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlId)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlApellido)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlFechaNac)
                    .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLegajo)
                    .addComponent(jtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlActivo)
                    .addComponent(chActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbBorrar)
                    .addComponent(jbActualizar)
                    .addComponent(jbLimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        
        String nombre=jtNombre.getText();
        String apellido=jtApellido.getText();
        LocalDate fechaNac=LocalDate.parse(jdFechaNac.getDateFormatString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int legajo=Integer.parseInt(jtLegajo.getText());
        boolean activo=chActivo.isEnabled();
        
        Alumno alumno=new Alumno(apellido, nombre, fechaNac, legajo, activo);
        
        alumnoData.guardarAlumno(alumno);
        jtId.setText(alumno.getId_alumno()+"");
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        // TODO add your handling code here:
        
        int id=Integer.parseInt(jtId.getText());
        alumnoData.borrarAlumno(id);
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        
        if(jtId.getText()!=null){
            String nombre=jtNombre.getText();
            String apellido=jtApellido.getText();
            LocalDate fechaNac=LocalDate.parse(jdFechaNac.getDateFormatString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int legajo=Integer.parseInt(jtLegajo.getText());
            boolean activo=chActivo.isEnabled();
        
            Alumno alumno=new Alumno(apellido, nombre, fechaNac, legajo, activo);
            
            alumnoData.actualizarAlumno(alumno);
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // TODO add your handling code here:
        jtId.setText("");
        jtNombre.setText("");
        jtApellido.setText("");
        jdFechaNac.setToolTipText("");
        jtLegajo.setText("");
        chActivo.setEnabled(false);
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        
        int id=Integer.parseInt(jtId.getText());
        Alumno alumno=alumnoData.buscarAlumno(id);
        
        if(alumno!=null){
            jtId.setText(alumno.getId_alumno()+"");
            jtNombre.setText(alumno.getNombre());
            jtApellido.setText(alumno.getApellido());
            jdFechaNac.setDateFormatString(alumno.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            jtLegajo.setText(alumno.getLegajo()+"");
            chActivo.setSelected(alumno.isActivo());
        }
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private com.toedter.calendar.JDateChooser jdFechaNac;
    private javax.swing.JLabel jlActivo;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlFechaNac;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlLegajo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtLegajo;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
