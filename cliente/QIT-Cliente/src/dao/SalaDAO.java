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
import modelo.Sala;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eduar_000
 */
public class SalaDAO {

    Session sessao = null;

    public SalaDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean salvar(Sala s) {
        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.saveOrUpdate(s);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public ArrayList<Sala> listar(IModelo sala) {
        List resultado = null;

        ArrayList<Sala> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Sala s inner join s.predio p where lower(s.nome) like lower('%" + sala.getNome() + "%') order by s.id desc";

            if (sala.getNome().equals("")) {
                sql = "from Sala s inner join s.predio order by s.id desc";
            }

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Sala s = ((Sala) ((Object[]) o)[0]);
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
     * @param sala
     * @return Usuario
     */
    public Sala consultar(Sala sala) {
        List resultado = null;
        Sala salaLocal = new Sala();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
          //  System.out.println("id:" + sala.getId());
            org.hibernate.Query q = sessao.createQuery("from Sala s inner join s.predio where s.id = " + sala.getId());
            resultado = q.list();

            salaLocal = ((Sala) ((Object[]) resultado.get(0))[0]);

        } catch (HibernateException he) {
            System.err.println("Erro em consultar sala \n" + he);
        } finally {
            sessao.close();
        }
        return salaLocal;
    }

}
