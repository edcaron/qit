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
import java.util.Date;
import modelo.Permissao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eduar_000
 */
public class PermissaoDAO {

    private Session sessao = null;

    public PermissaoDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public ArrayList<Permissao> consultar(Usuario usuario, int id_tela) {
        List resultadoBanco = null;
        ArrayList<Permissao> listaPermissoes = null;
        String query = "";

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            if (usuario.getTipoPermissao() == 'I') {
                query = "from Permissao p, Usuariou, Tela t WHERE  u.id = " + usuario.getId();
            } else if (usuario.getTipoPermissao() == 'G') {
                query = "from Permissao p, Grupo g, Tela t WHERE g.id = " + usuario.getGrupo().getId();
            }

            System.out.println("Query = " + query);

            org.hibernate.Query q = sessao.createQuery(query);
            resultadoBanco = q.list();

            for (Object o : resultadoBanco) {
                Permissao s = ((Permissao) ((Object[]) o)[0]);
            }

        } catch (HibernateException he) {

            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return listaPermissoes;
    }

    public boolean salvar(Permissao permissao) {
        boolean retorno = false;
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();

            sessao.saveOrUpdate(permissao);
            t.commit();

            retorno = true;
        } catch (HibernateException he) {
            System.out.println("deu pau" + he);
            he.printStackTrace();
            t.rollback();
            return false;
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public ArrayList<Permissao> listar(Date datainicial, Date datafinal, String tabela, char operacao, Usuario usuario) {
        List resultado = null;

        ArrayList<Permissao> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Permissao p where lower(p.tablea) like lower('%" + tabela + "%') "
                    + "and lower(p.operacao) like lower('%" + operacao + "%') "
                    + "and p.dt >" + datainicial + ""
                    + "and p.dt <" + datafinal + ""
                    + " order by p.id ";

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Permissao s = ((Permissao) ((Object) o));
                lista.add(s);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return lista;
    }

    public ArrayList<Permissao> listar(Usuario usuario) {

        List resultado = null;

        ArrayList<Permissao> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Permissao p inner join p.usuarioByIdUsuario as u inner join p.tela where u.id = " + usuario.getId() + " order by p.id ";

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Permissao s = ((Permissao) ((Object[]) o)[0]);
                lista.add(s);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return lista;

    }

}
