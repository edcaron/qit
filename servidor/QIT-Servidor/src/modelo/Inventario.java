/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author eduardo.caron
 */
public class Inventario {

    private String dataAtual;
    private Maquina maquina;       
           

    public Inventario() {
    }

    public Inventario(Maquina maquina, String dataAtual) {
        this.maquina = maquina;
        this.dataAtual = dataAtual;        
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
}
