/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorPrincipal;

/**
 *
 * @author Milka
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    public ControladorPrincipal controlador;
    
    public VentanaPrincipal() {
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        initComponents();
        controlador = new ControladorPrincipal();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        registrarPaciente = new javax.swing.JMenuItem();
        paseLista = new javax.swing.JMenuItem();
        buscarPaciente = new javax.swing.JMenuItem();
        inventario = new javax.swing.JMenu();
        irAlInventario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Ventana");

        registrarPaciente.setText("Registrar paciente");
        registrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(registrarPaciente);

        paseLista.setText("Pasar Lista");
        paseLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paseListaActionPerformed(evt);
            }
        });
        jMenu1.add(paseLista);

        buscarPaciente.setText("Buscar Paciente");
        buscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(buscarPaciente);

        jMenuBar1.add(jMenu1);

        inventario.setText("Inventario");

        irAlInventario.setText("Ir al inventario");
        irAlInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irAlInventarioActionPerformed(evt);
            }
        });
        inventario.add(irAlInventario);

        jMenuBar1.add(inventario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paseListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paseListaActionPerformed
        System.gc();
        controlador.mostrarVentanaPaseDeLista();
    }//GEN-LAST:event_paseListaActionPerformed

    private void buscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPacienteActionPerformed
        System.gc();
        controlador.mostrarVentanaBuscar();
    }//GEN-LAST:event_buscarPacienteActionPerformed

    private void registrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPacienteActionPerformed
        System.gc();
        controlador.mostrarVentanaRegistroPacientes();
    }//GEN-LAST:event_registrarPacienteActionPerformed

    private void irAlInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irAlInventarioActionPerformed
        System.gc();
        controlador.mostrarVentanaInventario();
    }//GEN-LAST:event_irAlInventarioActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem buscarPaciente;
    private javax.swing.JMenu inventario;
    private javax.swing.JMenuItem irAlInventario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem paseLista;
    private javax.swing.JMenuItem registrarPaciente;
    // End of variables declaration//GEN-END:variables
}
