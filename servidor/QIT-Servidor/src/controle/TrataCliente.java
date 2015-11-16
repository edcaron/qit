/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.ByteArrayInputStream;
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
                        System.out.println("Recebemos ordem de fazer a operacao " + tarefa.getOperacao());
//                        Tarefas.geraInventario(client.getOutputStream());
                        break;
                    case 2:
                        System.out.println("Recebemos ordem de fazer a operacao " + tarefa.getOperacao());
                        Tarefas.armazenaInventario(tarefa);
                        break;
                    default:
                        System.out.println("numero de tarefa desconhecido");
                        break;
                }

            }

            client.close();

            System.out.println("isBound? " + client.isBound());
            System.out.println("closed? " + client.isClosed());
            System.out.println("connected? " + client.isConnected());
            System.out.println("input Shutd? " + client.isInputShutdown());
            System.out.println("outpShut? " + client.isOutputShutdown());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static Object deserializar(byte[] objectAsByte) throws IOException, ClassNotFoundException {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
//        try {
        bis = new ByteArrayInputStream(objectAsByte);
        ois = new ObjectInputStream(bis);
        obj = ois.readObject();
        bis.close();
        ois.close();
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Erro em deserializar:\n" + e);
//        }
        return obj;
    }

}
