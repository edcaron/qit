/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.SalaDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Sala;

/**
 *
 * @author eduar_000
 */
public class ControleSala {

    SalaDAO sdao;

    public ControleSala() {
        sdao = new SalaDAO();
    }

    public boolean salvar(Sala sala) {
        return sdao.salvar(sala);
    }

    public Object[][] popularTabelaSala(JTable tabela, Sala sala) {
        Object[][] dadosTabela = null;
        try {
            // dados da tabela

            int colunasTabela = 5;
            // cabecalho da tabela
            Object[] cabecalho = new Object[colunasTabela];
            cabecalho[0] = "Cód. Sala";
            cabecalho[1] = "Sala";
            cabecalho[2] = "Cód. Predio";
            cabecalho[3] = "Predio";
            cabecalho[4] = "Status";

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<Sala> listaSalas = sdao.listar(sala);

            dadosTabela = new Object[listaSalas.size()][colunasTabela];

            for (int i = 0; i < listaSalas.size(); i++) {
                dadosTabela[i][0] = listaSalas.get(i).getId();
                dadosTabela[i][1] = listaSalas.get(i).getNome();
                dadosTabela[i][2] = listaSalas.get(i).getPredio().getId();
                dadosTabela[i][3] = listaSalas.get(i).getPredio().getNome();
                dadosTabela[i][4] = listaSalas.get(i).isAtivo();
            }

            // configuracoes adicionais no componente tabela
            tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                // quando retorno for FALSE, a tabela nao é editavel
                public boolean isCellEditable(int row, int column) {
                    return false;
                    /*  
                     if (column == 3) {  // apenas a coluna 3 sera editavel
                     return true;
                     } else {
                     return false;
                     }
                     */
                }

                // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
                @Override
                public Class getColumnClass(int column) {

                    if (column == 2) {
//                    return ImageIcon.class;
                    }
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
            System.err.println("erroo: " + e);
        }
        return dadosTabela;
    }
}
