/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import controle.IModelo;
import modelo.Predio;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eduar_000
 */
public class PredioDAO {

    private Session sessao = null;

    public PredioDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean salvar(Predio predio) {
        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
      
            sessao.saveOrUpdate(predio);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public ArrayList<Predio> listar(IModelo predio) {
        List resultado = null;

        ArrayList<Predio> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Predio p where lower(p.nome) like lower('%" + predio.getNome() + "%') order by p.id desc";

            if (predio.getNome().equals("")) {
                sql = "from Predio p order by p.id desc";
            }

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Predio s = ((Predio) ((Object) o));
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
     * @param predio
     * @return Usuario
     */
    public Predio consultar(Predio predio) {
        List resultado = null;
        Predio predioLocal = new Predio();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Predio p where p.id = " + predio.getId());
            resultado = q.list();

            predioLocal = (Predio) resultado.get(0);

        } catch (HibernateException he) {
            System.err.println("Erro em consultar predio \n" + he);
        } finally {
            sessao.close();
        }
        return predioLocal;
    }
}
