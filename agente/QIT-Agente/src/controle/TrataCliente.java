/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import modelo.PacoteSocket;
import modelo.Tarefa;

/**
 *
 * @author eduar_000
 */
public class TrataCliente extends Thread {

    private Socket client;

    public TrataCliente(Socket s) {
        client = s;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream stream = new ObjectInputStream(client.getInputStream());
            PacoteSocket pacoteRecebido = (PacoteSocket) stream.readObject();

            for (Tarefa tarefa : pacoteRecebido.getListaTarefas()) {
                switch (tarefa.getOperacao()) {
                    case 1:
                        System.out.println("Recebemos ordem de fazer a tarefa " + tarefa.getOperacao());
                        Tarefas.geraInventario(client.getOutputStream());
                        break;
                    case 2:
                        System.out.println("Recebemos ordem de fazer a tarefa " + tarefa.getOperacao());
                        break;
                    case 3:
                        System.out.println("Recebemos ordem de fazer a tarefa " + tarefa.getOperacao());
                        Tarefas.executarScript(pacoteRecebido, client.getOutputStream());
                        break;
                    default:
                        System.out.println("numero de tarefa desconhecido");
                        break;
                }
            }

//            client.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
