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
public class ControleLogin {

    public static boolean logar(Usuario usuario) {
        boolean ret = false;
        UsuarioDAO ud = new UsuarioDAO();

        ret = ud.autenticar(usuario);

        return ret;
    }
}
