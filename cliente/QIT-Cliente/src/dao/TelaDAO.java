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
import modelo.Permissao;
import modelo.Tela;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Tiago
 */
public class TelaDAO {

    private Session sessao = null;

    public TelaDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }

    public boolean salvar(Tela tela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Tela consultar(Tela tela) {
        List resultado = null;
        Tela telaLocal = new Tela();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Tela p where p.id = " + tela.getId());
            resultado = q.list();

            telaLocal = (Tela) resultado.get(0);

        } catch (HibernateException he) {
            System.err.println("Erro em consultar predio \n" + he);
        } finally {
            sessao.close();
        }
        return telaLocal;
    }

    public ArrayList<Tela> listar(IModelo tela) {
        List resultado = null;

        ArrayList<Tela> lista = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String sql = "";
            if (tela != null) {
                sql = "from Tela t where lower(t.nome) like lower('%" + tela.getNome() + "%') order by t.id desc";
            } else {

                sql = "from Tela t order by t.id desc";
            }

            org.hibernate.Query q = sessao.createQuery(sql);
            resultado = q.list();

            for (Object o : resultado) {
                Tela t = ((Tela) ((Object) o));
                lista.add(t);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return lista;
    }

}
