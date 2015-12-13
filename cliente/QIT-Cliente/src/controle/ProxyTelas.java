/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Tela;
import modelo.Usuario;

/**
 *
 * @author eduar_000
 */
public class ProxyTelas implements ITela {

    private ITela telaReal;
    private Usuario usuario;
    private Tela tela;

    public ProxyTelas(ITela telaReal, Usuario usuario, Tela tela) {
        this.telaReal = telaReal;
        this.usuario = usuario;
        this.tela = tela;
    }

    @Override
    public boolean inserir() {
        boolean permissaoUser = new ControleUsuario().verificarPermissao(usuario, tela, "inserir");
        return permissaoUser;
    }

    @Override
    public boolean ler() {
        boolean permissaoUser = new ControleUsuario().verificarPermissao(usuario, tela, "ler");
        return permissaoUser;
    }

    @Override
    public boolean editar() {
        boolean permissaoUser = new ControleUsuario().verificarPermissao(usuario, tela, "editar");
        return permissaoUser;
    }

    @Override
    public boolean inativar() {
        boolean permissaoUser = new ControleUsuario().verificarPermissao(usuario, tela, "inativar");
        return permissaoUser;
    }

    @Override
    public void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.  
    }

    @Override
    public void popularCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelacionado1(String id, String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelacionado2(String id, String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelacionado3(String id, String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRelacionado4(String id, String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
