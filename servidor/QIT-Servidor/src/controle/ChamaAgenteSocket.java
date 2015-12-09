/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.Maquina;
import modelo.MaquinasExecutarScript;
import modelo.PacoteSocket;
import modelo.Script;
import modelo.Tarefa;

/**
 *
 * @author eduar_000
 */
public class ChamaAgenteSocket {

    public void executarScriptNoCliente(MaquinasExecutarScript mes, Maquina maquina, Script script) {

        PacoteSocket pacote = new PacoteSocket();
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();

//        preparar o pacote
        pacote.setId(script.getId());
        pacote.setTipo(2);
        pacote.setIdTabelaRelacao(mes.getId());

        Tarefa tarefa = new Tarefa();
        tarefa.setOperacao(3);
        tarefa.setComando(script.getTexto());
        listaTarefas.add(tarefa);
        pacote.setListaTarefas(listaTarefas);

//        iniciar socket
        ClienteSocket cs1 = new ClienteSocket(maquina.getHost(), 1234);
//        verificar conexão
        boolean conectado = cs1.verificarConexao();
        System.out.println("Esta conectado?" + conectado);

        if (conectado) {
//        envia dados para o agente
            cs1.enviarObjeto(pacote);
//        pega dados do agente
            cs1.pegarRetorno();
        }else{
            pacote.getListaTarefas().get(0).setComando("Não foi possível conectar-se ao agente");
            Tarefas.armazenaRetornoScript(pacote);
        }
    }

    public void executarInventarioNoCliente(Maquina maquina) {

        PacoteSocket pacote = new PacoteSocket();
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
//        preparar o pacote
        Tarefa tarefa = new Tarefa();
        tarefa.setOperacao(1);

        listaTarefas.add(tarefa);
        pacote.setListaTarefas(listaTarefas);

        //        iniciar socket
        ClienteSocket cs1 = new ClienteSocket(maquina.getHost(), 1234);
//        verificar conexão
        boolean conectado = cs1.verificarConexao();
        System.out.println("Esta conectado?" + conectado);

        if (conectado) {
//        envia dados para o agente
            cs1.enviarObjeto(pacote);
//        pega dados do agente
            cs1.pegarRetorno();
        }
    }
}
