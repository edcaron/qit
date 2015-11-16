/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.PermissaoDAO;
import modelo.Permissao;

/**
 *
 * @author Tiago
 */
public class ControlePermissao implements IModelo{

    private PermissaoDAO dao;

    public ControlePermissao() {
        this.dao = new PermissaoDAO();
    }

    public Permissao consultar(Permissao permissao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean salvar(Permissao permissao) {
        return dao.salvar(permissao);
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
