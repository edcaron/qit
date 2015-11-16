/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AuditoriaDAO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Auditoria;
import modelo.Usuario;

/**
 *
 * @author Tiago
 */
public class ControleAuditoria {

    private AuditoriaDAO dao;

    public ControleAuditoria() {
        this.dao = new AuditoriaDAO();
    }


    public List listaTodos(Date minDate, Date maxDate) {
        try {
            return dao.listaTodos(minDate, maxDate);
        } catch (Exception ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
    }
}
