/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.UsuarioDAO;
import modelo.Usuario;

/**
 *
 * @author eduar_000
 */
public class ControleUsuario {

    UsuarioDAO udao;

    public ControleUsuario() {
        udao = new UsuarioDAO();
    }

    public boolean logar(Usuario usuario) {
        boolean ret = false;
        UsuarioDAO ud = new UsuarioDAO();

        ret = ud.autenticar(usuario);

        return ret;
    }

    public Usuario consultar(Usuario usuario) {
        Usuario usuarioLocal = new Usuario();
        try {
            usuarioLocal = udao.consultar(usuario);
        } catch (Exception e) {
            System.err.println("" + e);
            
        }
        return usuarioLocal;
    }
        
}
