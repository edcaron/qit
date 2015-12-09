/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ScriptDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Script;
import modelo.Usuario;

/**
 *
 * @author Tiago
 */
public class ControleScript implements IControle {

    ScriptDAO sdao;

    public ControleScript() {
        sdao = new ScriptDAO();
    }

    public boolean salvar(Script script) {
        System.out.println("controle script");
        return sdao.salvar(script);
    }

    public Script consultar(Script script) {

        Script scriptLocal = new Script();
        try {
            scriptLocal = sdao.consultar(script);
        } catch (Exception e) {
            System.err.println("" + e);

        }
        return scriptLocal;
    }

    @Override
    public Object[][] popularTabela(JTable tabela, IModelo modelo, boolean isModal) {

        sdao = new ScriptDAO();
        Object[][] dadosTabela = null;
        try {
            int colunasTabela = 2;

            if (isModal) {
                colunasTabela = 2;
            } else {
                colunasTabela = 2; //se modal for verdadeiro, a tabela vai ter 3 colunas para ser usado no JDialog para consulta
            }

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Cód";
            cabecalho[1] = "Nome";            
            

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<Script> listaSalas = sdao.listar(modelo);

            dadosTabela = new Object[listaSalas.size()][colunasTabela];

            for (int i = 0; i < listaSalas.size(); i++) {
                dadosTabela[i][0] = listaSalas.get(i).getId();
                dadosTabela[i][1] = listaSalas.get(i).getNome();
             
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

            tabela.getColumnModel().getColumn(0).setCellRenderer(esquerda);
            tabela.getColumnModel().getColumn(1).setCellRenderer(esquerda);

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
            System.err.println("Erro ao popular tabela de scripts: " + e + "\n" + e.getCause());
        }
        return dadosTabela;
    }
}
