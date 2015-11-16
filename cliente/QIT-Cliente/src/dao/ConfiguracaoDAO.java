/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import java.util.List;
import modelo.Configuracao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tiago
 */
public class ConfiguracaoDAO {

    private Session sessao = null;

    public boolean salvar(Configuracao configuracao) {
        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.saveOrUpdate(configuracao);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("erro ao salvar configuracao " + he);
            return false;
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public ConfiguracaoDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public Configuracao consultar(Configuracao configuracao) {
        List resultado = null;
        Configuracao confLocal = new Configuracao();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Configuracao c where id ="+ configuracao.getId());
            resultado = q.list();

            confLocal = (Configuracao) resultado.get(0);

        } catch (HibernateException he) {
            System.err.println("Erro em consultar configuracao \n" + he);
        } finally {
            sessao.close();
        }
        return confLocal;
    }

}
