/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class AuditoriaDAO {

    private Session sessao = null;

    public boolean chamarFuncaoLimpaAuditoria() {
        List resultados = null;
        boolean retorno = false;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
        
            Query exQuery = sessao.createSQLQuery("SELECT * from limpa_auditoria()");
            resultados = exQuery.list();

            //verifica se o retorno da procedure não é 0 e não está nulo
            if (!resultados.get(0).equals(0)) {
                retorno = true;
                System.out.println("Retorno da limpa_auditoria: "+resultados.get(0));
            }

        } catch (Exception e) {
            System.err.println("Erro em chamarFuncaoLimpaAuditoria" + e);
        } finally{
            sessao.close();
        }
        
        return retorno;
    }
}
