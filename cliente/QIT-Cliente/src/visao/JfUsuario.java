/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControleGrupo;
import controle.ControleSala;
import controle.ControleUsuario;
import controle.IModelo;
import controle.ITela;
import controle.ProxyTelas;
import dao.UsuarioDAO;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Grupo;
import modelo.Tela;
import modelo.Usuario;

/**
 *
 * @author Tiago
 */
public class JfUsuario extends javax.swing.JFrame implements ITela {

    protected Usuario usuario;
    protected Tela tela;
    protected Usuario usuariocadastrado;
    protected Grupo grupo;
    protected ProxyTelas proxy;
    protected ControleUsuario controleUsuario;

    public JfUsuario(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.setTitle("Usuarios");
        this.tela = new Tela();
        tela.setId(2);
        this.grupo = new Grupo();
        this.usuariocadastrado = new Usuario();
        this.controleUsuario = new ControleUsuario();

        qftfIdGrupo.setEditable(false);
        jftfNomeGrupo.setEditable(false);
        jftfNomeGrupo.setFocusable(false);

        qftfIdGrupo.setDataType("integer");
        qftfIdGrupo.setMaxLenght(100);
        qftfIdGrupo.setNotNull(true);

        qftfNome.setDataType("text");
        qftfNome.setMaxLenght(100);
        qftfNome.setNotNull(true);

        qtfLogin.setDataType("text");
        qtfLogin.setMaxLenght(20);
        qtfLogin.setNotNull(true);

        qtfEmail.setDataType("text");
        qtfEmail.setMaxLenght(20);
        qtfEmail.setNotNull(true);

        proxy = new ProxyTelas(this, this.usuario, this.tela);
//        Verificar permissao da operacao ler
        this.ler();

        controle.Util.definePadroesJFrame(this);

    }

