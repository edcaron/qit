/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.PermissaoDAO;
import dao.TelaDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Grupo;
import modelo.Permissao;
import modelo.Sala;
import modelo.Tela;
import modelo.Usuario;

/**
 *
 * @author Tiago
 */
public class ControlePermissao implements IModelo {

    private PermissaoDAO dao;
    private TelaDAO tdao;

    public ControlePermissao() {
        this.dao = new PermissaoDAO();
        this.tdao = new TelaDAO();
    }

    public Permissao consultar(Permissao permissao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean salvar(Permissao permissao) {
        return dao.salvar(permissao);
    }

    // faz a junção de todas as telas e permissoes para a exibição no cadastro de permissões, retorna um arraylist com os dados
    public ArrayList<Permissao> joinTelasPermissoes(Usuario usuario) {

        ArrayList<Tela> listaTelas = tdao.listar(null);
        ArrayList<Permissao> listaPermisao = dao.listar(usuario);
        ArrayList<Permissao> listaPermisaoretorno = new ArrayList(); // Arraylist de permissoes com as telas de permissoes, e caso nao tenha alguma tela, adiciona
        //adiciona todas TELAS para o retorno como permissao sem valores setados, para inserir id =0 update != 0
        for (int i = 0; i < listaTelas.size(); i++) {
            Permissao p = new Permissao();
            p.setTela(listaTelas.get(i));
            listaPermisaoretorno.add(p);
        }

        for (int i = 0; i < listaPermisaoretorno.size(); i++) { // percore as telas que estao no retorno
            for (int j = 0; j < listaPermisao.size(); j++) {
                if (listaPermisaoretorno.get(i).getTela().getId() == listaPermisao.get(j).getTela().getId()) { // se tenho uma tela que ja esta na lista
                    listaPermisaoretorno.set(i, listaPermisao.get(j));
                }

            }

        }

        return listaPermisaoretorno;
    }

    public ArrayList<Permissao> joinTelasPermissoes(Grupo grupo) {

        ArrayList<Tela> listaTelas = tdao.listar(null);
        ArrayList<Permissao> listaPermisao = dao.listar(grupo);
        ArrayList<Permissao> listaPermisaoretorno = new ArrayList(); // Arraylist de permissoes com as telas de permissoes, e caso nao tenha alguma tela, adiciona
        //adiciona todas TELAS para o retorno como permissao sem valores setados, para inserir id =0 update != 0
        for (int i = 0; i < listaTelas.size(); i++) {
            Permissao p = new Permissao();
            p.setTela(listaTelas.get(i));
            listaPermisaoretorno.add(p);
        }

        for (int i = 0; i < listaPermisaoretorno.size(); i++) { // percore as telas que estao no retorno
            for (int j = 0; j < listaPermisao.size(); j++) {
                if (listaPermisaoretorno.get(i).getTela().getId() == listaPermisao.get(j).getTela().getId()) { // se tenho uma tela que ja esta na lista
                    listaPermisaoretorno.set(i, listaPermisao.get(j));
                }

            }

        }

        return listaPermisaoretorno;
    }

    public boolean popularTabela(JTable tabela, Usuario usuario) {
        Object[][] dadosTabela = null;

        try {
            int colunasTabela = 7;

            Object[] cabecalho = new Object[colunasTabela];
            cabecalho[0] = "Id Tela";
            cabecalho[1] = "Tela";
            cabecalho[2] = "Visualisar";
            cabecalho[3] = "Inserir";
            cabecalho[4] = "Editar";
            cabecalho[5] = "Inativar";
            cabecalho[6] = "Cod";

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<Permissao> listaPermisao = joinTelasPermissoes(usuario);
            dadosTabela = new Object[listaPermisao.size()][colunasTabela];

            for (int i = 0; i < listaPermisao.size(); i++) {
                dadosTabela[i][0] = listaPermisao.get(i).getTela().getId();
                dadosTabela[i][1] = listaPermisao.get(i).getTela().getNome();
                if (listaPermisao.get(i).isLer()) {
                    dadosTabela[i][2] = true;
                } else {
                    dadosTabela[i][2] = false;
                }
                if (listaPermisao.get(i).isInserir()) {
                    dadosTabela[i][3] = true;
                } else {
                    dadosTabela[i][3] = false;
                }
                if (listaPermisao.get(i).isEditar()) {
                    dadosTabela[i][4] = true;
                } else {
                    dadosTabela[i][4] = false;
                }
                if (listaPermisao.get(i).isInativar()) {
                    dadosTabela[i][5] = true;
                } else {
                    dadosTabela[i][5] = false;
                }
                dadosTabela[i][6] = listaPermisao.get(i).getId();
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
                    if (column == 2 || column == 3 || column == 4 || column == 5) {
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
            for (int i = 0; i < tabela.getColumnCount(); i++) {
                column = tabela.getColumnModel().getColumn(i);
                switch (i) {
                    case 0:
                        column.setPreferredWidth(30);
                        break;
                    case 1:
                        column.setPreferredWidth(110);
                        break;

                }
            }

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

    public boolean popularTabela(JTable tabela, Grupo g) {
        Object[][] dadosTabela = null;

        try {
            int colunasTabela = 7;

            Object[] cabecalho = new Object[colunasTabela];
            cabecalho[0] = "Id Tela";
            cabecalho[1] = "Tela";
            cabecalho[2] = "Visualisar";
            cabecalho[3] = "Inserir";
            cabecalho[4] = "Editar";
            cabecalho[5] = "Inativar";
            cabecalho[6] = "Cod";
            // cria matriz de acordo com nº de registros da tabela
            ArrayList<Permissao> listaPermisao = joinTelasPermissoes(g);

            dadosTabela = new Object[listaPermisao.size()][colunasTabela];

            for (int i = 0; i < listaPermisao.size(); i++) {
                dadosTabela[i][0] = listaPermisao.get(i).getTela().getId();
                dadosTabela[i][1] = listaPermisao.get(i).getTela().getNome();
                if (listaPermisao.get(i).isLer()) {
                    dadosTabela[i][2] = true;
                } else {
                    dadosTabela[i][2] = false;
                }
                if (listaPermisao.get(i).isInserir()) {
                    dadosTabela[i][3] = true;
                } else {
                    dadosTabela[i][3] = false;
                }
                if (listaPermisao.get(i).isEditar()) {
                    dadosTabela[i][4] = true;
                } else {
                    dadosTabela[i][4] = false;
                }
                if (listaPermisao.get(i).isInativar()) {
                    dadosTabela[i][5] = true;
                } else {
                    dadosTabela[i][5] = false;
                }
                dadosTabela[i][6] = listaPermisao.get(i).getId();
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
                    if (column == 2 || column == 3 || column == 4 || column == 5) {
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
            for (int i = 0; i < tabela.getColumnCount(); i++) {
                column = tabela.getColumnModel().getColumn(i);
                switch (i) {
                    case 0:
                        column.setPreferredWidth(30);
                        break;
                    case 1:
                        column.setPreferredWidth(110);
                        break;

                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao popular tabela: " + e + "\n" + e.getCause());
        }
        return true;
    }

}
