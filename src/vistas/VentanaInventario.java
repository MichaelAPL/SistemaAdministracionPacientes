/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel Basto Gonzalez
 */
public class VentanaInventario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInventario
     */
    public static VentanaInventario ventanaInventario;
    private DefaultTableModel modeloUtensilios;
    private DefaultTableModel modeloMedicamentos;
    
    private VentanaInventario() {
        initComponents();
        setLocationRelativeTo(null);
        inicializarTablaUtensilios();
        inicializarTablaMedicamentos();
    }
    
    public static VentanaInventario obtenerUnicaVentanaInventario(){
        if(ventanaInventario == null){
            ventanaInventario = new VentanaInventario();
        }else{
            ventanaInventario.setVisible(true);
        }
        return ventanaInventario;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloVent = new javax.swing.JLabel();
        etiquetaUtensilios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable();
        etiquetaMedicamento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUtensilios = new javax.swing.JTable();
        btnAgregarExistencias = new javax.swing.JButton();
        btnModificarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventario ");

        tituloVent.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        tituloVent.setText("Inventario");

        etiquetaUtensilios.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        etiquetaUtensilios.setText("Utensilios");

        tablaMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaMedicamentos);

        etiquetaMedicamento.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        etiquetaMedicamento.setText("Medicamentos");

        tablaUtensilios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaUtensilios);

        btnAgregarExistencias.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnAgregarExistencias.setText("Agregar Insumos");

        btnModificarDatos.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnModificarDatos.setText("Modificar Datos de los Insumos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloVent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaMedicamento)
                            .addComponent(etiquetaUtensilios))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnModificarDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarExistencias)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloVent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(etiquetaUtensilios)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(etiquetaMedicamento)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarExistencias)
                    .addComponent(btnModificarDatos))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void inicializarTablaUtensilios(){
        String[] cabecera = {"Nombre", "Unidades", "Costo Unitario"};;
        Object[][] cuerpo = {};
        
        modeloUtensilios = new DefaultTableModel(cuerpo, cabecera);
        
        tablaUtensilios.setModel(modeloUtensilios);        
    }
    
    public void inicializarTablaMedicamentos(){
        String[] cabecera = {"Nombre", "Unidades", "Mls por unidad", "Mls Totales", "Costo Unitario"};
        Object [][] cuerpo = {};
        
        modeloMedicamentos = new DefaultTableModel(cuerpo, cabecera);
        
        tablaMedicamentos.setModel(modeloMedicamentos);
    }

    public DefaultTableModel getModeloUtensilios() {
        return modeloUtensilios;
    }

    public DefaultTableModel getModeloMedicamentos() {
        return modeloMedicamentos;
    }

    public JButton getBtnAgregarExistencias() {
        return btnAgregarExistencias;
    }

    public JTable getTablaMedicamentos() {
        return tablaMedicamentos;
    }

    public JTable getTablaUtensilios() {
        return tablaUtensilios;
    }

    public JButton getBtnModificarDatos() {
        return btnModificarDatos;
    }
    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarExistencias;
    private javax.swing.JButton btnModificarDatos;
    private javax.swing.JLabel etiquetaMedicamento;
    private javax.swing.JLabel etiquetaUtensilios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaMedicamentos;
    private javax.swing.JTable tablaUtensilios;
    private javax.swing.JLabel tituloVent;
    // End of variables declaration//GEN-END:variables
}
