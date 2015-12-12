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
import java.util.List;
import modelo.Maquina;
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
public class MaquinaDAO {

    private Session sessao = null;

    public MaquinaDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public ArrayList<Maquina> listar(IModelo modelo) {
        List resultado = null;

        ArrayList<Maquina> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Maquina g where lower(g.host) like lower('%" + modelo.getNome() + "%') order by g.id desc";

            if (modelo.getNome().equals("")) {
                sql = "from Maquina g order by g.id desc";
            }

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Maquina s = ((Maquina) ((Object) o));
                lista.add(s);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return lista;
    }

    public ArrayList<Maquina> listarMaquinas(Maquina maquina) {
        List resultado = null;

        ArrayList<Maquina> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Maquina g inner join g.sala where g.sala.id =" + maquina.getSala().getId() + " order by g.id desc";

            if (maquina.getSala().getId() == 0) {
                sql = "from Maquina g inner join g.sala  order by g.id desc";
            }
            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Maquina s = ((Maquina) ((Object[]) o)[0]);
                lista.add(s);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return lista;
    }

    public ArrayList<Maquina> listarMaquinas2(Maquina maquina) {

//        Query query = sessao.createQuery("from Auditoria");
//        List listaUs = query.list();
//        Criteria ct = sessao.createCriteria(Maquina.class);
//        //ct.add(Restrictions.gt("id", (4)));
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
//        String myDate = "17-04-2011";
//        // Create date 17-04-2011 - 00h00
//        ct.add();
//                // -> We take the 1st date and add it 1 day in millisecond thanks to a useful and not so known class
//        ct.add(Expression.ge("dt", minDate)); //maior que minDate
//        ct.add(Expression.le("dt", maxDate)); //maior que maxDate
////        Conjunction and = Restrictions.conjunction();
////        // The order date must be >= 17-04-2011 - 00h00
////        and.add(Restrictions.ge("dt_criacao", minDate));
////        // And the order date must be < 18-04-2011 - 00h00
////        and.add(Restrictions.lt("dt_criacao ", maxDate));
////        ct.add(and);
//
//        listaUs = ct.list();
//
//        return listaUs;
        return null;
    }

    public Maquina consultar(Maquina m) {
        List resultado = null;
        Maquina maquinaLocal = new Maquina();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Maquina m inner join m.sala where m.id = " + m.getId());
            resultado = q.list();

            for (Object o : resultado) {
                Maquina s = ((Maquina) ((Object[]) o)[0]);
                maquinaLocal = s;
            }

        } catch (HibernateException he) {
            System.err.println("Erro em consultar maquiba \n" + he);
        } finally {
            sessao.close();
        }
        return maquinaLocal;
    }

    public boolean salvar(Maquina maquina) {

        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.saveOrUpdate(maquina);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
            System.out.println("erro ao salvar maquina " + he);
        } finally {
            sessao.close();
        }
        return retorno;
    }
}
