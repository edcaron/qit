/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConfiguracaoDAO;
import modelo.Configuracao;

/**
 *
 * @author Tiago
 */
public class ControleConfiguracao {

    private ConfiguracaoDAO dao;

    public ControleConfiguracao() {
        this.dao = new ConfiguracaoDAO();
    }

    public boolean salvar(Configuracao configuracao) {
        return dao.salvar(configuracao);
    }

    public Configuracao consultar(Configuracao configuracao) {
        return dao.consultar(configuracao);
    }

}
