/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

/**
 *
 * @author eduar_000
 */
public class ControleSamba {

    private final String USER = "eduardo";
    private final String PASSWORD = "eduardo";
    private final String SERVER = "qit-server";
    private final String DOMAIN = SERVER;
    private final String SHARED_FOLDER = "smb://" + SERVER + "/qit/";
    private final String SOFTWARES_PATH = SHARED_FOLDER + "softwares/";
    private final String SCRIPTS_PATH = SHARED_FOLDER + "scripts/";
//    private  final NtlmPasswordAuthentication AUTHENTICATION = new NtlmPasswordAuthentication(DOMAIN, USER, PASSWORD);
    private final NtlmPasswordAuthentication AUTHENTICATION = new NtlmPasswordAuthentication(null);

    /**
     * Salvar um arquivo da maquina local no servidor samba
     *
     * @param nome nome do arquivo a ser salvo
     * @param arquivo array de bytes do arquivo
     * @param tipo 1 para softwares, 2 para scripts
     * @param id id do software/script no banco de dados
     * @return true se deu certo
     */
    public boolean save(String nome, byte[] arquivo, int tipo, int id) {
        String caminhoArquivo = "";
        boolean retorno = false;
        try {
            if (tipo == 1) {
                caminhoArquivo = SOFTWARES_PATH + id;
            } else if (tipo == 2) {
                caminhoArquivo = SCRIPTS_PATH + id;
            }

            if (!exists(caminhoArquivo)) {
                makeDir(caminhoArquivo);
            }

            caminhoArquivo += "/" + nome;

            System.out.println("Arquivo a ser salvo: " + caminhoArquivo);

            SmbFile smbFile = new SmbFile(caminhoArquivo, AUTHENTICATION);
            SmbFileOutputStream out = new SmbFileOutputStream(smbFile);

            out.write(arquivo);
            out.flush();
            out.close();
            System.out.println("Salvo!");
            retorno = true;
        } catch (Exception e) {
            System.err.println("Erro em save" + e);
        }
        return retorno;
    }

    /**
     * Verifica se um arquivo existe no samba
     *
     * @param caminho caminho completo do arquivo ou pasta
     * @return true se deu certo
     */
    public boolean exists(String caminho) {
        boolean retorno = false;
        try {
            System.out.println("Arquivo para verificar se existe: " + caminho);
            SmbFile smbFile = new SmbFile(caminho, AUTHENTICATION);

            retorno = smbFile.exists();
            System.out.println("Existe?" + retorno);
        } catch (Exception e) {
            System.err.println("Erro em exists " + e);
        }
        return retorno;
    }

    /**
     * Cria pastas no samba
     *
     * @param caminho caminho completo do arquivo ou pasta
     * @return true se deu certo
     */
    public boolean makeDir(String caminho) {
        boolean retorno = false;
        try {

            System.out.println("Arquivo a ser criado: " + caminho);
            SmbFile smbFile = new SmbFile(caminho, AUTHENTICATION);

            smbFile.mkdir();
            retorno = true;
            System.out.println("Criado?" + retorno);
        } catch (Exception e) {
            System.err.println("Erro em exists " + e);
        }
        return retorno;
    }

    /**
     * Deleta um arquivo
     *
     * @param nome nome do arquivo a ser apagado
     * @param tipo 1 para softwares, 2 para scripts
     * @param id id do software/script no banco de dados
     * @return true se deu certo
     */
    public boolean delete(String nome, int tipo, int id) {
        boolean retorno = false;
        String caminhoArquivo = "";

        try {
            if (tipo == 1) {
                caminhoArquivo = SOFTWARES_PATH + id + "/" + nome;
            } else if (tipo == 2) {
                caminhoArquivo = SCRIPTS_PATH + id + "/" + nome;
            }

            System.out.println("Arquivo a ser apagado: " + caminhoArquivo);
            SmbFile smbFile = new SmbFile(caminhoArquivo, AUTHENTICATION);

            smbFile.delete();
            retorno = true;
            System.out.println("apagado? " + retorno);
        } catch (Exception e) {
            System.err.println("Erro em exists " + e);
        }
        return retorno;
    }

    public byte[] fileToByteArray(File file) {
        try {
            FileInputStream fileInputStream = null;
            byte[] bFile = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            return bFile;
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError e) {
            System.err.println("Erro em fileToByteArray:" + e);
        }
        return null;
    }

    /**
     *
     * @param tipo 1 software e 2 scripts
     * @param id id do software ou do script
     * @return
     */
    public boolean getFiles(int tipo, int id) {
        boolean retorno = false;
        FileOutputStream fileOutputStream;
        InputStream fileInputStream;
        byte[] buf;
        int len;
        String caminhoArquivoServidor = "";
        SmbFile diretorioServidor = null;
        SmbFile arquivoOrigem = null;
        String dirPastaDestino = "";
        String dirArquivoDestino = "";
        File pastaLocal = null;

        try {
//            monta a url da pasta dos arquivos no servidor
            if (tipo == 1) {
                caminhoArquivoServidor = SOFTWARES_PATH + id + "/";
            } else if (tipo == 2) {
                caminhoArquivoServidor = SCRIPTS_PATH + id + "/";
            }

            diretorioServidor = new SmbFile(caminhoArquivoServidor, AUTHENTICATION);
            
            for (String nomeDoArquivo : diretorioServidor.list()) {//listar os arquivos no diretario do servidor
                System.out.println("gravando o arquivo:" + nomeDoArquivo);

//                arquivo removo, que vai ser gravado localmente a seguir
                String t = caminhoArquivoServidor + nomeDoArquivo;
                arquivoOrigem = new SmbFile(t, AUTHENTICATION);               
                
//                monta a url local da pasta e do arquivo que sera gravado
                if (tipo == 1) {
                    dirPastaDestino = ("C:\\QIT\\QIT-Agente\\softwares\\" + id + "\\");
                    dirArquivoDestino = ("C:\\QIT\\QIT-Agente\\softwares\\" + id + "\\" + nomeDoArquivo);
                } else if (tipo == 2) {
                    dirPastaDestino = ("C:\\QIT\\QIT-Agente\\scripts\\" + id + "\\");
                    dirArquivoDestino = ("C:\\QIT\\QIT-Agente\\scripts\\" + id + "\\" + nomeDoArquivo);
                }

//                verifica e cria a pasta local para armazenamento de arquivos
                pastaLocal = new File(dirPastaDestino);
                if (pastaLocal.exists() == false) {
                    pastaLocal.mkdir();
                }

//                grava o arquivo
                fileOutputStream = new FileOutputStream(dirArquivoDestino);
//                arquivoOrigem.
                fileInputStream = arquivoOrigem.getInputStream();

                buf = new byte[16 * 1024 * 1024];
                while ((len = fileInputStream.read(buf)) > 0) {
                    fileOutputStream.write(buf, 0, len);
                }
                fileInputStream.close();
                fileOutputStream.close();
            }

            System.out.println("Arquivos gravados localmente!");
            retorno = true;
        } catch (Exception e) {
            System.err.println("Erro ao salvar arquivos:");
            e.printStackTrace();
        }
        return retorno;
    }

}
