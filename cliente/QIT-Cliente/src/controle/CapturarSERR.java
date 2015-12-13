/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author eduar_000
 */
public class CapturarSERR {

    public CapturarSERR() {

        try {

            String data = Util.getCurrentWindowsFormatDate();

            OutputStream output = new FileOutputStream("C:\\QIT\\QIT-Cliente\\errorLog" + data + ".txt", true);

            PrintStream out = new QITPrintStream(output);
//Captura o system.out
//            System.setOut(out);

//Captura o system.err
            System.setErr(out);

        } catch (Exception e) {
            System.out.println("Erro em CapturarSOUT: " + e);
        }
    }
}
