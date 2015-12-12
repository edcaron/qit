/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author eduar_000
 */
public class UtilArquivos {

    /**
     * tipo - 1 softwares, 2 scripts id - id do script ou do software
     *
     * @param texto
     * @param tipo
     * @param idScriptOuSoftware
     * @return
     */
    public static boolean stringToFile(String texto, int tipo, int idScriptOuSoftware) {
        File arquivo = null;
        FileOutputStream fos = null;
        try {
            if (tipo == 1) {
                arquivo = new File("C:\\QIT\\QIT-Agente\\softwares\\" + idScriptOuSoftware + "\\Setup" + idScriptOuSoftware + ".bat");
            } else if (tipo == 2) {
                arquivo = new File("C:\\QIT\\QIT-Agente\\scripts\\" + idScriptOuSoftware + "\\Setup" + idScriptOuSoftware + ".bat");
            }
                        
            fos = new FileOutputStream(arquivo);
            fos.write(texto.getBytes());
            fos.close();
            
            System.out.println("String to file deu certo");
        } catch (Exception e) {
            System.err.println("erro em stringToFile" + e);
            e.printStackTrace();
        }     
        return true;
    }

}
