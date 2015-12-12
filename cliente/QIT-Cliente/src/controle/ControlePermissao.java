/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.PermissaoDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Permissao;
import modelo.Sala;
import modelo.Usuario;

/**
 *
 * @author Tiago
 */
public class ControlePermissao implements IModelo {

    private PermissaoDAO dao;

    public ControlePermissao() {
        this.dao = new PermissaoDAO();
    }

    public Permissao consultar(Permissao permissao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean salvar(Permissao permissao) {
        return dao.salvar(permissao);
    }

    public boolean popularTabela(JTable tabela, Usuario usuario) {
        Object[][] dadosTabela = null;

        try {
            int colunasTabela = 5;

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Tela";
            cabecalho[1] = "Visualisar";
            cabecalho[2] = "Inserir";
            cabecalho[3] = "Editar";
            cabecalho[4] = "Inativar";

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<Permissao> listaPermisao = dao.listar(usuario);

            dadosTabela = new Object[listaPermisao.size()][colunasTabela];

            for (int i = 0; i < listaPermisao.size(); i++) {
                dadosTabela[i][0] = listaPermisao.get(i).getTela().getNome();
                if (listaPermisao.get(i).isLer()) {
                    dadosTabela[i][1] = true;
                } else {
                    dadosTabela[i][1] = false;
                }
                if (listaPermisao.get(i).isInserir()) {
                    dadosTabela[i][2] = true;
                } else {
                    dadosTabela[i][2] = false;
                }
                if (listaPermisao.get(i).isEditar()) {
                    dadosTabela[i][3] = true;
                } else {
                    dadosTabela[i][3] = false;
                }
                if (listaPermisao.get(i).isInativar()) {
                    dadosTabela[i][4] = true;
                } else {
                    dadosTabela[i][5] = false;
                }

            }

            // configuracoes adicionais no componente tabela
            tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {

                    if (column == 2) {
                        return true;
                    } else {
                        return false;
                    }
                }

                @Override
                public Class getColumnClass(int column) {
                    if ( column ==1  || column == 2 || column == 3 || column == 4 || column == 5) {
                        return Boolean.class;
                    } else {
                        return Object.class;
                    }
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
            System.err.println("Erro ao popular tabela: " + e + "\n" + e.getCause());
        }
        return true;
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
