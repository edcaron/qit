/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.SoftwaresMaquina;
import controle.HibernateUtil;
import modelo.Maquina;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eduar_000
 */
public class SoftwareMaquinaDAO extends DAOPadrao {

    Session sessao = null;

    public SoftwareMaquinaDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public SoftwaresMaquina procurarDuplicado(SoftwaresMaquina obj) {
        List resultados = null;
        boolean retorno = false;
        SoftwaresMaquina objLocal = obj;
        String sql = "SELECT procura_duplicado(:tabela,:col1,:valor1,:col2,:valor2)";

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query exQuery = sessao.createSQLQuery(sql);
            exQuery.setParameter("tabela", "softwares_maquina");
            exQuery.setParameter("col1", "id_maquina");
            exQuery.setParameter("valor1", "" + obj.getMaquina().getId());
            exQuery.setParameter("col2", "id_software");
            exQuery.setParameter("valor2", "" + obj.getSoftware().getId());
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

    public boolean inativarSoftwaresMaquina(Maquina obj) {
        boolean retorno = false;
        String sql = "UPDATE softwares_maquina set instalado=false where id_maquina = :id";

        Transaction t = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query exQuery = sessao.createSQLQuery(sql);
            exQuery.setParameter("id", obj.getId());
            t = sessao.beginTransaction();
            exQuery.executeUpdate();
            
            t.commit();
            retorno = true;
            
        } catch (Exception e) {
            System.err.println("" + e);
        } finally {
            sessao.close();            
        }
        return retorno;
    }

    public SoftwaresMaquina consultar(SoftwaresMaquina obj) {
        List resultado = null;
        SoftwaresMaquina objLocal = new SoftwaresMaquina();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from SoftwareMaquina sm where sm.id = " + obj.getId());
            resultado = q.list();

            System.out.println("entro");
            for (Object o : resultado) {
                objLocal = ((SoftwaresMaquina) ((Object[]) o)[0]);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return objLocal;
    }
}
