/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControleAuditoria;
import controle.ControleUsuario;
import controle.ITela;
import controle.ProxyTelas;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Auditoria;
import modelo.Tela;
import modelo.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tiago
 */
public class JfAuditoria extends javax.swing.JFrame implements ITela {

    protected Usuario usuario;

    protected ProxyTelas proxy;
    protected ControleAuditoria controleAuditoria;
    protected ControleUsuario controleusuario;
    protected Auditoria auditoria;
    protected Tela tela;
    protected Usuario usuarioselecionado;
    protected String tabela, operacao;

    public JfAuditoria(Usuario usuario) {
        initComponents();
        this.setTitle("Auditoria");
        this.usuario = usuario;
        this.tela = new Tela();
        tela.setId(5);
        this.auditoria = new Auditoria();
        this.controleAuditoria = new ControleAuditoria();
        this.usuarioselecionado = new Usuario();

        proxy = new ProxyTelas(this, this.usuario, this.tela);
//        Verificar permissao da operacao ler
        this.ler();

        controle.Util.definePadroesJFrame(this);
    }

    private JfAuditoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpMain = new javax.swing.JTabbedPane();
        jpConsulta = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtResultados = new javax.swing.JTable();
        btInativar = new javax.swing.JButton();
        btVerEditar = new javax.swing.JButton();
        jpCadastro = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JcbOperacao = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JcbTabela = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        qITJIdUsuario = new qitjftf.QITJFormattedTextField();
        jtfNomeUsuario = new javax.swing.JTextField();
        qftfDataFinal = new qitjftf.QITJFormattedTextField();
        qftfDataInicial = new qitjftf.QITJFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtpMain.setMinimumSize(new java.awt.Dimension(60, 44));

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jtResultados.setModel(new javax.swing.table.DefaultTableModel(
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
        jtResultados.getTableHeader().setReorderingAllowed(false);
        jtResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtResultadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtResultados);

        btInativar.setText("Ativar/Inativar selecionado");
        btInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInativarActionPerformed(evt);
            }
        });

        btVerEditar.setText("Ver/Editar selecionado");
        btVerEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpConsultaLayout = new javax.swing.GroupLayout(jpConsulta);
        jpConsulta.setLayout(jpConsultaLayout);
        jpConsultaLayout.setHorizontalGroup(
            jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultaLayout.createSequentialGroup()
                                .addComponent(btVerEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btInativar))))
                    .addGroup(jpConsultaLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpConsultaLayout.setVerticalGroup(
            jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInativar)
                    .addComponent(btVerEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap())
        );

        jtpMain.addTab("Consulta", jpConsulta);

        jpCadastro.setMinimumSize(new java.awt.Dimension(700, 550));
        jpCadastro.setPreferredSize(new java.awt.Dimension(40, 66));

        btSalvar.setText("Consultar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar1.setText("Cancelar");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("*Campos obrigatórios");

        jLabel7.setText("Selecione os parametros para consultar a auditoria:");

        JcbOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Inserir", "Editar", "Excluir" }));

        jLabel9.setText("Operação:");

        jLabel8.setText("Tabela:");

        JcbTabela.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Usuario", "Permissao", "Sala", "Predio" }));
        JcbTabela.setToolTipText("");

        jLabel2.setText("Usuario:");

        qftfDataFinal.setText("01/01/2020");
        qftfDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qftfDataFinalActionPerformed(evt);
            }
        });

        qftfDataInicial.setText("01/01/2000");
        qftfDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qftfDataInicialActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Data inicial:");

        jLabel1.setText("Data Final:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCadastroLayout = new javax.swing.GroupLayout(jpCadastro);
        jpCadastro.setLayout(jpCadastroLayout);
        jpCadastroLayout.setHorizontalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpCadastroLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(JcbTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpCadastroLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addComponent(qftfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel1)
                                                .addGap(20, 20, 20)
                                                .addComponent(qftfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addComponent(qITJIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1))))))
                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JcbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 282, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpCadastroLayout.setVerticalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(qftfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qftfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(qITJIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JcbTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JcbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar1)
                    .addComponent(btSalvar))
                .addContainerGap())
        );

        jtpMain.addTab("Seleção de parametros", jpCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        btCancelar1ActionPerformed(evt);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void jtResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtResultadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtResultadosMouseClicked

    private void btInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInativarActionPerformed
        if (jtResultados.getSelectedRowCount() != 0) { //verifica se tem 1 linha selecionada
            int i = JOptionPane.showConfirmDialog(null, "Deseja alterar o status desde registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (i == 0) { //confirma se o usuario realmente quer inativar
                this.inativar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro da tabela");
        }
    }//GEN-LAST:event_btInativarActionPerformed

    private void btVerEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerEditarActionPerformed
//        try {
//            limparCampos();
//
//            if (jtResultados.getSelectedRowCount() != 0) {
//                int idRegistroSelecionado = (int) jtResultados.getValueAt(jtResultados.getSelectedRow(), 0);
//                sala.setId(idRegistroSelecionado);
//            } else {
//                JOptionPane.showMessageDialog(null, "Selecione um registro da tabela");
//            }
//
//            sala = controleSala.consultar(sala);
//
//            popularCampos();
//            jtpMain.setSelectedIndex(0);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Problemas ao selecionar!\nMensagem técnica:\n" + e);
//            System.out.println("" + e);
//        }
    }//GEN-LAST:event_btVerEditarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Date minDate = new Date();
        Date maxDate = new Date();
        try {
            minDate = new Date(qftfDataInicial.getText());
            maxDate = new Date(qftfDataFinal.getText());
        } catch (Exception e) {
        }

        ControleAuditoria controleAuditoria = new ControleAuditoria();
        List listaUs = controleAuditoria.listaTodos(minDate, maxDate);

        JasperReport pathjrxml;
        try {
            pathjrxml = JasperCompileManager.compileReport("C:\\Users\\Tiago\\Documents\\GitHub\\QIT\\cliente\\QIT-Cliente\\src\\reports\\qit_report_auditoria_ok.jrxml");
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(listaUs));

            JasperViewer.viewReport(printReport, false);

            //  JasperExportManager.exportReportToPdfFile(printReport, "relatorio/reportex.pdf");
            System.out.println("Relatorio gerado");

        } catch (JRException ex) {
            Logger.getLogger(JfMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        //   }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja cancelar esta operação?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            this.dispose();
        } else {
            System.out.println("i" + i);
        }
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Usuario usuarioPModal = new Usuario();
            ControleUsuario cPPModal = new ControleUsuario();
            new JdlgGenerico(this, cPPModal, usuarioPModal, 1).setVisible(true);
        } catch (Exception e) {
            System.err.println("Erro em btBuscarUsuarioActionPerformed " + e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void qftfDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qftfDataInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qftfDataInicialActionPerformed

    private void qftfDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qftfDataFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qftfDataFinalActionPerformed

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
            java.util.logging.Logger.getLogger(JfAuditoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfAuditoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfAuditoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfAuditoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfAuditoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JcbOperacao;
    private javax.swing.JComboBox JcbTabela;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btInativar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVerEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpCadastro;
    private javax.swing.JPanel jpConsulta;
    private javax.swing.JTable jtResultados;
    private javax.swing.JTextField jtfNomeUsuario;
    private javax.swing.JTabbedPane jtpMain;
    private qitjftf.QITJFormattedTextField qITJIdUsuario;
    private qitjftf.QITJFormattedTextField qftfDataFinal;
    private qitjftf.QITJFormattedTextField qftfDataInicial;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean inserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ler() {
        boolean permissaoUser = proxy.ler();

        System.out.println("Permisssao desse cara: " + permissaoUser);
        if (permissaoUser) {
            this.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Você não possui permissão para acessar esta tela");
            this.dispose();
        }
        return true;
    }

    @Override
    public boolean editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inativar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelacionado1(String id, String nome) {
        try {
            System.out.println("relacionado 1");
            qITJIdUsuario.setText(id);
            jtfNomeUsuario.setText(nome);
        } catch (Exception e) {
        }
    }

    @Override
    public void setRelacionado2(String id, String nome
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelacionado3(String id, String nome
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}