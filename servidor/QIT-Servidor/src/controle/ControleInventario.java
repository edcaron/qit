/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.MaquinaDAO;
import dao.ParticaoDAO;
import dao.PlacaRedeDAO;
import dao.SoftwareDAO;
import dao.SoftwareMaquinaDAO;
import modelo.Inventario;
import modelo.Maquina;
import modelo.Particao;
import modelo.PlacaRede;
import modelo.Sala;
import modelo.Software;
import modelo.SoftwaresMaquina;

/**
 *
 * @author eduar_000
 */
public class ControleInventario {
    
    private MaquinaDAO maqDAO;
    private PlacaRedeDAO placaDAO;
    private SoftwareDAO sfDAO;
    private SoftwareMaquinaDAO smDAO;
    private ParticaoDAO partDAO;
    
    public ControleInventario() {
        maqDAO = new MaquinaDAO();
        placaDAO = new PlacaRedeDAO();
        sfDAO = new SoftwareDAO();
        smDAO = new SoftwareMaquinaDAO();
        partDAO = new ParticaoDAO();
    }
    
    public boolean gravarInventario(Inventario inventario) {
//gravar maquina
        Maquina maquina = inventario.getMaquina();
        maquina = maqDAO.procurarDuplicado(maquina);
        maquina.setDtUltimaDeteccao(Util.stringParaDate(inventario.getDataAtual()));
        maquina.setAtivo(Boolean.TRUE);
        if (maquina.getId() != 0) {
            Maquina maquinaDoBando = maqDAO.consultar(maquina);
            maquina.setAtivo(maquinaDoBando.getAtivo());
            maquina.setSala(maquinaDoBando.getSala());
            maquina.setDtPrimeiraDeteccao(maquinaDoBando.getDtPrimeiraDeteccao());
            maquina.setObservacao(maquinaDoBando.getObservacao());
        } else {
            //caso esta maquina ainda não esteja gravada no banco, marcamos como detectado para esta maquina na data que foi feito o inventario
            maquina.setDtPrimeiraDeteccao(Util.stringParaDate(inventario.getDataAtual()));
        }
        
        maqDAO.salvar(maquina);

//        gravar placa de rede        
        for (PlacaRede placaDeRede : inventario.getMaquina().getPlacaRedes()) {
            placaDeRede = placaDAO.procurarDuplicado(placaDeRede);
            placaDAO.salvar(placaDeRede);
        }

//        gravar particoes
        for (Particao particao : inventario.getMaquina().getParticaos()) {
            particao = partDAO.procurarDuplicado(particao);
            placaDAO.salvar(particao);
        }

//        gravar softwares       
        smDAO.inativarSoftwaresMaquina(maquina);//inativar todos softwares vinculados a maquina q estamos trabalhando

        for (SoftwaresMaquina softwaresMaquina : inventario.getMaquina().getSoftwaresMaquinas()) {
            Software software = softwaresMaquina.getSoftware();
            software = sfDAO.procurarDuplicado(software);
            sfDAO.salvar(software);

//            gravar softwares_maquina, a tabela relacionada
            softwaresMaquina = smDAO.procurarDuplicado(softwaresMaquina);
            if (softwaresMaquina.getId() == 0) { // se o software vai ser registrado para essa maquina no momento, marcamos como detectado para esta maquina na data que foi feito o inventario
                softwaresMaquina.setDtDeteccao(Util.stringParaDate(inventario.getDataAtual()));
            }
            smDAO.salvar(softwaresMaquina);
        }
        return true;
    }
}
