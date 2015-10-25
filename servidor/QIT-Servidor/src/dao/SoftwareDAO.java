/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Software;
import controle.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eduar_000
 */
public class SoftwareDAO extends DAOPadrao{

    Session sessao = null;

    public SoftwareDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public Software procurarDuplicado(Software obj) {
        List resultados = null;
        boolean retorno = false;
        Software objLocal = obj;
        String sql = "SELECT procura_duplicado(:tabela,:col1,:valor1,:col2,:valor2)";

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query exQuery = sessao.createSQLQuery(sql);            
            exQuery.setParameter("tabela", "software");
            exQuery.setParameter("col1", "nome");
            exQuery.setParameter("valor1", obj.getNome());            
            exQuery.setParameter("col2", "versao");
            exQuery.setParameter("valor2", "" + obj.getVersao());                       

            resultados = exQuery.list();

            //verifica se o retorno da procedure não é 0 e não está nulo
            if (!resultados.get(0).equals(0)) {
                //setar o id do objeto com base no retorno da procedure
                objLocal.setId((int) resultados.get(0));
                retorno = true;
            }

        } catch (Exception e) {
            System.err.println("" + e);
        } finally {
            sessao.close();
        }

        return objLocal;
    }

    public Software consultar(Software obj) {
        List resultado = null;
        Software objLocal = new Software();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Software s where s.id = " + obj.getId());
            resultado = q.list();

            System.out.println("entro");
            for (Object o : resultado) {
                objLocal = ((Software) ((Object[]) o)[0]);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return objLocal;
    }
}
