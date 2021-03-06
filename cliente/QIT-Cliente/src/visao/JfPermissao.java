/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControleGrupo;
import controle.ControleTela;
import controle.ControleUsuario;
import controle.ITela;
import controle.ProxyTelas;
import controle.ControlePermissao;
import controle.Util;
import dao.PermissaoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelo.Grupo;
import modelo.Permissao;
import modelo.Predio;
import modelo.Tela;
import modelo.Usuario;

/**
 *
 * @author Tiago
 */
public class JfPermissao extends javax.swing.JFrame implements ITela {

    protected Usuario usuario;

    protected ProxyTelas proxy;
    protected ControleGrupo controleGrupo;
    protected ControleUsuario controleusuario;
    protected ControlePermissao controlePermissao;
    protected Permissao permissao;
    protected Usuario usuarioselecionado;
    protected Grupo grupo;
    protected Tela tela;
    protected Tela telaselecionada;

    public JfPermissao(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.setTitle("Permissões");
        this.tela = new Tela();
        this.telaselecionada = new Tela();
        this.permissao = new Permissao();
        this.grupo = new Grupo();
        this.usuarioselecionado = new Usuario();
        this.controleGrupo = new ControleGrupo();
        this.controlePermissao = new ControlePermissao();
        tela.setId(4);

        qftfIdGrupo.setEditable(false);
        jftfNomeGrupo.setEditable(false);
        jftfNomeGrupo.setFocusable(false);

        qftfIdGrupo.setDataType("integer");
        qftfIdGrupo.setMaxLenght(100);
        qftfIdGrupo.setNotNull(true);

        qftfIdUsuario.setEditable(false);
        jftfNomeUsuario.setEditable(false);
        jftfNomeUsuario.setFocusable(false);

        qftfIdUsuario.setDataType("integer");
        qftfIdUsuario.setMaxLenght(100);
        qftfIdUsuario.setNotNull(true);
//
//        qftfIdTela.setEditable(false);
//        jftfNomeTela.setEditable(false);
//        jftfNomeTela.setFocusable(false);
//
//        qftfIdTela.setDataType("integer");
//        qftfIdTela.setMaxLenght(100);
//        qftfIdTela.setNotNull(true);
//        JcbVisualisar.setSelected(true);

        proxy = new ProxyTelas(this, this.usuario, this.tela);
//        Verificar permissao da operacao ler
        this.ler();

        controle.Util.definePadroesJFrame(this);
    }

