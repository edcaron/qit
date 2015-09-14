/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author eduar_000
 */
public class Util {

    /**
     * Método para obter data e hora atual.
     *
     * @return String com data no formato dd/MM/yyyy HH:mm:ss
     */
    public static String getCurrentTimestamp() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dt = new Date();
        return dateFormat.format(dt);
    }

    /**
     * Metodo que retorna um hash md5 para uma string enviada como parâmetro.
     *
     * @param senha - String com o texto a ter o ms5 gerado
     * @return String com o hash md5
     */
    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    /**
     * Funcao para aplicar em um JFrame configuracoes definidas para o projeto.
     * Ao fechar: dispose resizable false, location(0,130), Size(700, 550).
     *
     * @param jrm JFrame a ter suas propriedades alteradas
     */
    public static void definePadroesJFrame(JFrame jrm) {
        try {
            jrm.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            jrm.setResizable(false);
            jrm.setLocation(0, 130);
            jrm.setSize(700, 550);
        } catch (Exception e) {
            System.err.println("Erro em definePadroesJFrame " + e);
        }

    }
}
