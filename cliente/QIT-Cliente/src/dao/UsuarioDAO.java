/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import controle.HibernateUtil;
import controle.IModelo;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
//listar usuarios 

    public ArrayList<Usuario> listar(IModelo usuario) {
        List resultado = null;

        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Usuario u where lower(u.nome) like lower('%" + usuario.getNome() + "%') order by u.id desc";

            if (usuario.getNome().equals("")) {
                sql = "from Usuario u inner join u.grupo order by u.id desc";
            }
            System.out.println("a query foi " + sql);
            org.hibernate.Query q = sessao.createQuery(sql);
            System.out.println("da erro nessa linha");
            resultado = q.list();

            for (Object o : resultado) {
                System.out.println("entrei no for");
                Usuario s = ((Usuario) ((Object[]) o)[0]);
                System.out.println("passei daki");
                lista.add(s);
                System.out.println("pasei no for");
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

        return lista;
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
                org.hibernate.Query q = sessao.createQuery("from Usuario u inner join u.grupo where u.id = " + usuario.getId());
            resultado = q.list();

            for (Object o : resultado) {
                System.out.println("no forzim");
                user_local = ((Usuario) ((Object[]) o)[0]);

            }

            usuario = user_local;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return user_local;
    }

    public boolean salvar(Usuario usuario) {
        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            System.out.println(usuario.getDtCriacao());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getSenha());
            System.out.println(usuario.getNome());
            sessao.saveOrUpdate(usuario);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("erro" + he);
        } finally {
            sessao.close();
        }
        return retorno;
    }
}
