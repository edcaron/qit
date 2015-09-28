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
     * Método para obter data e hora atual.
     *
     * @return Date do Java
     */
    public static Date getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dt = new Date();
        return (dt);
    }
    

    public static String getCurrentFile() {
        String retorno = "";
        try {
            retorno = Thread.currentThread().getStackTrace()[2].getClassName();
        } catch (Exception e) {
            System.err.println("Erro em getCurrentFile()");
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
            System.err.println(""+ex);
        }
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            System.err.println(""+ex);
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

    
}
