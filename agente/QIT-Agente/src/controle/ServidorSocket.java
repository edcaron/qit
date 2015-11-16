/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author eduar_000
 */
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorSocket implements Runnable {

    ServerSocket ss;

    public ServidorSocket(int porta) {
        try {
            ss = new ServerSocket(porta);
        } catch (IOException ex) {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }

        new Thread(this).start();

        System.out.println("Servidor ouvindo na porta:" + porta);

    }

    public void run() {
        try {
            while (true) {
                System.out.println("Esperando conexões...");
                Socket cliente = ss.accept();
                new TrataCliente(cliente).start();
                System.out.println("Nova conexão com o cliente "
                        + cliente.getInetAddress().getHostAddress());

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
