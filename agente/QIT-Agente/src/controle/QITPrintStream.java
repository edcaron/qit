/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author eduar_000
 */
public class QITPrintStream extends PrintStream {

    public QITPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public void print(String s) {
        super.print(controle.Util.getCurrentTimestamp() +" " + s);
    }

}
