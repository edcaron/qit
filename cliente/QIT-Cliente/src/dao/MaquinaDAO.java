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
import modelo.Maquina;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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

}
