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
import modelo.Tipo;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class TipoDAO  {
    private Session sessao = null;

    public TipoDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }    
    
    public ArrayList<Tipo> listar(IModelo tipo) {
        List resultado = null;

        ArrayList<Tipo> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Tipo t where lower(t.nome) like lower('%" + tipo.getNome() + "%') order by p.id desc";

            if (tipo.getNome().equals("")) {
                sql = "from Tipo p order by p.id desc";
            }

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Tipo s = ((Tipo) ((Object) o));
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
