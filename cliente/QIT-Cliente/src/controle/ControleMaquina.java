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
                colunasTabela = 3; //se modal for verdadeiro, a tabela vai ter so 2 colunas para ser usado no JDialog para consulta
            } else {
                colunasTabela = 3;
            }

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Cód.";
            cabecalho[1] = "Nome";
            cabecalho[2] = "SO";

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
//            tabela.setSelectionMode(0);

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
            tabela.getColumnModel().getColumn(1).setCellRenderer(esquerda);
            tabela.getTableHeader().setResizingAllowed(true);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;//        

        } catch (Exception e) {
            System.err.println("Erro ao popular tabela: " + e + "\n" + e.getCause());
        }
        return dadosTabela;
    }

    public void popularTabelaMaquina(JTable jtResultados, Maquina m) {
        Object[][] dadosTabela = null;
        //   System.out.println("populando tabela");
        try {
            int colunasTabela = 6;

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Cód.";
            cabecalho[1] = "Host";
            cabecalho[2] = "Dominio";
            cabecalho[3] = "BIOS";
            cabecalho[4] = "Fabricante";
            cabecalho[5] = "Sala";

            // cria matriz de acordo com n de registros da tabela
            ArrayList<Maquina> listaPredio = dao.listarMaquinas(m);

            dadosTabela = new Object[listaPredio.size()][colunasTabela];

            for (int i = 0; i < listaPredio.size(); i++) {
                dadosTabela[i][0] = listaPredio.get(i).getId();
                dadosTabela[i][1] = listaPredio.get(i).getHost();
                dadosTabela[i][2] = listaPredio.get(i).getDominio();
                dadosTabela[i][3] = listaPredio.get(i).getBios();
                dadosTabela[i][4] = listaPredio.get(i).getFabricantePc();
                dadosTabela[i][5] = listaPredio.get(i).getSala().getNome();

            }

            // configuracoes adicionais no componente tabela
            jtResultados.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
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
            jtResultados.setSelectionMode(0);

//Desabilitar arrastar e soltar
            jtResultados.getTableHeader().setReorderingAllowed(false);

            //alinha valores da coluna de valores para a direita 
            DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

            esquerda.setHorizontalAlignment(SwingConstants.LEFT);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            direita.setHorizontalAlignment(SwingConstants.RIGHT);

            jtResultados.getColumnModel().getColumn(0).setCellRenderer(direita);
            
            jtResultados.getTableHeader().setResizingAllowed(true);

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

    }

    public Maquina consultar(Maquina m) { // somente para sessao
        Maquina usuarioLocal = new Maquina();
        try {
            usuarioLocal = dao.consultar(m);
        } catch (Exception e) {
            System.err.println("erro ao consultar maquina" + e);

        }
        return usuarioLocal;
    }

}
