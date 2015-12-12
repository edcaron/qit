/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import modelo.Maquina;
import modelo.Particao;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class ParticaoDAO {

    private Session sessao = null;

    public ParticaoDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }
    
       public ArrayList<Particao> listar(Maquina maquina) {
        List resultado = null;

        ArrayList<Particao> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "from Particao p where p.maquina.id =" + maquina.getId()  + " order by p.id desc";

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Particao s = ((Particao)  o);
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
