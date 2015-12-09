/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import controle.IModelo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eduar_000
 */
public abstract class DAOPadrao {

    public boolean salvar(IModelo m) {
        boolean retorno = false;
        Session sessao = null;
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();
            sessao.saveOrUpdate(m);
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
    
    public boolean merge(IModelo m) {
        boolean retorno = false;
        Session sessao = null;
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();
            sessao.merge(m);
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
