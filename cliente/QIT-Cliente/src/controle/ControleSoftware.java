/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.SoftwareDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Maquina;
import modelo.Sala;
import modelo.Software;
import modelo.SoftwaresMaquina;

/**
 *
 * @author Tiago
 */
public class ControleSoftware {

    private SoftwareDAO dao;

    public ControleSoftware() {
        dao = new SoftwareDAO();
    }

    public Software ConsultarSoftware(Software software) {
        Software s = new Software();
        try {
            s = dao.consultar(software);
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return s;
    }

    public void popularTabelaSoftware(JTable jtResultados, Maquina m, String nome) {
        Object[][] dadosTabela = null;
        //   System.out.println("populando tabela");
        try {
            int colunasTabela = 4;

            Object[] cabecalho = new Object[colunasTabela];
            cabecalho[0] = "Id:";
            cabecalho[1] = "Nome:";
            cabecalho[2] = "Versão:";
            cabecalho[3] = "Desenvolvedor:";
//            cabecalho[4] = "Comando remoção:";

            // cria matriz de acordo com n de registros da tabela
            Sala s = new Sala();
            s.setId(0);
            m.setSala(s);
            ArrayList<SoftwaresMaquina> listaPredio = dao.listarSoftwares(m , nome);

            dadosTabela = new Object[listaPredio.size()][colunasTabela];

            for (int i = 0; i < listaPredio.size(); i++) {
                dadosTabela[i][0] = listaPredio.get(i).getSoftware().getId();
                dadosTabela[i][1] = listaPredio.get(i).getSoftware().getNome();
                dadosTabela[i][2] = listaPredio.get(i).getSoftware().getVersao();
                dadosTabela[i][3] = listaPredio.get(i).getSoftware().getDesenvolvedor();
//                dadosTabela[i][4] = listaPredio.get(i).getSoftware().getComandoDesinstalacao();
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
            jtResultados.getColumnModel().getColumn(1).setCellRenderer(esquerda);
            jtResultados.getColumnModel().getColumn(2).setCellRenderer(direita);
            jtResultados.getColumnModel().getColumn(3).setCellRenderer(esquerda);
//            jtResultados.getColumnModel().getColumn(4).setCellRenderer(esquerda);           
            jtResultados.getTableHeader().setResizingAllowed(true);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < jtResultados.getColumnCount(); i++) {
                column = jtResultados.getColumnModel().getColumn(i);
                switch (i) {
                    case 0:
                        column.setPreferredWidth(20);
                        break;
                    case 1:
                        column.setPreferredWidth(150);
                        break;
                    case 2:
                        column.setPreferredWidth(20);
                        break;
                    case 3:
                        column.setPreferredWidth(150);
                        break;
                    case 4:
                        column.setPreferredWidth(150);
                        break;
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao popular tabela: " + e + "\n" + e.getCause());
        }

    }
    
}
