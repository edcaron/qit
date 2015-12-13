/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ParticaoDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Maquina;
import modelo.Particao;

/**
 *
 * @author Tiago
 */
public class ControleParticao {

    private ParticaoDAO dao;

    public ControleParticao() {
        this.dao = new ParticaoDAO();
    }

    public boolean popularTabela(JTable tabela, Maquina m) {
        Object[][] dadosTabela = null;

        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) tabela.getModel();

        try {
            int colunasTabela = 5;

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Nome";
            cabecalho[1] = "Letra:";
            cabecalho[2] = "Formato:";
            cabecalho[3] = "Tamanho GB:";
            cabecalho[4] = "Espaço Livre GB:";

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<Particao> listaPerticao = dao.listar(m);

            dadosTabela = new Object[listaPerticao.size()][colunasTabela];

            for (int i = 0; i < listaPerticao.size(); i++) {
                dadosTabela[i][0] = listaPerticao.get(i).getNome();
                dadosTabela[i][1] = listaPerticao.get(i).getLetra();
                dadosTabela[i][2] = listaPerticao.get(i).getFormato();
                dadosTabela[i][3] = String.format("%.2f",(listaPerticao.get(i).getEspacoMb() / 1024)); // conversao para gb e 2 casas decimais
                dadosTabela[i][4] = String.format("%.2f",(listaPerticao.get(i).getEspacoLivreMb() / 1024)); // conversao para gb gb e 2 casas decimais

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
            for (int i = 0; i < tabela.getColumnCount(); i++) {
                column = tabela.getColumnModel().getColumn(i);
                switch (i) {
                    case 0:
                        column.setPreferredWidth(20);
                        break;
                    case 1:
                        column.setPreferredWidth(20);
                        break;
                    case 2:
                        column.setPreferredWidth(80);
                        break;
                    case 3:
                        column.setPreferredWidth(80);
                        break;
                    case 4:
                        column.setPreferredWidth(50);
                        break;
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao popular tabela: " + e + "\n" + e.getCause());
        }
        return true;
    }

}
