/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import modelo.Inventario;
import modelo.Maquina;
import controle.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eduar_000
 */
public class NewClass {

    public static void main(String args[]) {
        
        Inventario inventario = null;
        
        XStream x = new XStream();
        File arquivoXml = new File("C:\\QIT\\QIT-Agente\\inventario.xml");
        inventario = (Inventario) x.fromXML(arquivoXml);
                
        salvar(inventario.getMaquina());
                
        

    }
    
     public static boolean salvar(Maquina m) {
        boolean retorno = false;
        Session sessao = null;
        try {
            
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.saveOrUpdate(m);
            t.commit();
            retorno = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
}
