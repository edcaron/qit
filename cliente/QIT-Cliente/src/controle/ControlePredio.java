/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.PredioDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Predio;

/**
 *
 * @author eduar_000
 */
public class ControlePredio implements IControle {

    private PredioDAO dao;

    public ControlePredio() {
        dao = new PredioDAO();
    }

    public boolean salvar(Predio predio) {
        return dao.salvar(predio);
    }

    public Predio consultar(Predio predio) {
        Predio objLocal = new Predio();
        try {
      //      System.out.println("o predio consultado e o "+predio.getId());
            objLocal = dao.consultar(predio);
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return objLocal;
    }
 
    @Override
    public Object[][] popularTabela(JTable tabela, IModelo objModelo, boolean isModal) {
        Object[][] dadosTabela = null;
     //   System.out.println("populando tabela");
        try {
            int colunasTabela = 2;

            if (isModal) {
                colunasTabela = 2; //se modal for verdadeiro, a tabela vai ter so 2 colunas para ser usado no JDialog para consulta
            } else {
                colunasTabela = 2; 
            }

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Cód.";
            cabecalho[1] = "Predio";            
            
     

            // cria matriz de acordo com n de registros da tabela
            ArrayList<Predio> listaPredio = dao.listar(objModelo);

            dadosTabela = new Object[listaPredio.size()][colunasTabela];

            for (int i = 0; i < listaPredio.size(); i++) {
                dadosTabela[i][0] = listaPredio.get(i).getId();
                dadosTabela[i][1] = listaPredio.get(i).getNome();
       
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
        return dadosTabela;
    }

    public boolean inativar(int id) {
       Predio objLocal = new Predio();
        boolean retorno = false;

        objLocal.setId(id);

//        consulta o obj sala no banco de dados com o id que vem como paramentro na funcao
        objLocal = this.consultar(objLocal);

//        inverte o valor do status no obj que veio do banco
        objLocal.setAtivo(controle.Util.inverteValorBinario(objLocal.isAtivo()));

//        salva novamente no banco
        retorno = this.salvar(objLocal);
        return retorno; }

}
