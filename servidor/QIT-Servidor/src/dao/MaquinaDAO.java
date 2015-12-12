/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Maquina;
import controle.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eduar_000
 */
public class MaquinaDAO extends DAOPadrao {

    Session sessao = null;

    public MaquinaDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public Maquina procurarDuplicado(Maquina maquina) {
        List resultados = null;        
        Maquina maquinaLocal = maquina;
        String sql = "SELECT procura_duplicado(:tabela,:col1,:valor1,:col2,:valor2)";

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query exQuery = sessao.createSQLQuery(sql);
            exQuery.setParameter("tabela", "maquina");
            exQuery.setParameter("col1", "host");
            exQuery.setParameter("valor1", maquina.getHost());
            exQuery.setParameter("col2", "so");
            exQuery.setParameter("valor2", maquina.getSo());
            resultados = exQuery.list();

        } catch (Exception e) {
            System.err.println("" + e);
        } finally {
            sessao.close();
        }

        //verifica se o retorno da procedure não é 0 e não está nulo
        if (!resultados.get(0).equals(0)) {
            //setar o id do objeto com base no retorno da procedure
            maquinaLocal.setId((int) resultados.get(0));            
        }
        return maquinaLocal;
    }

    public Maquina consultar(Maquina maquina) {
        List resultado = null;
        Maquina maquinaLocal = new Maquina();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Maquina m left join m.particaos left join m.placaRedes left join m.softwaresMaquinas as sm left join sm.software where m.id = " + maquina.getId());
            resultado = q.list();

            for (Object o : resultado) {
                maquinaLocal = ((Maquina) ((Object[]) o)[0]);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return maquinaLocal;
    }

    public ArrayList<Maquina> listar(String criterio) {
        List resultado = null;

        ArrayList<Maquina> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Maquina  "
                    + "where 1=1 "
                    + criterio
                    + " order by id desc";

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
}
