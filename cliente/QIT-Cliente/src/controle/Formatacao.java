/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author eduar_000
 */
public class Formatacao {

    /**
     * Funcao para limpar o texto dos campos de entrada dos usuarios
     *
     * @param container com os componentes
     */
    public static void limparCampos(Container container) {
        Component c[] = container.getComponents();
        try {
            for (int i = 0; i < c.length; i++) {

                if (c[i] instanceof QITJFormattedTextField) {
                    QITJFormattedTextField field = (QITJFormattedTextField) c[i];
                    field.setValue(null);
                    field.setText("");
                    field.setIsValid(true);
                } else if (c[i] instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) c[i];
                    field.setValue(null);
                    field.setText("");
                } else if (c[i] instanceof JTextField) {
                    JTextField field = (JTextField) c[i];
                    field.setText("");
                } else if (c[i] instanceof JScrollPane) {
                    ((JTextArea) ((JScrollPane) c[i]).getViewport().getComponent(0)).setText("");
                } else if (c[i] instanceof JComboBox) {
                    JComboBox cb = (JComboBox) c[i];
                    cb.setSelectedIndex(0);
                } else if (c[i] instanceof JCheckBox) {
                    JCheckBox ckb = (JCheckBox) c[i];
                    ckb.setSelected(true);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro em limparCampos: " + e);
        }

    }
}
