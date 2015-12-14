/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author eduardo.caron
 */
public class ClienteSocket {

    private Socket socketCliente;
    private String enderecoRemoto;
    private int porta;

    public ClienteSocket(String enderecoRemoto, int porta) {
        this.enderecoRemoto = enderecoRemoto;
        this.porta = porta;       
        try {
            socketCliente = new Socket(this.enderecoRemoto, this.porta);
            System.out.println("Cliente inciado e enviando para: " + this.enderecoRemoto + ":" + this.porta);
        } catch (IOException e) {
            System.err.println("Não foi possivel iniciar o socket cliente:\n" + e.getLocalizedMessage());
        }
    }

    public boolean verificarConexao() {
        boolean retorno = false;
        try {
            if (!socketCliente.isClosed()) {
                retorno = true;
            }
        } catch (Exception e) {
//            System.err.println("Erro ao vefiricar conexao " + e);
//            e.printStackTrace();
        }
        return retorno;
    }

    public boolean enviarObjeto(Object obj) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socketCliente.getOutputStream());
            stream.writeObject(obj);

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean fecharConexao() {
        boolean retorno = true;
        try {
            socketCliente.close();
            System.out.println("Fechando conexão com o servidor");
        } catch (Exception e) {
            System.err.println("Não foi possivel encerrar o socket:\n" + e);
            retorno = false;
        }
        return retorno;
    }

    public void pegarRetorno() {
        System.out.println("pega retorno chamado");
        TrataCliente tc = new TrataCliente(socketCliente);
        tc.start();
    }
}
