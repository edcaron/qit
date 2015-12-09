/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ExecutarScriptDAO;
import dao.MaquinasExecutarScriptDAO;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.ExecucaoScript;
import modelo.MaquinasExecutarScript;

/**
 *
 * @author eduar_000
 */
public class ControleExecutarScript implements IControle {

    ExecutarScriptDAO esdao;
    MaquinasExecutarScriptDAO mesdao;

    public ControleExecutarScript() {
        esdao = new ExecutarScriptDAO();
        mesdao = new MaquinasExecutarScriptDAO();
    }

    public boolean salvar(ExecucaoScript ec) {
        boolean retorno = false;
        try {
            retorno = esdao.salvar(ec);
            System.out.println("id es:" + ec.getId());
            if (retorno) {
                for (Iterator<MaquinasExecutarScript> it = ec.getMaquinasExecutarScripts().iterator(); it.hasNext() && retorno;) {
                    MaquinasExecutarScript mes = it.next();
                    mes.setExecucaoScript(new ExecucaoScript());
                    mes.getExecucaoScript().setId(ec.getId());
                    retorno = mesdao.salvar(mes);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro em salvar:" + e);
            e.printStackTrace();
        }

        return retorno;
    }

    public ExecucaoScript consultar(ExecucaoScript ec) {
        ExecucaoScript objLocal = new ExecucaoScript();
        try {
            objLocal = esdao.consultar(ec);
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return objLocal;
    }

    public ArrayList<ExecucaoScript> listar(IModelo obj) {
        ArrayList<ExecucaoScript> objLocal = new ArrayList<>();
        try {
            objLocal = esdao.listar(obj);
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return objLocal;
    }

    @Override
    public Object[][] popularTabela(JTable tabela, IModelo ec, boolean isModal) {
        Object[][] dadosTabela = null;
        try {
            int colunasTabela = 3;

            if (!isModal) {
                colunasTabela = 3;
            } else {
                colunasTabela = 3; //se modal for verdadeiro, a tabela vai ter 3 colunas para ser usado no JDialog para consulta
            }

            Object[] cabecalho = new Object[colunasTabela];

            cabecalho[0] = "Cód";
            cabecalho[1] = "Nome do Script";
            cabecalho[2] = "Data de Execução";

            // cria matriz de acordo com nº de registros da tabela
            ArrayList<ExecucaoScript> listaObj = esdao.listar(ec);

            dadosTabela = new Object[listaObj.size()][colunasTabela];

            for (int i = 0; i < listaObj.size(); i++) {
                dadosTabela[i][0] = listaObj.get(i).getId();
                dadosTabela[i][1] = listaObj.get(i).getScript().getNome();
                dadosTabela[i][2] = Util.dateToString(listaObj.get(i).getData());
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
        }
        return dadosTabela;
    }

//    public boolean inativar(int id) {
//        Sala objLocal = new Sala();
//        boolean retorno = false;
//
//        objLocal.setId(id);
//
////        consulta o obj sala no banco de dados com o id que vem como paramentro na funcao
//        objLocal = this.consultar(objLocal);
//
////        inverte o valor do status no obj que veio do banco
//        objLocal.setAtivo(controle.Util.inverteValorBinario(objLocal.isAtivo()));
//
////        salva novamente no banco
//        retorno = this.salvar(objLocal);
//        return retorno;
//    }
}
