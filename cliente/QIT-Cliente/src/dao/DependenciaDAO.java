/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import java.util.List;
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
            Dependencia d = new Dependencia();
            String parametros = " and nome = '" + obj.getNome() + "' and script.id = "+obj.getScript().getId();                                            
            d = new DependenciaDAO().consultar(parametros);
            
//            verificar a existencia no bd de uma dependencia com o mesmo nome no script atual, para que não fique duplicada
            if (d.getId() != 0) {
                obj.setId(d.getId());               
            }
            
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

    public Dependencia consultar(String parametros) {
        List resultado = null;
        Dependencia objLocal = new Dependencia();        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Dependencia "
                    + "where 1=1 "
                    + parametros
                    + " ");
            resultado = q.list();

            for (Object resultado1 : resultado) {
                objLocal = (Dependencia) resultado1;
            }            

        } catch (HibernateException he) {
            System.err.println("Erro em consultar \n" + he);            
        } finally {
            sessao.close();
        }
        return objLocal;
    }

}
