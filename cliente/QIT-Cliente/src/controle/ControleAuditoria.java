/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AuditoriaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableColumn;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Auditoria;
import modelo.ExecucaoScript;
import org.hibernate.Criteria;

/**
 *
 * @author Tiago
 */
public class ControleAuditoria {

    private AuditoriaDAO dao;

    public ControleAuditoria() {
        this.dao = new AuditoriaDAO();
    }
    

    public Object[][] popularTabela(JTable tabela, String parametros , boolean isModal) {
        Object[][] dadosTabela = null;
        try {
            int colunasTabela = 7;

            if (isModal) {
                colunasTabela = 2;
            } else {
                colunasTabela = 7; //se modal for verdadeiro, a tabela vai ter 3 colunas para ser usado no JDialog para consulta                
            }

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Cód";
            cabecalho[1] = "Cód Usuário";
            cabecalho[2] = "Nome Usuário";
            cabecalho[3] = "Tabela";
            cabecalho[4] = "Cód do registro";
            cabecalho[5] = "Operação";
            cabecalho[6] = "Data";

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<Auditoria> listaObj = dao.listar(parametros);

            dadosTabela = new Object[listaObj.size()][colunasTabela];

            for (int i = 0; i < listaObj.size(); i++) {
                String operacao = "";
                switch (listaObj.get(i).getOperacao()) {
                    case 'I':
                        operacao = "Inserir";
                        break;
                    case 'U':
                        operacao = "Editar";
                        break;
                    case 'D':
                        operacao = "Excluir";
                        break;
                }
                dadosTabela[i][0] = listaObj.get(i).getId();
                dadosTabela[i][1] = listaObj.get(i).getUsuario().getId();
                dadosTabela[i][2] = listaObj.get(i).getUsuario().getNome();
                dadosTabela[i][3] = listaObj.get(i).getTabela();
                dadosTabela[i][4] = listaObj.get(i).getIdConteudo();
                dadosTabela[i][5] = operacao;
                dadosTabela[i][6] = Util.dateToString(listaObj.get(i).getDt());
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
            tabela.getColumnModel().getColumn(2).setCellRenderer(esquerda);
            tabela.getColumnModel().getColumn(3).setCellRenderer(esquerda);
            tabela.getColumnModel().getColumn(4).setCellRenderer(direita);
            tabela.getColumnModel().getColumn(5).setCellRenderer(esquerda);
            tabela.getColumnModel().getColumn(6).setCellRenderer(direita);
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
