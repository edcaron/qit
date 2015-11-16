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
import javax.swing.JOptionPane;
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

        qftfIdTela.setEditable(false);
        jftfNomeTela.setEditable(false);
        jftfNomeTela.setFocusable(false);

        qftfIdTela.setDataType("integer");
        qftfIdTela.setMaxLenght(100);
        qftfIdTela.setNotNull(true);
        JcbVisualisar.setSelected(true);

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

        jtpMain = new javax.swing.JTabbedPane();
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
        qftfIdTela = new qitjftf.QITJFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jftfNomeTela = new javax.swing.JFormattedTextField();
        btBuscarTela = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        JcbInserir = new javax.swing.JCheckBox();
        JcbEditar = new javax.swing.JCheckBox();
        JcbInativar = new javax.swing.JCheckBox();
        JcbVisualisar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jpConsulta = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        qftfConsultaNome = new qitjftf.QITJFormattedTextField();
        btConsultarTabela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtResultados = new javax.swing.JTable();
        btInativar = new javax.swing.JButton();
        btVerEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtpMain.setMinimumSize(new java.awt.Dimension(60, 44));
        jtpMain.setPreferredSize(new java.awt.Dimension(700, 550));

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

        qftfIdTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qftfIdTelaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tela:*");

        btBuscarTela.setText("Buscar");
        btBuscarTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTelaActionPerformed(evt);
            }
        });

        jLabel8.setText("Permissões:");

        JcbInserir.setText("Inserir");

        JcbEditar.setText("Editar");

        JcbInativar.setText("Inativar");

        JcbVisualisar.setText("Visualisar");

        jLabel1.setText("Selecione um usuario ou grupo para definir permissões:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jpCadastroLayout.createSequentialGroup()
                                    .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                            .addComponent(JcbInserir)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(JcbEditar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(JcbInativar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(JcbVisualisar))
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                            .addComponent(qftfIdTela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jftfNomeTela, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btBuscarTela))))
                                .addGroup(jpCadastroLayout.createSequentialGroup()
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
                                            .addComponent(btBuscarGrupo)))))
                            .addComponent(jLabel1))
                        .addGap(0, 314, Short.MAX_VALUE)))
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
                    .addComponent(jftfNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBuscarGrupo)
                    .addComponent(jLabelGrupo)
                    .addComponent(qftfIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBuscarTela)
                    .addComponent(jLabel7)
                    .addComponent(qftfIdTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfNomeTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JcbInserir)
                    .addComponent(JcbEditar)
                    .addComponent(JcbInativar)
                    .addComponent(JcbVisualisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar1)
                    .addComponent(btSalvar))
                .addContainerGap())
        );

        jtpMain.addTab("Cadastro", jpCadastro);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nome:");

        btConsultarTabela.setText("Buscar");
        btConsultarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarTabelaActionPerformed(evt);
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
                    .addGroup(jpConsultaLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qftfConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConsultarTabela)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultaLayout.createSequentialGroup()
                                .addComponent(btVerEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btInativar)))))
                .addContainerGap())
        );
        jpConsultaLayout.setVerticalGroup(
            jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(qftfConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsultarTabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInativar)
                    .addComponent(btVerEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap())
        );

        jtpMain.addTab("Consulta", jpConsulta);

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

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (controle.Formatacao.verificarNulos(jpCadastro)) {
            if (btBuscarGrupo.isEnabled()) {
                grupo.setId(Integer.parseInt(qftfIdGrupo.getText()));
            } else {
                grupo = null;

            }

            if (btBuscarUsuario.isEnabled()) {
                usuarioselecionado.setId(Integer.parseInt(qftfIdUsuario.getText()));
            } else {
                usuarioselecionado = null;

            }

            telaselecionada.setId(Integer.parseInt(qftfIdTela.getText()));
            permissao.setGrupo(grupo);
            permissao.setTela(tela);
            permissao.setUsuarioByIdUsuarioModificador(usuario);
            permissao.setUsuarioByIdUsuario(usuarioselecionado);

            if (JcbEditar.isSelected()) {
                permissao.setEditar(true);
            } else {
                permissao.setEditar(false);
            }
            if (JcbInativar.isSelected()) {
                permissao.setInativar(true);
            } else {
                permissao.setInativar(false);
            }
            if (JcbInserir.isSelected()) {
                permissao.setInserir(true);
            } else {
                permissao.setInserir(false);
            }
            if (JcbVisualisar.isSelected()) {
                permissao.setLer(true);
            } else {
            }

            if (permissao.getId() == 0) {
                this.inserir();
                limparCampos();
            } else {
                this.editar();
                limparCampos();
            }
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

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        btCancelar1ActionPerformed(evt);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConsultarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarTabelaActionPerformed
        Permissao p = new Permissao();
//        p.setNome(qftfConsultaNome.getText());
//        ControlePermissao.popularTabela(jtResultados, s, false);
    }//GEN-LAST:event_btConsultarTabelaActionPerformed

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
        try {
            limparCampos();

            if (jtResultados.getSelectedRowCount() != 0) {
                int idRegistroSelecionado = (int) jtResultados.getValueAt(jtResultados.getSelectedRow(), 0);
                permissao.setId(idRegistroSelecionado);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um registro da tabela");
            }

            permissao = controlePermissao.consultar(permissao);

            popularCampos();
            jtpMain.setSelectedIndex(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao selecionar!\nMensagem técnica:\n" + e);
            System.out.println("" + e);
        }
    }//GEN-LAST:event_btVerEditarActionPerformed

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        qftfIdTela.setText("");
        jftfNomeTela.setText("");

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
        } catch (Exception e) {
            System.err.println("Erro em setRelacionado2: " + e);
        }
    }

    @Override
    public void setRelacionado3(String id, String nome) {
        try {

            qftfIdTela.setText(id);
            jftfNomeTela.setText(nome);
        } catch (Exception e) {
            System.err.println("Erro em setRelacionado3: " + e);
        }
    }//GEN-LAST:event_btBuscarGrupoActionPerformed

    private void qftfIdGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qftfIdGrupoActionPerformed
        // TODO add your handling code here:6
    }//GEN-LAST:event_qftfIdGrupoActionPerformed

    private void qftfIdTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qftfIdTelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qftfIdTelaActionPerformed

    private void btBuscarTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTelaActionPerformed
        try {
            Tela grupoPModal = new Tela();
            ControleTela cPPModal = new ControleTela();
            new JdlgGenerico(this, cPPModal, grupoPModal, 3).setVisible(true);
        } catch (Exception e) {
            System.err.println("Erro em btBuscarTelaActionPerformed " + e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarTelaActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfPermissao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JcbEditar;
    private javax.swing.JCheckBox JcbInativar;
    private javax.swing.JCheckBox JcbInserir;
    private javax.swing.JCheckBox JcbVisualisar;
    private javax.swing.JButton btBuscarGrupo;
    private javax.swing.JButton btBuscarTela;
    private javax.swing.JButton btBuscarUsuario;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btConsultarTabela;
    private javax.swing.JButton btInativar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVerEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelGrupo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jftfNomeGrupo;
    private javax.swing.JFormattedTextField jftfNomeTela;
    private javax.swing.JFormattedTextField jftfNomeUsuario;
    private javax.swing.JPanel jpCadastro;
    private javax.swing.JPanel jpConsulta;
    private javax.swing.JTable jtResultados;
    private javax.swing.JTabbedPane jtpMain;
    private qitjftf.QITJFormattedTextField qftfConsultaNome;
    private qitjftf.QITJFormattedTextField qftfIdGrupo;
    private qitjftf.QITJFormattedTextField qftfIdTela;
    private qitjftf.QITJFormattedTextField qftfIdUsuario;
    // End of variables declaration//GEN-END:variables
}
