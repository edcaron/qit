/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controle.Software;
import java.util.ArrayList;

/**
 *
 * @author eduardo.caron
 */
public class Inventario {

    private String dataAtual;
    private Maquina maquina;    
    private ArrayList<Particao> listaParticoes;
    private ArrayList<PlacaRede> listaPlacaRede;
    private ArrayList<Software> listaSoftware;
    
    
    

    public Inventario() {
    }

    public Inventario(Maquina maquina, String dataAtual, ArrayList<Particao> listaParticoes, ArrayList<PlacaRede> listaPlacaRede, ArrayList<Software> listaSoftware) {
        this.maquina = maquina;
        this.dataAtual = dataAtual;
        this.listaParticoes = listaParticoes;
        this.listaPlacaRede = listaPlacaRede;
        this.listaSoftware = listaSoftware;
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }



    public ArrayList<PlacaRede> getListaPlacaRede() {
        return listaPlacaRede;
    }

    public void setListaPlacaRede(ArrayList<PlacaRede> listaPlacaRede) {
        this.listaPlacaRede = listaPlacaRede;
    }



    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public ArrayList<Particao> getListaParticoes() {
        return listaParticoes;
    }

    public void setListaParticoes(ArrayList<Particao> listaParticoes) {
        this.listaParticoes = listaParticoes;
    }

    public ArrayList<Software> getListaSoftware() {
        return listaSoftware;
    }

    public void setListaSoftware(ArrayList<Software> listaSoftware) {
        this.listaSoftware = listaSoftware;
    }

}
