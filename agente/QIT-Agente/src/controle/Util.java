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

    public static byte[] fileToByteArray(File file) {        
        try {
            FileInputStream fileInputStream = null;
            byte[] bFile = new byte[(int) file.length()];           
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            return  bFile;
        } catch (IOException e) {
            System.err.println("Erro em fileToByteArray:" + e);
        }
        return null;
    }

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
     *
     * @param data Sting com data vinda do cmd
     * @return Date do java
     */
    protected static java.sql.Date formataDataCmd(String data) {
        java.sql.Date date = null;
        if ((data != null) && data.length() == 8) {
            try {
                String dataF = "" + data.charAt(6) + data.charAt(7) + "-" + data.charAt(4) + data.charAt(5) + "-" + data.charAt(0) + data.charAt(1) + data.charAt(2) + data.charAt(3);
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                date = new java.sql.Date(format.parse(dataF).getTime());

            } catch (Exception e) {
                System.err.println("Erro em formataDataCmd: " + e);
            }
        }
        return date;
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

}
