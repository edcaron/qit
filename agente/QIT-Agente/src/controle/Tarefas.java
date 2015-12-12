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
        String diretorioScript = "";        
        String comandoParaProcesso = "";

        //fazer download de arquivos deste script
        ControleSamba.getFiles(pacoteRecebido.getTipo(), pacoteRecebido.getId());

        //executar tarefa
        for (Tarefa tarefa : pacoteRecebido.getListaTarefas()) {
            retornoScript += Util.getCurrentTimestamp() + " tarefa iniciada \n";          
            
            diretorioScript = "C:\\QIT\\QIT-Agente\\scripts\\" + pacoteRecebido.getId() + "\\";            
            comandoParaProcesso = diretorioScript + "Setup" + pacoteRecebido.getId() + ".bat";

//            salva o comando especificado em um arquivo .bat
            UtilArquivos.stringToFile(tarefa.getComando(), pacoteRecebido.getTipo(), pacoteRecebido.getId());

//            executa o comando, que vai ser gravado em um arquivo e entao chamado
            retornoScript += ComunicacaoSO.executarScripts(comandoParaProcesso, null, new File(diretorioScript));

            retornoScript += "\n" + Util.getCurrentTimestamp() + " tarefa concluída";
            
            retornoScript = retornoScript.replace(comandoParaProcesso, "");

            System.out.println("retornoScript: " + retornoScript);
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
