/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import modelo.Inventario;
import modelo.PacoteSocket;
import modelo.Tarefa;

/**
 *
 * @author eduar_000
 */
public class Tarefas {

    public static void geraInventario(OutputStream os) {

//        capturar dados e escrever em xml
        XStream xstream = new XStream();
        try {
            OutputStream output = new FileOutputStream("C:\\QIT\\QIT-Agente\\inventario.xml");
            Inventario inventario = new ControleInventario().fazerInventario();
            xstream.toXML(inventario, output);
            output.close();
            System.out.println("Inventario coletado");
        } catch (IOException e) {
            System.err.println("" + e);
        }

        PacoteSocket pacote = new PacoteSocket();

        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
        Tarefa tarefa = new Tarefa();
        tarefa.setOperacao(2);

        ArrayList<byte[]> listaArquivos = new ArrayList<>();
        File inventario = new File("C:\\QIT\\QIT-Agente\\inventario.xml");
        byte[] inventarioEmBytes = Util.fileToByteArray(inventario);

        listaArquivos.add(inventarioEmBytes);
        tarefa.setListaArquivos(listaArquivos);
        listaTarefas.add(tarefa);
        pacote.setListaTarefas(listaTarefas);

//        Devolve dados (inventario) para o servidor
        ClienteSocket cs = new ClienteSocket(os);
        cs.enviarObjeto(pacote);
//        cs.fecharConexao();                  
    }

    public static void executarScript(PacoteSocket pacoteRecebido, OutputStream os) {
        String retornoScript = "";

        //fazer download de arquivos deste script
        ControleSamba.getFiles(pacoteRecebido.getTipo(), pacoteRecebido.getId());

        //executar tarefa
        for (Tarefa tarefa : pacoteRecebido.getListaTarefas()) {
            String comando = tarefa.getComando();
            retornoScript += Util.getCurrentTimestamp() + "tarefa iniciada \n";

            retornoScript += ComunicacaoSO.executarScripts(tarefa.getComando(), null);            

            retornoScript += Util.getCurrentTimestamp() + "tarefa concluída \n";
        }

//        preparar pacote com o retorno do script
        PacoteSocket pacote = pacoteRecebido;
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
        Tarefa tarefa = new Tarefa();
        tarefa.setOperacao(4);
        tarefa.setComando(retornoScript);
        listaTarefas.add(tarefa);
        pacote.setListaTarefas(listaTarefas);

//        Devolve dados (resultado so script) para o servidor
        ClienteSocket cs = new ClienteSocket(os);
        cs.enviarObjeto(pacote);
    }
}
