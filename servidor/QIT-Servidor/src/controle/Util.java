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
     * Converter uma string com uma marca de data e hora para um objeto date
     *
     * @param dtParametro string no formato dd/MM/yyyy HH:mm:ss
     * @return objeto Date
     */
    public static Date stringParaDate(String dtParametro) {
        Date dtRetorno = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            dtRetorno = (Date) formatter.parse(dtParametro);
        } catch (Exception e) {
            System.err.println("Erro em stringParaDate");
            e.printStackTrace();
        }
        return dtRetorno;
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
     * Transforma um objeto File em um array de bytes, para que possa ser
     * transmitido por sockets byte[]
     *
     * @param f File a ser convertido
     * @return byte[] resultante da conversao
     */
    public static byte[] fileToByteArray(File f) {
        byte[] retorno = null;
        try {
            FileInputStream fis = new FileInputStream(f);
            byte[] bFile = new byte[(int) f.length()];
            fis.read(bFile);
            fis.close();
            retorno = bFile;
        } catch (IOException e) {
            System.err.println("Erro em fileToByteArray:" + e);
        }
        return retorno;
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
     * @return String com data no formato dd/MM/yyyy HH:mm:ss
     */
    public static String getCurrentTimestampCMD() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date dt = new Date();
        String retorno = dateFormat.format(dt);
        retorno = retorno.replaceAll(" ", "-");
        retorno = retorno.replaceAll(":", "");
        System.out.println("Hora para retorno: " + retorno);
        return retorno;
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
