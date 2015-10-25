/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import modelo.Inventario;

/**
 *
 * @author eduar_000
 */
public class NewClass {

    public static void main(String args[]) {

        Inventario inventario = null;

        XStream x = new XStream();
        File arquivoXml = new File("C:\\QIT\\QIT-Agente\\inventario.xml");
        inventario = (Inventario) x.fromXML(arquivoXml);
        
        ControleInventario ci = new ControleInventario();
        ci.gravarInventario(inventario);
    }
    
}
