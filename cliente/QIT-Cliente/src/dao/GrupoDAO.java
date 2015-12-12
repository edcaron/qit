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
import modelo.Grupo;
import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tiago
 */
public class GrupoDAO {

    private Session sessao = null;

    public GrupoDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean salvar(Grupo grupo) {
        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.saveOrUpdate(grupo);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            System.out.println("deu pau" + he);
            he.printStackTrace();
            return false;
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public ArrayList<Grupo> listar(IModelo grupo) {
        List resultado = null;

        ArrayList<Grupo> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Grupo g "
                    + "where lower(g.nome) like lower('%" + grupo.getNome() + "%') "
                    + "order by g.id desc";

            if (grupo.getNome().equals("")) {
                sql = "from Grupo g order by g.id desc";
            }

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Grupo s = ((Grupo) ((Object) o));
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
    public Grupo consultar(Grupo grupo) {
        List resultado = null;
        Grupo grupoLocal = new Grupo();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Grupo g where g.id = " + grupo.getId());
            resultado = q.list();

            grupoLocal = (Grupo) resultado.get(0);

        } catch (HibernateException he) {
            System.err.println("Erro em consultar grupo \n" + he);
        } finally {
            sessao.close();
        }
        return grupoLocal;
    }

    public List listaTodos2() {
 List resultado = null;

        ArrayList<Grupo> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Grupo g order by g.id desc";
            

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Grupo s = ((Grupo) ((Object) o));
                lista.add(s);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return lista;
    }
    

    public List listaTodos() {

        // Query query = sessao.createQuery("from Grupo"); 
        Criteria ct = sessao.createCriteria(Grupo.class);
        ct = sessao.createCriteria(Usuario.class);
        // exemplo:
//                createCriteria(Veiculo.class)
//                .add(Restrictions.like("placa", letras, MatchMode.START))
//                .createCriteria("pessoa")
//                .add(Restrictions.between("idade", first, last))
//                .list();

        //ct.add(Restrictions.gt("id", (4)));
        List listaUs = ct.list();
        List teste = listaUs;
        Grupo g = new Grupo();
        for (int i = 0; i < listaUs.size(); i++) {
            g = ((Grupo) listaUs.get(i));

        }
        return listaUs;
    }
}
