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
import modelo.ExecucaoScript;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tiago
 */
public class ExecutarScriptDAO {

    private Session sessao = null;

    public ExecutarScriptDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean salvar(ExecucaoScript es) {
        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.saveOrUpdate(es);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public ExecucaoScript consultar(ExecucaoScript es) {
        List resultado = null;
        ExecucaoScript objLocal = new ExecucaoScript();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from ExecucaoScript e "
                    + "inner join e.script as script "
                    + "inner join e.maquinasExecutarScripts as mes "
                    + "inner join mes.maquina as m "
                    + "where e.id = " + es.getId());
            resultado = q.list();

            for (Object o : resultado) {
                objLocal = ((ExecucaoScript) ((Object[]) o)[0]);
            }

        } catch (HibernateException he) {
            System.err.println("Erro em consultar predio \n" + he);
        } finally {
            sessao.close();
        }
        return objLocal;
    }

    public ArrayList<ExecucaoScript> listar(IModelo obj) {
        List resultado = null;

        ArrayList<ExecucaoScript> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from ExecucaoScript t"
                    + " order by t.id desc";                    

            org.hibernate.Query q = sessao.createQuery(sql).setMaxResults(100);
            resultado = q.list();

            for (Object o : resultado) {
                ExecucaoScript t = ((ExecucaoScript) ((Object) o));
                lista.add(t);
            }

        } catch (Exception e) {
            System.out.println("Erro ao realizar a consulta" + e);
            e.printStackTrace();
        } finally {
            sessao.close();
        }
        return lista;
    }

}
