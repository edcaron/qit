/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
     * Metodo que retorna um hash md5 de um arquivo enviado como parâmetro.
     *
     * @param file - arquivo a ter seu md5 gerado
     * @return String com o hash md5
     */
    public static String md5(File file) {
        MessageDigest digest = null;
        InputStream is = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("" + ex);
        }
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            System.err.println("" + ex);
        }
        byte[] buffer = new byte[8192];
        int read = 0;
        String output = null;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            output = bigInt.toString(16);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possivel processar o arquivo.", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException("Não foi possivel fechar o arquivo", e);
            }
        }
        return output;
    }

    /**
     * Método para obter data e hora atual.
     *
     * @return Date do Java
     */
    public static Date getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/zyyyy HH:mm:ss");
        Date dt = new Date();
        return (dt);
    }

    /**
     * Método para converter data para string com formato brasileiro
     *
     * @return String dia/mes/ano hora:mins:secs
     */
    public static String dateToString(Date d) {
        String retorno = "";
        try {
            retorno = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(d);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
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

    /**
     * Recebe um binario: se for verdadeiro, retorna falso e vice-versa.
     *
     * @param parametro
     * @return
     */
    public static boolean inverteValorBinario(boolean parametro) {
        boolean retorno = true;
        if (parametro) {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Recebe um boolean retorna Ativo ou Inativo
     *
     * @param parametro
     * @return String
     */
    public static String binarioParaString(boolean parametro) {
        String retorno = "Ativo";
        if (!parametro) {
            retorno = "Inativo";
        }
        return retorno;
    }

    /**
     * Recebe um String e retorna seu valor booleano boolean
     *
     * @param parametro
     * @return
     */
    public static boolean stringParaBinario(String parametro) {
        boolean retorno = true;
        if (parametro.equals("Inativo")) {
            retorno = false;
        }
        return retorno;
    }
}
