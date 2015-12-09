/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JTable;

/**
 *
 * @author eduar_000
 */
public interface IControle {
    
    public Object[][] popularTabela(JTable tabela, IModelo modelo, boolean isModal);        
}
