/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author eduardo.caron
 */
public class ClienteSocket {

    private OutputStream os;

    public ClienteSocket(OutputStream os) {
        this.os = os;
    }

    public boolean enviarObjeto(Object obj) {
//        byte[] dados;
////        try {
//
//            DataOutputStream dOut = new DataOutputStream(os);
//
//            dados = serializarObjeto(obj);
//            dOut.writeInt(dados.length); // write length of the message
//            dOut.write(dados);           // write the message
//            dOut.flush();
////            dOut.close();
//            System.out.println("Enviado o objeto");
////        } catch (NumberFormatException | IOException e) {
////            e.printStackTrace();
////        }

        byte[] dados;
        try {

            ObjectOutputStream stream = new ObjectOutputStream(os);
            stream.writeObject(obj);

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private byte[] serializarObjeto(Object obj) {
        byte[] retorno = null;
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream ous;
            ous = new ObjectOutputStream(bao);
            ous.writeObject(obj);
            retorno = bao.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

//    public boolean fecharConexao() {
//        boolean retorno = true;
//        try {
//            socketCliente.close();
//        } catch (Exception e) {
//            System.err.println("Não foi possivel encerrar o socket:\n" + e);
//            retorno = false;
//        }
//        return retorno;
//    }
}
