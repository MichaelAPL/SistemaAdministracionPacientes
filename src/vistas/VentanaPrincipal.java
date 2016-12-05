
package vistas;

import controladores.ControladorPrincipal;

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
        jMenu2 = new javax.swing.JMenu();
        irAlInventario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Actividades");

        registrarPaciente.setText("Registrar paciente");
        registrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarProcesoRegistroPaciente(evt);
            }
        });
        jMenu1.add(registrarPaciente);

        paseLista.setText("Pasar Lista");
        paseLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarProcesoPasarlista(evt);
            }
        });
        jMenu1.add(paseLista);

        buscarPaciente.setText("Buscar Paciente");
        buscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarProcesoBuscarPaciente(evt);
            }
        });
        jMenu1.add(buscarPaciente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Inventario");

        irAlInventario.setText("Ir al inventario");
        irAlInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarProcesoVerInventario(evt);
            }
        });
        jMenu2.add(irAlInventario);

        jMenuBar1.add(jMenu2);

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

    private void iniciarProcesoPasarlista(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarProcesoPasarlista
        controlador.llamarControladorVentanaPaseDeLista();
    }//GEN-LAST:event_iniciarProcesoPasarlista

    private void iniciarProcesoBuscarPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarProcesoBuscarPaciente
        controlador.llamarControladorVentanaBuscar();
    }//GEN-LAST:event_iniciarProcesoBuscarPaciente

    private void iniciarProcesoRegistroPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarProcesoRegistroPaciente
        controlador.llamarControladorVentanaRegistroPacientes();
    }//GEN-LAST:event_iniciarProcesoRegistroPaciente

    private void iniciarProcesoVerInventario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarProcesoVerInventario
        controlador.llamarControladorVentanaInventario();
    }//GEN-LAST:event_iniciarProcesoVerInventario

    
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
    private javax.swing.JMenuItem irAlInventario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem paseLista;
    private javax.swing.JMenuItem registrarPaciente;
    // End of variables declaration//GEN-END:variables
}
