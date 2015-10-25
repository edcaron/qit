/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Grupo;
import modelo.Permissao;
import modelo.Tela;
import modelo.Usuario;

/**
 *
 * @author eduar_000
 */
public class ControleUsuario implements IControle {

    UsuarioDAO udao;

    public boolean salvar(Usuario usuario) {
        return udao.salvar(usuario);
    }

    public boolean inativar(int id) {
       
        Usuario objLocal = new Usuario();
        boolean retorno = false;
   
        objLocal.setId(id);

//        consulta o obj sala no banco de dados com o id que vem como paramentro na funcao
        objLocal = this.consultar(objLocal);

//        inverte o valor do status no obj que veio do banco
        objLocal.setAtivo(controle.Util.inverteValorBinario(objLocal.isAtivo()));

//        salva novamente no banco
        retorno = this.salvar(objLocal);
        return retorno;
    }

    public ControleUsuario() {
        udao = new UsuarioDAO();
    }

    public boolean logar(Usuario usuario) {
        boolean ret = false;
        UsuarioDAO ud = new UsuarioDAO();

        ret = ud.autenticar(usuario);

        return ret;
    }

    public Usuario consultar(Usuario usuario) { // somente para sessao
        Usuario usuarioLocal = new Usuario();
        try {
            usuarioLocal = udao.consultar(usuario);
        } catch (Exception e) {
            System.err.println("" + e);

        }
        return usuarioLocal;
    }

    public Usuario consultarPesquisa(Usuario usuario) {
        Usuario usuarioLocal = new Usuario();
        try {
            usuarioLocal = udao.consultarPesquisa(usuario);
        } catch (Exception e) {
            System.err.println("" + e);

        } finally {
        }
        return usuarioLocal;
    }

    public boolean verificarPermissao(Usuario usuario, Tela tela, String operacao) {
        boolean temPermissao = false;
        Set lista = null;
        System.out.println("o tipo de permissao é " + usuario.getTipoPermissao());
        if (usuario.getTipoPermissao() == 'I') {
            lista = usuario.getPermissaosForIdUsuario();
        } else {
            lista = usuario.getGrupo().getPermissaos();
        }

        Iterator<Permissao> it = lista.iterator();

        while (it.hasNext()) {
            Permissao permissao = (Permissao) it.next();

            if (permissao.getTela().getId() == tela.getId()) {
                switch (operacao) {
                    case "ler":
                        if (permissao.isLer()) {
                            temPermissao = true;
                        }
                        break;
                    case "editar":
                        if (permissao.isEditar()) {
                            temPermissao = true;
                        }
                        break;
                    case "inserir":
                        if (permissao.isInserir()) {
                            temPermissao = true;
                        }
                        break;
                    case "inativar":
                        if (permissao.isInativar()) {
                            temPermissao = true;
                        }
                        break;
                }
            }
        }

        return temPermissao;
    }

    @Override
    public Object[][] popularTabela(JTable tabela, IModelo modelo, boolean isModal) {
        Object[][] dadosTabela = null;
        try {
            int colunasTabela = 3;

            if (!isModal) {
                colunasTabela = 5;
            } else {
                colunasTabela = 3; //se modal for verdadeiro, a tabela vai ter 3 colunas para ser usado no JDialog para consulta
            }

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Cód";
            cabecalho[1] = "Nome";
            cabecalho[2] = "Login";
            if (!isModal) { //se modal for verdadeiro, a tabela vai ter 3 colunas para ser usado no JDialog para consulta
                cabecalho[3] = "Email";
                cabecalho[4] = "Status";
            }

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<Usuario> listaSalas = udao.listar(modelo);
        

            dadosTabela = new Object[listaSalas.size()][colunasTabela];
        
            for (int i = 0; i < listaSalas.size(); i++) {
                dadosTabela[i][0] = listaSalas.get(i).getId();
                dadosTabela[i][1] = listaSalas.get(i).getNome();
                dadosTabela[i][2] = listaSalas.get(i).getLogin();
                if (!isModal) { //se modal for verdadeiro, a tabela vai ter 3 colunas para ser usado no JDialog para consulta
                    dadosTabela[i][3] = listaSalas.get(i).getEmail();
                    dadosTabela[i][4] = controle.Util.binarioParaString(listaSalas.get(i).isAtivo());
                }
            }
            // configuracoes adicionais no componente tabela
            tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

                @Override
                public Class getColumnClass(int column) {
                    return Object.class;
                }
            });

            // permite seleção de apenas uma linha da tabela
            tabela.setSelectionMode(0);

//Desabilitar arrastar e soltar
            tabela.getTableHeader().setReorderingAllowed(false);

            //alinha valores da coluna de valores para a direita 
            DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

            esquerda.setHorizontalAlignment(SwingConstants.LEFT);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            direita.setHorizontalAlignment(SwingConstants.RIGHT);

            tabela.getColumnModel().getColumn(0).setCellRenderer(direita);
            tabela.getColumnModel().getColumn(1).setCellRenderer(direita);
            tabela.getColumnModel().getColumn(2).setCellRenderer(direita);
            tabela.getTableHeader().setResizingAllowed(true);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
//        for (int i = 0; i < tabela.getColumnCount(); i++) {
//            column = tabela.getColumnModel().getColumn(i);
//            switch (i) {
//                case 0:
//                    column.setPreferredWidth(30);
//                    break;
//                case 1:
//                    column.setPreferredWidth(110);
//                    break;
//                case 2:
//                    column.setPreferredWidth(40);
//                    break;
//                case 3:
//                    column.setPreferredWidth(40);
//                    break;
//                case 8:
//                    column.setPreferredWidth(40);
//                    break;
//                case 7:
//                    column.setPreferredWidth(50);
//                    break;
//                case 9:
//                    column.setPreferredWidth(40);
//                    break;
//            }
//        }

        } catch (Exception e) {
            System.err.println("Erro ao popular tabela usuario: " + e + "\n" + e.getCause());
        }
        return dadosTabela;
    }

}
