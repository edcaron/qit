/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DependenciaDAO;
import javax.swing.JTable;
import modelo.Dependencia;

/**
 *
 * @author eduar_000
 */
public class ControleDependência implements IControle {

    DependenciaDAO dao;

    public ControleDependência() {
        dao = new DependenciaDAO();
    }

    public boolean apagar(Dependencia obj) {
        return dao.apagar(obj);
    }
    
    public boolean salvar(Dependencia obj) {
        return dao.salvar(obj);
    }

    @Override
    public Object[][] popularTabela(JTable tabela, IModelo modelo, boolean isModal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
