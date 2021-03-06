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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

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
            String sql = "from Usuario u inner join u.grupo where lower(u.nome) like lower('%" + usuario.getNome() + "%') order by u.id desc";

            if (usuario.getNome().equals("")) {
                sql = "from Usuario u inner join u.grupo order by u.id desc";
            }

            org.hibernate.Query q = sessao.createQuery(sql);

            resultado = q.list();

            for (Object o : resultado) {

                Usuario s = ((Usuario) ((Object[]) o)[0]);

                lista.add(s);

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
            org.hibernate.Query q = sessao.createQuery("from Usuario u inner join u.grupo where u.id = " + usuario.getId());

            //org.hibernate.Query q = sessao.createQuery("from Usuario u inner join u.grupo where u.id = " + usuario.getId());
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

    public Usuario consultarPesquisa(Usuario usuario) {
        List resultado = null;
        Usuario user_local = new Usuario();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            // System.out.println("id do user:" + usuario.getId());
            org.hibernate.Query q = sessao.createQuery("from Usuario u inner join u.grupo where u.id = " + usuario.getId());
            resultado = q.list();
            for (Object o : resultado) {

                user_local = ((Usuario) ((Object[]) o)[0]);

            }

            usuario = user_local;
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return user_local;
    }

    public boolean salvar(Usuario usuario) {
        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

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

    public List listaTodos(Date minDate, Date maxDate) throws ParseException {
        Query query = sessao.createQuery("from Usuario");
        List listaUs = query.list();

        Criteria ct = sessao.createCriteria(Usuario.class);
        //ct.add(Restrictions.gt("id", (4)));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
        String myDate = "17-04-2011";
        // Create date 17-04-2011 - 00h00

    // Create date 18-04-2011 - 00h00 
        // -> We take the 1st date and add it 1 day in millisecond thanks to a useful and not so known class
        ct.add(Expression.ge("dtCriacao", minDate)); //maior que minDate
        ct.add(Expression.le("dtCriacao", maxDate)); //menor que maxDate


        listaUs = ct.list();

        return listaUs;
    }

}
