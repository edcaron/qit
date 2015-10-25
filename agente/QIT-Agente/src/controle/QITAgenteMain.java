package controle;

import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import modelo.Inventario;

public class QITAgenteMain {

    public static void main(String[] args) throws FileNotFoundException {

        geraInventario();
    }

    private static void geraInventario() {
        
//        capturar dados e escrever em xml
        XStream xstream = new XStream();
        try {
            OutputStream output = new FileOutputStream("C:\\QIT\\QIT-Agente\\inventario.xml");
            Inventario inventario = new ControleInventario().fazerInventario();
            xstream.toXML(inventario, output);
        } catch (IOException e) {
            System.err.println("" + e);
        }
        
//        enviar dados para o servidor
        
    }

}
