/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import modelo.Maquina;
import modelo.Software;
import modelo.SoftwaresMaquina;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tiago
 */
public class SoftwareDAO {

    private Session sessao = null;

    public SoftwareDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public ArrayList<SoftwaresMaquina> listarSoftwares(Maquina m, String nome) {
        List resultado = null;

        ArrayList<SoftwaresMaquina> lista = new ArrayList<>();
        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            t = sessao.beginTransaction();
            //String sql = "from Software s where s.id =" + m.getId() + " order by s.id desc";
            String sql = "";
            if (nome.equals("")) {
                sql = "from SoftwaresMaquina sm inner join sm.software where sm.maquina.id =" + m.getId() + " order by sm.id desc";
            } else {
                sql = "from SoftwaresMaquina sm inner join sm.software where sm.maquina.id =" + m.getId() + " and lower(sm.software.nome) like ('%" + nome.toLowerCase() + "%')  order by sm.id desc";
            }
            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                SoftwaresMaquina s = ((SoftwaresMaquina) ((Object[]) o)[0]);
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
    
    public Software consultar(Software software) {
        List resultado = null;

        ArrayList<Software> lista = new ArrayList<>();
        Software s = new Software();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            //String sql = "from Software s where s.id =" + m.getId() + " order by s.id desc";
            String sql = "from Software s inner join s.softwaresMaquinas where s.id =" + software.getId() + " order by s.id desc";

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                s = ((Software) ((Object[]) o)[0]);
                lista.add(s);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return s;
    }

}
