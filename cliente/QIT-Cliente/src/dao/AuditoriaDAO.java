/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import controle.IModelo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Auditoria;
import modelo.Sala;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Tiago
 */
public class AuditoriaDAO {

    private Session sessao = null;

    public AuditoriaDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public ArrayList<Auditoria> listar(String parametros) {
        List resultado = null;

        ArrayList<Auditoria> lista = new ArrayList<>();
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();

            String sql = "from Auditoria"
                    + " where usuario.id != 0 "
                    + parametros
                    + " order by dt desc";

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Auditoria s = (Auditoria) ((Object) o);
                lista.add(s);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
            t.rollback();
        } finally {
            sessao.close();
        }

        return lista;
    }

    public Auditoria consultar(Auditoria obj) {
        List resultado = null;
        Auditoria objLocal = new Auditoria();
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Auditoria where id = " + obj.getId());
            resultado = q.list();

            for (Object resultado1 : resultado) {
                objLocal = (Auditoria) resultado1;
            }            

        } catch (HibernateException he) {
            t.rollback();
            System.err.println("Erro em consultar  \n" + he);
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return objLocal;
    }
}
