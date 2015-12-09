/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.MaquinaDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Maquina;

/**
 *
 * @author Tiago
 */
public class ControleMaquina implements IControle {

    private MaquinaDAO dao;

    public ControleMaquina() {
        dao = new MaquinaDAO();
    }

    @Override
    public Object[][] popularTabela(JTable tabela, IModelo modelo, boolean isModal) {
        Object[][] dadosTabela = null;
        //   System.out.println("populando tabela");
        try {
            int colunasTabela = 3;

            if (isModal) {
                colunasTabela = 2; //se modal for verdadeiro, a tabela vai ter so 2 colunas para ser usado no JDialog para consulta
            } else {
                colunasTabela = 3;
            }

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Cód.";
            cabecalho[1] = "Nome";
            cabecalho[2] = "So";

            // cria matriz de acordo com n de registros da tabela
            ArrayList<Maquina> lista = dao.listar(modelo);

            dadosTabela = new Object[lista.size()][colunasTabela];

            for (int i = 0; i < lista.size(); i++) {
                dadosTabela[i][0] = lista.get(i).getId();
                dadosTabela[i][1] = lista.get(i).getNome();
                dadosTabela[i][2] = lista.get(i).getSo();
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
            if (isModal) {
                tabela.setSelectionMode(0);
            }

//Desabilitar arrastar e soltar
            tabela.getTableHeader().setReorderingAllowed(false);

            //alinha valores da coluna de valores para a direita 
            DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

            esquerda.setHorizontalAlignment(SwingConstants.LEFT);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            direita.setHorizontalAlignment(SwingConstants.RIGHT);

            tabela.getColumnModel().getColumn(0).setCellRenderer(esquerda);
            tabela.getColumnModel().getColumn(1).setCellRenderer(esquerda);
            tabela.getColumnModel().getColumn(2).setCellRenderer(esquerda);
            tabela.getTableHeader().setResizingAllowed(true);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
        } catch (Exception e) {
            System.err.println("Erro ao popular tabela: " + e + "\n" + e.getCause());
        }
        return dadosTabela;
    }

}
