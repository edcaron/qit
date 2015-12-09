/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import controle.IModelo;
import java.util.ArrayList;
import java.util.List;
import modelo.Script;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tiago
 */
public class ScriptDAO {

    private Session sessao = null;

    public ScriptDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean salvar(Script predio) {
        boolean retorno = false;
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();

            sessao.saveOrUpdate(predio);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("erro foi " + he);
            t.rollback();
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public ArrayList<Script> listar(IModelo modelo) {
        List resultado = null;

        ArrayList<Script> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Script s inner join s.tipo where lower(s.nome) like lower('%" + modelo.getNome() + "%') order by s.id desc";

            if (modelo.getNome().equals("")) {
                sql = "from Script s inner join s.tipo order by s.id desc";
            }

            org.hibernate.Query q = sessao.createQuery(sql);

            resultado = q.list();

            for (Object o : resultado) {

                Script s = new Script();
                s = ((Script) ((Object[]) o)[0]);

                lista.add(s);

            }

        } catch (HibernateException he) {

            he.printStackTrace();

        } finally {
            sessao.close();
        }

        return lista;
    }

    public Script consultar(Script script) {
        List resultado = null;
        Script obj_local = new Script();

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Script s inner join s.tipo as t left join s.dependencias as d where s.id = " + script.getId());

            resultado = q.list();

            for (Object o : resultado) {
                obj_local = ((Script) ((Object[]) o)[0]);
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return obj_local;
    }

}
