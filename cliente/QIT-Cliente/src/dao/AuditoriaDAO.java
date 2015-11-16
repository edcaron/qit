/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.HibernateUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelo.Auditoria;
import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Tiago
 */
public class AuditoriaDAO {

    private Session sessao = null;

    public AuditoriaDAO() {
        sessao = HibernateUtil.getSessionFactory().openSession();
    }



    public List listaTodos(Date minDate, Date maxDate) {

        Query query = sessao.createQuery("from Auditoria");
        List listaUs = query.list();
        Criteria ct = sessao.createCriteria(Auditoria.class);
        //ct.add(Restrictions.gt("id", (4)));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
        String myDate = "17-04-2011";
        // Create date 17-04-2011 - 00h00

        // Create date 18-04-2011 - 00h00 
        // -> We take the 1st date and add it 1 day in millisecond thanks to a useful and not so known class
        ct.add(Expression.ge("dt", minDate)); //maior que minDate
        ct.add(Expression.le("dt", maxDate)); //maior que maxDate
//        Conjunction and = Restrictions.conjunction();
//        // The order date must be >= 17-04-2011 - 00h00
//        and.add(Restrictions.ge("dt_criacao", minDate));
//        // And the order date must be < 18-04-2011 - 00h00
//        and.add(Restrictions.lt("dt_criacao ", maxDate));
//        ct.add(and);

        listaUs = ct.list();

        return listaUs;

    }
}
