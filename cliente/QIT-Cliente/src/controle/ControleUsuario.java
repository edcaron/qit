/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.UsuarioDAO;
import java.util.Iterator;
import java.util.Set;
import modelo.Permissao;
import modelo.Tela;
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

    public boolean verificarPermissao(Usuario usuario, Tela tela, String operacao) {
        boolean temPermissao = false;
        Set lista = null;

        if (usuario.getTipoPermissao() == 'I') {
            lista = usuario.getPermissaosForIdUsuario();
        } else {
            lista = usuario.getGrupo().getPermissaos();
        }

        Iterator<Permissao> it = lista.iterator();

        while (it.hasNext()) {
            Permissao permissao = (Permissao) it.next();

            if (permissao.getTela().getId() == tela.getId()) {
                switch (operacao) {
                    case "ler":
                        if (permissao.isLer()) {
                            temPermissao = true;
                        }
                        break;
                    case "editar":
                        if (permissao.isEditar()) {
                            temPermissao = true;
                        }
                        break;
                    case "inserir":
                        if (permissao.isInserir()) {
                            temPermissao = true;
                        }
                        break;
                    case "inativar":
                        if (permissao.isInativar()) {
                            temPermissao = true;
                        }
                        break;
                }
            }
        }

        return temPermissao;
    }

}
