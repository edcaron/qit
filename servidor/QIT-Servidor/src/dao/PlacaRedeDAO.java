/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.PlacaRede;
import controle.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eduar_000
 */
public class PlacaRedeDAO extends DAOPadrao{

    Session sessao = null;

    public PlacaRedeDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public PlacaRede procurarDuplicado(PlacaRede obj) {
        List resultados = null;
        boolean retorno = false;
        PlacaRede objLocal = obj;
        String sql = "SELECT procura_duplicado(:tabela,:col1,:valor1,:col2,:valor2)";
        
        try {
            Query exQuery = sessao.createSQLQuery(sql);
            exQuery.setParameter("tabela", "placa_rede");
            exQuery.setParameter("col1", "ipv4");
            exQuery.setParameter("valor1", "" +obj.getIpv4());
            exQuery.setParameter("col2", "id_maquina");
            exQuery.setParameter("valor2", "" +obj.getMaquina().getId());
            resultados = exQuery.list();

        } catch (Exception e) {
            System.err.println("" + e);
        }

        //verifica se o retorno da procedure não é 0 e não está nulo
        if (!resultados.get(0).equals(0)) {
            //setar o id do objeto com base no retorno da procedure
            objLocal.setId((int) resultados.get(0));
            retorno = true;
        }
        return objLocal;
    }

    public PlacaRede consultar(PlacaRede obj) {
        List resultado = null;
        PlacaRede objLocal = new PlacaRede();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();            
            org.hibernate.Query q = sessao.createQuery("from PlacaRede pr where pr.id" + obj.getId());            
            resultado = q.list();

            for (Object o : resultado) {
                objLocal = ((PlacaRede) ((Object[]) o)[0]);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return objLocal;
    }
}
