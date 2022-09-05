/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Bryam
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {

        initComponents();
        this.setTitle("MENU PRINCIPAL");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal_menu = new javax.swing.JPanel();
        panel_botones_gestion = new javax.swing.JPanel();
        icono_gestion_ventas = new javax.swing.JLabel();
        icono_gestion_Inventario = new javax.swing.JLabel();
        icono_gestion_Empleados = new javax.swing.JLabel();
        icono_gestion_Usuarios = new javax.swing.JLabel();
        btnGestionVentas = new javax.swing.JButton();
        btnGestionInventario = new javax.swing.JButton();
        btnGestionEmpleados = new javax.swing.JButton();
        btnGestionUsuarios = new javax.swing.JButton();
        btnSalirPrincipal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        icono_gestion_AcercaDe = new javax.swing.JLabel();
        icono_gestion_Ayuda = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        btnChatConsultas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panel_principal_menu.setBackground(new java.awt.Color(255, 255, 255));
        panel_principal_menu.setForeground(new java.awt.Color(204, 204, 204));

        panel_botones_gestion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        icono_gestion_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ventas-icono_grande.png"))); // NOI18N
        icono_gestion_ventas.setToolTipText("GESTION VENTAS");

        icono_gestion_Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/inventario_icono_grande.png"))); // NOI18N

        icono_gestion_Empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/empleado_icono_grande.png"))); // NOI18N

        icono_gestion_Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/usuario_icono_grande.png"))); // NOI18N

        btnGestionVentas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGestionVentas.setForeground(java.awt.Color.blue);
        btnGestionVentas.setText("GESTION VENTAS");
        btnGestionVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnGestionVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGestionVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGestionVentasMouseExited(evt);
            }
        });

        btnGestionInventario.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGestionInventario.setForeground(java.awt.Color.blue);
        btnGestionInventario.setText("GESTION INVENTARIO");
        btnGestionInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnGestionInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGestionInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGestionInventarioMouseExited(evt);
            }
        });

        btnGestionEmpleados.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGestionEmpleados.setForeground(java.awt.Color.blue);
        btnGestionEmpleados.setText("GESTION EMPLEADOS");
        btnGestionEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnGestionEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGestionEmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGestionEmpleadosMouseExited(evt);
            }
        });

        btnGestionUsuarios.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGestionUsuarios.setForeground(java.awt.Color.blue);
        btnGestionUsuarios.setText("GESTION USUARIOS");
        btnGestionUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnGestionUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGestionUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGestionUsuariosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_botones_gestionLayout = new javax.swing.GroupLayout(panel_botones_gestion);
        panel_botones_gestion.setLayout(panel_botones_gestionLayout);
        panel_botones_gestionLayout.setHorizontalGroup(
            panel_botones_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botones_gestionLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(panel_botones_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icono_gestion_ventas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(panel_botones_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icono_gestion_Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(panel_botones_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icono_gestion_Empleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel_botones_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icono_gestion_Usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panel_botones_gestionLayout.setVerticalGroup(
            panel_botones_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botones_gestionLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(panel_botones_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icono_gestion_Usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icono_gestion_Empleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icono_gestion_Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icono_gestion_ventas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_botones_gestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGestionVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        btnSalirPrincipal.setBackground(new java.awt.Color(255, 51, 51));
        btnSalirPrincipal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSalirPrincipal.setText("CANCELAR");
        btnSalirPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.blue);
        jLabel8.setText("Acerca de...");

        icono_gestion_AcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/bocadillo-de-dialogo-de-informacion-tamanio_grande.png"))); // NOI18N
        icono_gestion_AcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icono_gestion_AcercaDeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icono_gestion_AcercaDeMouseExited(evt);
            }
        });

        icono_gestion_Ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/information_icono_grande.png"))); // NOI18N
        icono_gestion_Ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icono_gestion_AyudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icono_gestion_AyudaMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.blue);
        jLabel11.setText("Ayuda");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Nombre del usuario:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Tipo Usuario:");

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTipoUsuario.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTipoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnChatConsultas.setBackground(new java.awt.Color(102, 255, 102));
        btnChatConsultas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnChatConsultas.setForeground(new java.awt.Color(0, 0, 255));
        btnChatConsultas.setText("CHAT CONSULTAS");
        btnChatConsultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102), 3));

        javax.swing.GroupLayout panel_principal_menuLayout = new javax.swing.GroupLayout(panel_principal_menu);
        panel_principal_menu.setLayout(panel_principal_menuLayout);
        panel_principal_menuLayout.setHorizontalGroup(
            panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principal_menuLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principal_menuLayout.createSequentialGroup()
                        .addComponent(panel_botones_gestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_principal_menuLayout.createSequentialGroup()
                        .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_principal_menuLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel11))
                            .addGroup(panel_principal_menuLayout.createSequentialGroup()
                                .addComponent(icono_gestion_AcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(icono_gestion_Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(456, 456, 456)
                        .addComponent(btnChatConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnSalirPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_principal_menuLayout.setVerticalGroup(
            panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principal_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principal_menuLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(panel_botones_gestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_principal_menuLayout.createSequentialGroup()
                        .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principal_menuLayout.createSequentialGroup()
                        .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(icono_gestion_Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icono_gestion_AcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principal_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSalirPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChatConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void icono_gestion_AcercaDeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono_gestion_AcercaDeMouseEntered
        this.icono_gestion_AcercaDe.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
    }//GEN-LAST:event_icono_gestion_AcercaDeMouseEntered

    private void icono_gestion_AcercaDeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono_gestion_AcercaDeMouseExited
        this.icono_gestion_AcercaDe.setBorder(null);
    }//GEN-LAST:event_icono_gestion_AcercaDeMouseExited

    private void icono_gestion_AyudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono_gestion_AyudaMouseEntered
        this.icono_gestion_Ayuda.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
    }//GEN-LAST:event_icono_gestion_AyudaMouseEntered

    private void icono_gestion_AyudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono_gestion_AyudaMouseExited
        this.icono_gestion_Ayuda.setBorder(null);
    }//GEN-LAST:event_icono_gestion_AyudaMouseExited

    private void btnGestionVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionVentasMouseEntered
        this.btnGestionVentas.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
    }//GEN-LAST:event_btnGestionVentasMouseEntered

    private void btnGestionVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionVentasMouseExited

        this.btnGestionVentas.setBorder(null);
    }//GEN-LAST:event_btnGestionVentasMouseExited

    private void btnGestionInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionInventarioMouseEntered
        this.btnGestionInventario.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
    }//GEN-LAST:event_btnGestionInventarioMouseEntered

    private void btnGestionInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionInventarioMouseExited
        this.btnGestionInventario.setBorder(null);
    }//GEN-LAST:event_btnGestionInventarioMouseExited

    private void btnGestionEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionEmpleadosMouseEntered
        this.btnGestionEmpleados.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
    }//GEN-LAST:event_btnGestionEmpleadosMouseEntered

    private void btnGestionEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionEmpleadosMouseExited
        this.btnGestionEmpleados.setBorder(null);
    }//GEN-LAST:event_btnGestionEmpleadosMouseExited

    private void btnGestionUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionUsuariosMouseEntered
        this.btnGestionUsuarios.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
    }//GEN-LAST:event_btnGestionUsuariosMouseEntered

    private void btnGestionUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionUsuariosMouseExited
        this.btnGestionUsuarios.setBorder(null);
    }//GEN-LAST:event_btnGestionUsuariosMouseExited

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnChatConsultas;
    public javax.swing.JButton btnGestionEmpleados;
    public javax.swing.JButton btnGestionInventario;
    public javax.swing.JButton btnGestionUsuarios;
    public javax.swing.JButton btnGestionVentas;
    public javax.swing.JButton btnSalirPrincipal;
    private javax.swing.JLabel icono_gestion_AcercaDe;
    private javax.swing.JLabel icono_gestion_Ayuda;
    public javax.swing.JLabel icono_gestion_Empleados;
    public javax.swing.JLabel icono_gestion_Inventario;
    public javax.swing.JLabel icono_gestion_Usuarios;
    private javax.swing.JLabel icono_gestion_ventas;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel lblNombreUsuario;
    public javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPanel panel_botones_gestion;
    private javax.swing.JPanel panel_principal_menu;
    // End of variables declaration//GEN-END:variables
}
