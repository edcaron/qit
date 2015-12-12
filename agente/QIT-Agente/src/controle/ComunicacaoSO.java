/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 *
 * @author eduar_000
 */
public class ComunicacaoSO {

    protected static class StreamReader extends Thread {

        private InputStream is;
        private StringWriter sw = new StringWriter();

        public StreamReader(InputStream is) {
            this.is = is;
        }

        public void run() {
            try {
                int c;
                while ((c = is.read()) != -1) {
                    sw.write(c);
                }
            } catch (IOException e) {
                System.err.println("erro em  class StreamReader extends Thread \n" + e);
            }
        }

        public String getResult() {
            return sw.toString();
        }
    }

    /**
     * Funcao para fazer uma pesquisa no arquivo de registro do windows
     *
     * @param location path in the registry
     * @param parameters parameters for the reg query on cmd
     * @return String com conteudo retornado pelo processo
     */
    public static String lerDoRegedit(String location, String parameters) {
        try {
            // Run reg query, then read output with StreamReader (internal class)
            String cmd = "reg query " + location + " " + parameters;
            System.out.println("comando: " + cmd);
            Process process = Runtime.getRuntime().exec(cmd);

            StreamReader reader = new StreamReader(process.getInputStream());
            reader.start();
            process.waitFor();
            reader.join();
            String output = reader.getResult();

            return output;
        } catch (IOException | InterruptedException e) {
            System.err.println("erro em readRegistry /n" + e);
            return null;
        }
    }

    /**
     * Funcao para executar qualquer tipo de comando no CMD do windows
     *
     * @param comando programa ou comando a ser executado
     * @param parametro parametros adicionais para o comando enviado
     * anteriormente
     * @return String com o retorno dado pelo cmd
     */
    public static String executarComando(String comando, String parametro) {
        String output = "";
        try {
            System.out.println("comando:" + comando);
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                output += line;
                output += "\n";
            }
            return output;
        } catch (IOException e) {
            System.err.println("erro em executarComando \n" + e);
            return "Erro ao executar comandos \n" + e;
        }
    }

    /**
     * Funcao para executar script no CMD do windows. e necessario passar o
     * caminho completo do arquivo a ser chamado
     *
     * @param comando programa ou comando a ser executado
     * @param parametro parametros adicionais para o comando enviado
     * anteriormente
     * @return String com o retorno dado pelo cmd
     */
    public static String executarScripts(String comando, String parametro, File caminhoDaPasta) {
        String output = "";
        try {
            System.out.println("comando:" + comando);
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
            builder.redirectErrorStream(true);
            builder.directory(caminhoDaPasta);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                output += line;
                output += "\n";
            }
            return output;
        } catch (IOException e) {
            System.err.println("erro em executarComando \n" + e);
            return "Erro ao executar comandos \n" + e;
        }
    }

}
