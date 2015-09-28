/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JOptionPane;
import modelo.Tela;
import modelo.Usuario;
import visao.ITelas;

/**
 *
 * @author eduar_000
 */
public class ProxyTelas implements ITelas {

    private ITelas telaReal;
    private Usuario usuario;
    private Tela tela;

    public ProxyTelas(ITelas telaReal, Usuario usuario, Tela tela) {
        this.telaReal = telaReal;
        this.usuario = usuario;
        this.tela = tela;
    }

    @Override
    public boolean inserir() {
        return false;
    }

    @Override
    public boolean ler() {
        boolean permissaoUser = new ControleUsuario().verificarPermissao(usuario, tela, "ler");
        
        return permissaoUser;
    }

    @Override
    public boolean editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inativar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