    private JfPermissao() {
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

        jpCadastro = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();
        btBuscarUsuario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        qftfIdUsuario = new qitjftf.QITJFormattedTextField();
        jftfNomeUsuario = new javax.swing.JFormattedTextField();
        jLabelGrupo = new javax.swing.JLabel();
        qftfIdGrupo = new qitjftf.QITJFormattedTextField();
        jftfNomeGrupo = new javax.swing.JFormattedTextField();
        btBuscarGrupo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btBuscarUsuario1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btBuscarGrupo1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpCadastro.setMinimumSize(new java.awt.Dimension(700, 550));
        jpCadastro.setPreferredSize(new java.awt.Dimension(60, 44));

        btSalvar.setText("Salvar");
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

        btBuscarUsuario.setText("Buscar");
        btBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Usuario:*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("*Campos obrigatórios");

        jLabelGrupo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGrupo.setText("Grupo:*");

        qftfIdGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qftfIdGrupoActionPerformed(evt);
            }
        });

        btBuscarGrupo.setText("Buscar");
        btBuscarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarGrupoActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione um usuario ou grupo para definir permissões:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        jButton1.setText("Limpar campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btBuscarUsuario1.setText("Buscar");
        btBuscarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarUsuario1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecione um usuario para importar permissões:");

        btBuscarGrupo1.setText("Buscar");
        btBuscarGrupo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarGrupo1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Selecione um grupo para importar permissões:");

        javax.swing.GroupLayout jpCadastroLayout = new javax.swing.GroupLayout(jpCadastro);
        jpCadastro.setLayout(jpCadastroLayout);
        jpCadastroLayout.setHorizontalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCadastroLayout.createSequentialGroup()
                                    .addGap(482, 482, 482)
                                    .addComponent(jLabel4)))
                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabelGrupo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpCadastroLayout.createSequentialGroup()
                                        .addComponent(qftfIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jftfNomeUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscarUsuario))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLayout.createSequentialGroup()
                                        .addComponent(qftfIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jftfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscarGrupo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btBuscarGrupo1)
                                    .addComponent(btBuscarUsuario1)))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpCadastroLayout.setVerticalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBuscarUsuario)
                    .addComponent(jLabel3)
                    .addComponent(qftfIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarGrupo1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btBuscarGrupo)
                        .addComponent(jLabelGrupo)
                        .addComponent(qftfIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jftfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btBuscarUsuario1)
                        .addComponent(jLabel7)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar1)
                    .addComponent(btSalvar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        boolean temgrupo = false;
        boolean temusuario = false;
        boolean editou = false;
        if (controle.Formatacao.verificarNulos(jpCadastro)) {
            if (btBuscarGrupo.isEnabled()) {
                grupo.setId(Integer.parseInt(qftfIdGrupo.getText()));
                temgrupo = true;
            } else {

            }
            if (btBuscarUsuario.isEnabled()) {
                usuarioselecionado.setId(Integer.parseInt(qftfIdUsuario.getText()));
                temusuario = true;

            } else {
                usuarioselecionado = new Usuario();
                usuarioselecionado.setId(0);

            }

            int numerodelinhas = jTable1.getRowCount();
            for (int i = 0; i < numerodelinhas; i++) {

                permissao = new Permissao();
                telaselecionada.setId(Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 0))));
                if (temgrupo) {
                    permissao.setGrupo(grupo);
                }
                permissao.setTela(telaselecionada);
                permissao.setUsuarioByIdUsuarioModificador(usuario);
                if (temusuario) {
                    permissao.setUsuarioByIdUsuario(usuarioselecionado);
                }

                permissao.setId(Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 6))));
                String inserir = (String.valueOf(jTable1.getValueAt(i, 3)));
                String editar = (String.valueOf(jTable1.getValueAt(i, 4)));
                String inativar = (String.valueOf(jTable1.getValueAt(i, 5)));
                String ler = (String.valueOf(jTable1.getValueAt(i, 2)));
                permissao.setInserir(Util.stringParaBinario(inserir));
                permissao.setEditar(Util.stringParaBinario(editar));
                permissao.setInativar(Util.stringParaBinario(inativar));
                permissao.setLer(Util.stringParaBinario(ler));

                editou = this.editar();
            }
            if (editou) {
                JOptionPane.showMessageDialog(rootPane, "Operação Realizada com sucesso");
            }
            limparCampos();

        } else {

        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Deseja cancelar esta operação?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            this.dispose();
        } else {
            System.out.println("i" + i);
        }
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void btBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarUsuarioActionPerformed
        try {
            Usuario usuarioPModal = new Usuario();
            ControleUsuario cPPModal = new ControleUsuario();
            new JdlgGenerico(this, cPPModal, usuarioPModal, 2).setVisible(true);
        } catch (Exception e) {
            System.err.println("Erro em btBuscarUsuarioActionPerformed " + e);
        }
    }//GEN-LAST:event_btBuscarUsuarioActionPerformed

    private void btBuscarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarGrupoActionPerformed
        try {
            Grupo grupoPModal = new Grupo();
            ControleGrupo cPPModal = new ControleGrupo();
            new JdlgGenerico(this, cPPModal, grupoPModal, 1).setVisible(true);
        } catch (Exception e) {
            System.err.println("Erro em btBuscarPredioActionPerformed " + e);
        }
    }           // TODO add your handling code here:

    @Override
    public boolean inserir() {
        boolean permissaoUser = proxy.inserir();

        System.out.println("Permisssao desse cara: " + permissaoUser);
        boolean retorno = false;
        if (permissaoUser) {
            try {
                retorno = controlePermissao.salvar(permissao);
            } catch (Exception e) {
                retorno = false;
            }

            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Operação Realizada com sucesso");
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi posssíel realizar esta operação, consulte o log de erros");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Você não possui permissão para realizar essa operação");
        }
        return true;
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
        boolean permissaoUser = proxy.editar();

        System.out.println("Permisssao desse cara: " + permissaoUser);
        if (permissaoUser) {
            boolean retorno = new PermissaoDAO().salvar(permissao);
            if (retorno) {
                //JOptionPane.showMessageDialog(rootPane, "Operação Realizada com sucesso");
                // this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi posssíel realizar esta operação, consulte o log de erros");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Você não possui permissão para realizar essa operação");
        }
        return true;
    }

    @Override
    public boolean inativar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limparCampos() {
        btBuscarGrupo.setEnabled(true);
        btBuscarUsuario.setEnabled(true);
        this.telaselecionada = new Tela();
        this.permissao = new Permissao();
        this.grupo = new Grupo();
        this.usuarioselecionado = new Usuario();
        this.controleGrupo = new ControleGrupo();
        this.controlePermissao = new ControlePermissao();

        qftfIdUsuario.setText("");
        jftfNomeUsuario.setText("");

        qftfIdGrupo.setText("");
        jftfNomeGrupo.setText("");

//        qftfIdTela.setText("");
//        jftfNomeTela.setText("");
    }

    @Override
    public void popularCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelacionado1(String id, String nome) {
        try {
            btBuscarUsuario.setEnabled(false);
            qftfIdUsuario.setText("0");

            qftfIdGrupo.setText(id);
            jftfNomeGrupo.setText(nome);
            int idg = Integer.parseInt(id);
            Grupo g = new Grupo();
            g.setId(idg);
            controlePermissao.popularTabela(jTable1, g, false);

        } catch (Exception e) {
            System.err.println("Erro em setRelacionado1: " + e);
        }
    }

    @Override
    public void setRelacionado2(String id, String nome) {
        try {
            btBuscarGrupo.setEnabled(false);
            qftfIdGrupo.setText("0");

            qftfIdUsuario.setText(id);
            jftfNomeUsuario.setText(nome);
            int idusuario = Integer.parseInt(id);
            Usuario u = new Usuario();
            u.setId(idusuario);
            controlePermissao.popularTabela(jTable1, u, false);

        } catch (Exception e) {
            System.err.println("Erro em setRelacionado2: " + e);
        }
    }

    @Override
    public void setRelacionado3(String id, String nome) {
        try {
            int idusuario = Integer.parseInt(id);
            Usuario u = new Usuario();
            u.setId(idusuario);
            controlePermissao.popularTabela(jTable1, u, true);
        } catch (Exception e) {
            System.err.println("Erro em setRelacionado3: " + e);
        }
    }//GEN-LAST:event_btBuscarGrupoActionPerformed

    private void qftfIdGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qftfIdGrupoActionPerformed
        // TODO add your handling code here:6
    }//GEN-LAST:event_qftfIdGrupoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limparCampos();
        btBuscarGrupo.setEnabled(true);
        btBuscarUsuario.setEnabled(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btBuscarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarUsuario1ActionPerformed
        try {
            Grupo usuarioPModal = new Grupo();
            ControleGrupo cPPModal = new ControleGrupo();
            new JdlgGenerico(this, cPPModal, usuarioPModal, 4).setVisible(true);
        } catch (Exception e) {
            System.err.println("Erro em btBuscarUsuarioActionPerformed " + e);
        }        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarUsuario1ActionPerformed

    private void btBuscarGrupo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarGrupo1ActionPerformed
        try {
            Usuario usuarioPModal = new Usuario();
            ControleUsuario cPPModal = new ControleUsuario();
            new JdlgGenerico(this, cPPModal, usuarioPModal, 3).setVisible(true);
        } catch (Exception e) {
            System.err.println("Erro em btBuscarUsuarioActionPerformed " + e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarGrupo1ActionPerformed

    @Override
    public void setRelacionado4(String id, String nome) {
        try {
            int idg = Integer.parseInt(id);
            Grupo g = new Grupo();
            g.setId(idg);
            controlePermissao.popularTabela(jTable1, g, true);
        } catch (Exception e) {
            System.err.println("Erro em setRelacionado3: " + e);
        }
    }

    public class BooleanTableModel extends AbstractTableModel {

        String[] columns = {"STUDENT ID", "NAME", "SCORE", "PASSED"};
        Object[][] data = {
            {"S001", "ALICE", 90.00, Boolean.TRUE},
            {"S002", "BOB", 45.50, Boolean.FALSE},
            {"S003", "CAROL", 60.00, Boolean.FALSE},
            {"S004", "MALLORY", 75.80, Boolean.TRUE}
        };

        public int getRowCount() {
            return data.length;
        }

        public int getColumnCount() {
            return columns.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }

        //
        // This method is used by the JTable to define the default
        // renderer or editor for each cell. For example if you have
        // a boolean data it will be rendered as a check box. A
        // number value is right aligned.
        //
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return data[0][columnIndex].getClass();
        }
    }

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
            java.util.logging.Logger.getLogger(JfPermissao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfPermissao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfPermissao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfPermissao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfPermissao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarGrupo;
    private javax.swing.JButton btBuscarGrupo1;
    private javax.swing.JButton btBuscarUsuario;
    private javax.swing.JButton btBuscarUsuario1;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelGrupo;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField jftfNomeGrupo;
    private javax.swing.JFormattedTextField jftfNomeUsuario;
    private javax.swing.JPanel jpCadastro;
    private qitjftf.QITJFormattedTextField qftfIdGrupo;
    private qitjftf.QITJFormattedTextField qftfIdUsuario;
    // End of variables declaration//GEN-END:variables
}