    private JfUsuario() {
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
        qftfNome = new qitjftf.QITJFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        btBuscarPredio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        qftfIdGrupo = new qitjftf.QITJFormattedTextField();
        jftfNomeGrupo = new javax.swing.JFormattedTextField();
        qtfLogin = new qitjftf.QITJFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jPsenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        qtfEmail = new qitjftf.QITJFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jCBAtivo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jCBPermissao = new javax.swing.JComboBox();
        jpConsulta = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        qftfConsultaNome = new qitjftf.QITJFormattedTextField();
        btConsultarTabela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtResultados = new javax.swing.JTable();
        btInativar = new javax.swing.JButton();
        btVerEditar = new javax.swing.JButton();
        btVerEditar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtpMain.setMinimumSize(new java.awt.Dimension(60, 44));
        jtpMain.setPreferredSize(new java.awt.Dimension(700, 550));
        jtpMain.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtpMainFocusGained(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome:*");

        btBuscarPredio.setText("Buscar");
        btBuscarPredio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPredioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Grupo:*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("*Campos obrigatórios");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Login:*");

        jLabelSenha.setText("Senha:*");

        jLabel7.setText("Email:*");

        jLabel8.setText("Situação:");

        jCBAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        jLabel9.setText("Tipo de Permissão:");

        jCBPermissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Grupo", "Individual" }));
        jCBPermissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jCBPermissaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCBPermissaoFocusLost(evt);
            }
        });
        jCBPermissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPermissaoActionPerformed(evt);
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
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qftfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 248, Short.MAX_VALUE)))
                        .addGap(0, 311, Short.MAX_VALUE))
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpCadastroLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(20, 20, 20)
                                    .addComponent(qftfIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jftfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btBuscarPredio))
                                .addGroup(jpCadastroLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCBPermissao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jpCadastroLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(48, 48, 48)
                                    .addComponent(jCBAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpCadastroLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(30, 30, 30)
                                    .addComponent(qtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addComponent(jLabelSenha)
                                .addGap(18, 18, 18)
                                .addComponent(jPsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpCadastroLayout.setVerticalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qftfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(qtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(qftfIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarPredio))
                .addGap(14, 14, 14)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCBPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCBAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(jPsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar1)
                    .addComponent(btSalvar))
                .addContainerGap())
        );

        jtpMain.addTab("Cadastro", jpCadastro);

        jpConsulta.setMinimumSize(new java.awt.Dimension(700, 550));
        jpConsulta.setName(""); // NOI18N

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

        btVerEditar1.setText("Alterar senha");
        btVerEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerEditar1ActionPerformed(evt);
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultaLayout.createSequentialGroup()
                                .addComponent(btVerEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(btVerEditar)
                    .addComponent(btVerEditar1))
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
        if (!jPsenha.isVisible()) {
            jPsenha.setText(usuario.getSenha());
        }

        if (controle.Formatacao.verificarNulos(jpCadastro) && jPsenha.getText().length() > 3) {

            usuariocadastrado.setNome(qftfNome.getText());
            usuariocadastrado.setLogin(qtfLogin.getText());

            usuariocadastrado.setEmail(qtfEmail.getText());
            grupo.setId(Integer.parseInt(qftfIdGrupo.getText()));
            usuariocadastrado.setGrupo(grupo);

            if (jCBPermissao.getSelectedIndex() == 0) {
                usuariocadastrado.setTipoPermissao('G');
            } else {
                usuariocadastrado.setTipoPermissao('I');
            }

            if (jCBAtivo.getSelectedIndex() == 0) // ativo
            {
                usuariocadastrado.setAtivo(true);
            } else {// inativo  
                usuariocadastrado.setAtivo(false);
            }
            usuariocadastrado.setDtCriacao(new Date(System.currentTimeMillis()));

            //  System.out.println("a data de hoje e" + usuariocadastrado.getDtCriacao());
            usuariocadastrado.setUsuario(usuario);
            if (usuariocadastrado.getId() == 0) {
                usuariocadastrado.setSenha(jPsenha.getText());

//                usuariocadastrado.setConfiguracaos(null);
//                usuariocadastrado.setDependencias(null);
//                usuariocadastrado.setExecucaoInstalacaos(null);
//                usuariocadastrado.setExecucaoScripts(null);
//                usuariocadastrado.setGrupos(null);
//                usuariocadastrado.setInstalacaoSoftwares(null);
//                usuariocadastrado.setMaquinas(null);
//                usuariocadastrado.setParticaos(null);
//                usuariocadastrado.setPermissaosForIdUsuario(null);
//                usuariocadastrado.setPermissaosForIdUsuarioModificador(null);
//                usuariocadastrado.setPlacaRedes(null);
//                usuariocadastrado.setPredios(null);
//                usuariocadastrado.setSalas(null);
//                usuariocadastrado.setScripts(null);
//                usuariocadastrado.setSoftwares(null);
//                usuariocadastrado.setTelas(null);
//                usuariocadastrado.setUsuarios(null);
                this.inserir();
            } else {

                this.editar();
            }
        } else {
            if (jPsenha.getText().length() <= 3) {
                JOptionPane.showMessageDialog(null, "Campo senha é deve ter no minimo 4 caracteres");
            }
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

    private void btBuscarPredioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPredioActionPerformed
        try {
            Usuario usuarioPModal = new Usuario();
            ControleGrupo cPPModal = new ControleGrupo();
            new JdlgGenerico(this, cPPModal, usuarioPModal, 1).setVisible(true);
        } catch (Exception e) {
            System.err.println("Erro em btBuscarPredioActionPerformed " + e);
        }
    }//GEN-LAST:event_btBuscarPredioActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        btCancelar1ActionPerformed(evt);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConsultarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarTabelaActionPerformed
        Usuario u = new Usuario();
        u.setNome(qftfConsultaNome.getText());
        controleUsuario.popularTabela(jtResultados, u, false);
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
        if (podeeditar()) {
            try {
                limparCampos();
                if (jtResultados.getSelectedRowCount() != 0) {
                    int idRegistroSelecionado = (int) jtResultados.getValueAt(jtResultados.getSelectedRow(), 0);
                    usuariocadastrado.setId(idRegistroSelecionado);
                    jLabelSenha.setVisible(false);
                    jPsenha.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um registro da tabela");
                }

                usuariocadastrado = controleUsuario.consultarPesquisa(usuariocadastrado);

                popularCampos();
                jtpMain.setSelectedIndex(0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Problemas ao selecionar!\nMensagem técnica:\n" + e);
                System.out.println("" + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui permissão para essa operação");
        }
    }//GEN-LAST:event_btVerEditarActionPerformed

    private void jCBPermissaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCBPermissaoFocusGained

// TODO add your handling code here:
    }//GEN-LAST:event_jCBPermissaoFocusGained

    private void jCBPermissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCBPermissaoFocusLost

    }//GEN-LAST:event_jCBPermissaoFocusLost

    private void jCBPermissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPermissaoActionPerformed

    }//GEN-LAST:event_jCBPermissaoActionPerformed

    private void jtpMainFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtpMainFocusGained
        Usuario u = new Usuario();
        u.setNome(qftfConsultaNome.getText());
        controleUsuario.popularTabela(jtResultados, u, false);        // TODO add your handling code here:
    }//GEN-LAST:event_jtpMainFocusGained

    private void btVerEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerEditar1ActionPerformed
        Usuario userAlterado = new Usuario();
        boolean permissaoUser = proxy.editar();
        if (permissaoUser) {

            if (jtResultados.getSelectedRowCount() != 0) {
                int idRegistroSelecionado = (int) jtResultados.getValueAt(jtResultados.getSelectedRow(), 0);
                userAlterado.setId(idRegistroSelecionado);
                userAlterado = controleUsuario.consultarPesquisa(userAlterado);
                new JfAlterarSenha(userAlterado);

            } else {
                JOptionPane.showMessageDialog(null, "Selecione um registro da tabela");
            }
        }else {
                      JOptionPane.showMessageDialog(null, "Você não possui permissão para essa operação");
        }
    }//GEN-LAST:event_btVerEditar1ActionPerformed

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
            java.util.logging.Logger.getLogger(JfUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarPredio;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btConsultarTabela;
    private javax.swing.JButton btInativar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVerEditar;
    private javax.swing.JButton btVerEditar1;
    private javax.swing.JComboBox jCBAtivo;
    private javax.swing.JComboBox jCBPermissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPasswordField jPsenha;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jftfNomeGrupo;
    private javax.swing.JPanel jpCadastro;
    private javax.swing.JPanel jpConsulta;
    private javax.swing.JTable jtResultados;
    private javax.swing.JTabbedPane jtpMain;
    private qitjftf.QITJFormattedTextField qftfConsultaNome;
    private qitjftf.QITJFormattedTextField qftfIdGrupo;
    private qitjftf.QITJFormattedTextField qftfNome;
    private qitjftf.QITJFormattedTextField qtfEmail;
    private qitjftf.QITJFormattedTextField qtfLogin;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean inserir() {
        boolean permissaoUser = proxy.inserir();

        System.out.println("Permisssao desse cara: " + permissaoUser);
        if (permissaoUser) {
            boolean retorno = controleUsuario.salvar(usuariocadastrado);
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

    public boolean podeeditar() {
        boolean permissaoUser = proxy.editar();

        return permissaoUser;
    }

    @Override
    public boolean editar() {
        boolean permissaoUser = proxy.editar();

        System.out.println("Permisssao desse cara: " + permissaoUser);
        if (permissaoUser) {
            boolean retorno = new UsuarioDAO().salvar(usuariocadastrado);
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
    public boolean inativar() {
        boolean permissaoUser = proxy.inativar();
        System.out.println("Permisssao para ler: " + permissaoUser);

        if (permissaoUser) {
            int id = 0;
            try {
                id = ((int) jtResultados.getValueAt(jtResultados.getSelectedRow(), 0));
                System.out.println("o id que esta indo no inativar e " + id);
                boolean retorno = controleUsuario.inativar(id);
                if (retorno) {
                    JOptionPane.showMessageDialog(rootPane, "Operação Realizada com sucesso");
                    btConsultarTabelaActionPerformed(null);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi posssíel realizar esta operação, consulte o log de erros");
                }
            } catch (Exception e) {
                System.err.println("erro ao alterar status " + e.getLocalizedMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Você não possui permissão para realizar essa operação");
        }
        return true;
    }

    @Override
    public void limparCampos() {
        this.usuariocadastrado = new Usuario();
        this.grupo = new Grupo();
        jLabelSenha.setVisible(true);
        jPsenha.setVisible(true);

        new controle.Formatacao().limparCampos(jpCadastro);
    }

    @Override
    public void popularCampos() {
        try {

            qftfNome.setText(usuariocadastrado.getNome());
            qtfLogin.setText(usuariocadastrado.getLogin());
            qtfEmail.setText(usuariocadastrado.getEmail());
            qftfIdGrupo.setText("" + usuariocadastrado.getGrupo().getId());
            jftfNomeGrupo.setText(usuariocadastrado.getGrupo().getNome());
            if (usuariocadastrado.isAtivo()) {
                jCBAtivo.setSelectedIndex(0);
            } else {
                jCBAtivo.setSelectedIndex(1);
            }
            if (usuariocadastrado.getTipoPermissao() == 'I') {
                jCBPermissao.setSelectedIndex(1);
            } else {
                jCBPermissao.setSelectedIndex(0);
            }

        } catch (Exception e) {
            System.err.println("Erro em popular campos do usuario \n" + e);
        }
    }

    @Override
    public void setRelacionado1(String id, String nome
    ) {
        try {
            qftfIdGrupo.setText(id);
            jftfNomeGrupo.setText(nome);
        } catch (Exception e) {
            System.err.println("Erro em setRelacionado1: " + e);
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

    @Override
    public void setRelacionado4(String id, String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
