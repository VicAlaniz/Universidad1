/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas_universidad;

/**
 *
 * @author Administrador
 */
public class VistaMaterias extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaMaterias
     */
    public VistaMaterias() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlApellido = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jlTitulo = new javax.swing.JLabel();
        jlId = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jtId = new javax.swing.JTextField();
        jlNombre = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jlAnio = new javax.swing.JLabel();
        jtAnio = new javax.swing.JTextField();
        jlActivo = new javax.swing.JLabel();
        jcActivo = new javax.swing.JCheckBox();
        jbGuardar1 = new javax.swing.JButton();
        jbBorrar1 = new javax.swing.JButton();
        jbActualizar1 = new javax.swing.JButton();
        jbLimpiar1 = new javax.swing.JButton();

        jlApellido.setText("APELLIDO");

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");

        jbActualizar.setText("Actualizar");

        jbLimpiar.setText("Limpiar");

        jlTitulo.setText("MATERIA");

        jlId.setText("ID");

        jbBuscar.setText("Buscar");

        jlNombre.setText("NOMBRE");

        jlAnio.setText("AÑO");

        jlActivo.setText("ACTIVO");

        jbGuardar1.setText("Guardar");
        jbGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardar1ActionPerformed(evt);
            }
        });

        jbBorrar1.setText("Borrar");

        jbActualizar1.setText("Actualizar");

        jbLimpiar1.setText("Limpiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlNombre)
                                .addGap(27, 27, 27)
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlId)
                                .addGap(18, 18, 18)
                                .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jbBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlAnio)
                                .addGap(27, 27, 27)
                                .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlActivo)
                                .addGap(18, 18, 18)
                                .addComponent(jcActivo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbGuardar1)
                                .addGap(18, 18, 18)
                                .addComponent(jbBorrar1)
                                .addGap(18, 18, 18)
                                .addComponent(jbActualizar1)
                                .addGap(18, 18, 18)
                                .addComponent(jbLimpiar1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jlTitulo)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlId)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAnio)
                    .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlActivo)
                    .addComponent(jcActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar1)
                    .addComponent(jbBorrar1)
                    .addComponent(jbActualizar1)
                    .addComponent(jbLimpiar1))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbGuardar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbActualizar1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBorrar1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbGuardar1;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbLimpiar1;
    private javax.swing.JCheckBox jcActivo;
    private javax.swing.JLabel jlActivo;
    private javax.swing.JLabel jlAnio;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtAnio;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
