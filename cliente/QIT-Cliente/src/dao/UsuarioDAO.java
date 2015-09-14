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
        ArrayList<Usuario> listaUsuarios = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Usuario where id = " + usuario.getId());
            resultado = q.list();

            for (Object o : resultado) {
                Usuario s = (Usuario) o;
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
     * @return 
     */
    public boolean consultar(Usuario usuario) {
        List resultado = null;
        boolean retorno = false;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Usuario where id = " + usuario.getId());
            resultado = q.list();

            for (Object o : resultado) {
                usuario = (Usuario) o;
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return retorno;
    }
}
