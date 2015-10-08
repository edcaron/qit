/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import controle.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eduar_000
 */
public class UsuarioDAO {

    Session sessao = null;

    public UsuarioDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean autenticar(Usuario usuario) {
        List resultados = null;
        boolean retorno = false;

        Query exQuery = sessao.createSQLQuery("SELECT autenticar(:login_p,:senha_p)");
        exQuery.setParameter("login_p", usuario.getLogin());
        exQuery.setParameter("senha_p", usuario.getSenha());
        resultados = exQuery.list();

        //verifica se o retorno da procedure não é 0 e não está nulo
        if (!resultados.get(0).equals(0)) {
            //setar o id do usuário com base no retorno da procedure
            usuario.setId((int) resultados.get(0));
            retorno = true;
        }

        return retorno;
    }

    public ArrayList<Usuario> listar(Usuario usuario) {
        List resultado = null;

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Usuario u, Grupo g where u.id = " + usuario.getId());
            resultado = q.list();

            for (Object o : resultado) {
                Usuario s = ((Usuario) ((Object[]) o)[0]);
                listaUsuarios.add(s);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return listaUsuarios;
    }

    /**
     *
     * @param usuario
     * @return Usuario
     */
    public Usuario consultar(Usuario usuario) {
        List resultado = null;
        Usuario user_local = new Usuario();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            System.out.println("id do user:" + usuario.getId());
            org.hibernate.Query q = sessao.createQuery("from Usuario u inner join u.grupo inner join u.permissaosForIdUsuario as p inner join p.tela where u.id = " + usuario.getId());
            resultado = q.list();

            for (Object o : resultado) {
                user_local = ((Usuario) ((Object[]) o)[0]);
            }

            usuario = user_local;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return user_local;
    }
}
