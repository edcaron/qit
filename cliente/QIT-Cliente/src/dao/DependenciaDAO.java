/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import modelo.Dependencia;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eduar_000
 */
public class DependenciaDAO {

    Session sessao = null;

    public DependenciaDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean salvar(Dependencia obj) {
        boolean retorno = false;
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();

            sessao.saveOrUpdate(obj);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            t.rollback();
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public boolean apagar(Dependencia obj) {
        boolean retorno = false;
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();

            sessao.delete(sessao.get(obj.getClass(), obj.getId()));
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            t.rollback();
        } finally {
            sessao.close();
        }
        return retorno;
    }

}
