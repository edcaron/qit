/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import modelo.Usuario;

/**
 *
 * @author eduar_000
 */
public class JfMain extends javax.swing.JFrame {

    protected Usuario usuario;

    public JfMain() {
        initComponents();
    }

    public JfMain(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        this.setLocation(0, 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmUsuario = new javax.swing.JMenu();
        jimUsuario = new javax.swing.JMenuItem();
        jimGrupoUsuario = new javax.swing.JMenuItem();
        jimPermissao = new javax.swing.JMenuItem();
        jmInventario = new javax.swing.JMenu();
        jimMaquinas = new javax.swing.JMenuItem();
        jimSoftware = new javax.swing.JMenuItem();
        jimPredio = new javax.swing.JMenuItem();
        jimSala = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1355, 120));
        setResizable(false);

        jmUsuario.setText("Usuarios");

        jimUsuario.setText("Usuarios");
        jmUsuario.add(jimUsuario);

        jimGrupoUsuario.setText("Grupos de Usuários");
        jmUsuario.add(jimGrupoUsuario);

        jimPermissao.setText("Permissão");
        jmUsuario.add(jimPermissao);

        jMenuBar1.add(jmUsuario);

        jmInventario.setText("Inventário");

        jimMaquinas.setText("Maquinas");
        jmInventario.add(jimMaquinas);

        jimSoftware.setText("Software");
        jmInventario.add(jimSoftware);

        jimPredio.setText("Prédio");
        jmInventario.add(jimPredio);

        jimSala.setText("Sala");
        jimSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimSalaActionPerformed(evt);
            }
        });
        jmInventario.add(jimSala);

        jMenuBar1.add(jmInventario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jimSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimSalaActionPerformed
        new JfSala(usuario);
    }//GEN-LAST:event_jimSalaActionPerformed

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
            java.util.logging.Logger.getLogger(JfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jimGrupoUsuario;
    private javax.swing.JMenuItem jimMaquinas;
    private javax.swing.JMenuItem jimPermissao;
    private javax.swing.JMenuItem jimPredio;
    private javax.swing.JMenuItem jimSala;
    private javax.swing.JMenuItem jimSoftware;
    private javax.swing.JMenuItem jimUsuario;
    private javax.swing.JMenu jmInventario;
    private javax.swing.JMenu jmUsuario;
    // End of variables declaration//GEN-END:variables
}
