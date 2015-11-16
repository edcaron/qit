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
import java.net.*;

public class ServidorSocket implements Runnable {

    ServerSocket ss;

    public ServidorSocket(int porta) throws Exception {
        ss = new ServerSocket(porta);

        new Thread(this).start();

        System.out.println("Servidor ouvindo na porta:" + porta);

    }

    public void run() {
        try {
            while (true) {
                Socket cliente = ss.accept();
                new TrataCliente(cliente).start();
                System.out.println("Mais um cliente atendido!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
