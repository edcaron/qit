/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.MaquinasExecutarScriptDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.MaquinasExecutarScript;

/**
 *
 * @author eduar_000
 */
public class ControleMaquinasExecutarScript  {
    
    MaquinasExecutarScriptDAO mesdao;

    public ControleMaquinasExecutarScript() {        
        mesdao = new MaquinasExecutarScriptDAO();
    }
   
    
    public Object[][] popularTabela(JTable tabela, MaquinasExecutarScript ec, boolean isModal) {
        Object[][] dadosTabela = null;
        try {
            int colunasTabela = 3;

            if (!isModal) {
                colunasTabela = 3;
            } else {
                colunasTabela = 3; //se modal for verdadeiro, a tabela vai ter 3 colunas para ser usado no JDialog para consulta
            }

            Object[] cabecalho = new Object[colunasTabela];
            
            cabecalho[0] = "Cód.";
            cabecalho[1] = "Máquinas";
            cabecalho[2] = "So";

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<MaquinasExecutarScript> listaObj = mesdao.listar(ec);

            dadosTabela = new Object[listaObj.size()][colunasTabela];

            for (int i = 0; i < listaObj.size(); i++) {
                dadosTabela[i][0] = listaObj.get(i).getMaquina().getId();
                dadosTabela[i][1] = listaObj.get(i).getMaquina().getNome();
                dadosTabela[i][2] = listaObj.get(i).getMaquina().getSo();
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
            tabela.getColumnModel().getColumn(1).setCellRenderer(esquerda);
            tabela.getColumnModel().getColumn(2).setCellRenderer(esquerda);
            tabela.getTableHeader().setResizingAllowed(true);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;//      

        } catch (Exception e) {
            System.err.println("Erro ao popular tabela: " + e + "\n" + e.getCause());
            e.printStackTrace();
        }
        return dadosTabela;
    }
}
