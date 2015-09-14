/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import modelo.Permissao;
import modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author eduar_000
 */
public class PermissaoDAO {

    public PermissaoDAO() {
    }

    public ArrayList<Permissao> consultar(Usuario usuario, int id_tela) {
        List resultadoBanco = null;
        ArrayList<Permissao> listaPermissoes = null;
        String query = "";
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

//            if (usuario.getTipoPermissao() == 'I') {
                query = "from Permissao where id_usuario = " + usuario.getId();
//            } else if (usuario.getTipoPermissao() == 'G') {
//                query = "from Permissao where id_grupo = " + usuario.getGrupo().getId();
//            }

            org.hibernate.Query q = sessao.createQuery(query);
            resultadoBanco = q.list();

            for (Object o : resultadoBanco) {               
                Permissao s = (Permissao) o;
                System.out.println("id: " + s.getId() + " ");
                System.out.println("idtela " + s.getIdTela());
                System.out.println("ler " + s.getLer());
                System.out.println("editar " + s.isEditar());
                System.out.println("inativar " + s.isInativar());
                System.out.println("inserir " + s.isInserir());
                System.out.println("inserir " + s.getGrupo().getId());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return listaPermissoes;
    }

}
