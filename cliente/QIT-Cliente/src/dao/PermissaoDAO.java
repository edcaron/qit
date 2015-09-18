/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import controle.HibernateUtil;
import java.util.ArrayList;
import modelo.Permissao;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author eduar_000
 */
public class PermissaoDAO {

    public PermissaoDAO() {
    }

    public ArrayList<Permissao> consultar(Usuario usuario, int id_tela) {
        List resultadoBanco = null;
        ArrayList<Permissao> listaPermissoes = null;
        String query = "";
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            if (usuario.getTipoPermissao() == 'I') {
                query = "from Permissao p, Usuariou, Tela t WHERE  u.id = " + usuario.getId();
            } else if (usuario.getTipoPermissao() == 'G') {
                query = "from Permissao p, Grupo g, Tela t WHERE g.id = " + usuario.getGrupo().getId();
            }

            System.out.println("Query = " + query);

            org.hibernate.Query q = sessao.createQuery(query);
            resultadoBanco = q.list();

            for (Object o : resultadoBanco) {
                Permissao s = ((Permissao) ((Object[]) o)[0]);
                System.out.println("id: " + s.getId() + " ");
                System.out.println("ler " + s.getLer());
                System.out.println("editar " + s.isEditar());
                System.out.println("inativar " + s.isInativar());
                System.out.println("inserir " + s.isInserir());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return listaPermissoes;
    }

}
