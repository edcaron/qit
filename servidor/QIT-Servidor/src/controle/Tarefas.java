/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.thoughtworks.xstream.XStream;
import dao.MaquinasExecutarScriptDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import modelo.Inventario;
import modelo.MaquinasExecutarScript;
import modelo.PacoteSocket;
import modelo.Tarefa;

/**
 *
 * @author eduar_000
 */
public class Tarefas {

    public static void armazenaInventario(Tarefa tarefa) throws IOException {

        for (byte[] bFile : tarefa.getListaArquivos()) {
//            byte[] bFile = pacote.getListaArquivos();

            String nomeDoArquivo = "C:\\QIT\\QIT-Servidor\\inventarios\\inventario" + Util.getCurrentTimestampCMD() + ".xml";
            FileOutputStream fos = new FileOutputStream(nomeDoArquivo);
            fos.write(bFile);
            fos.close();
            System.out.println("Arquivo do invenrtário armazenado");

            XStream x = new XStream();
            Inventario inventario = null;
            File file = new File(nomeDoArquivo);
            inventario = (Inventario) x.fromXML(file);
            ControleInventario ci = new ControleInventario();
            ci.gravarInventario(inventario);
            System.out.println("Inventario gravado no banco de dados");
        }

    }

    public static void armazenaRetornoScript(PacoteSocket pacote) {
        try {
            MaquinasExecutarScript mes = new MaquinasExecutarScript();
            for (Tarefa t : pacote.getListaTarefas()) {
                mes.setId(pacote.getIdTabelaRelacao());
                mes = new MaquinasExecutarScriptDAO().consultar(mes);
                mes.setDtRetorno(Util.getCurrentDate());
                mes.setRetorno(t.getComando());
                new MaquinasExecutarScriptDAO().salvar(mes);
            }
        } catch (Exception e) {
            System.err.println("Erro ao armazernarRetorno do script" + e);
            e.printStackTrace();
        }
    }
}
