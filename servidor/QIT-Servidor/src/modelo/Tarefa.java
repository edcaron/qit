/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author eduar_000
 */
public class Tarefa implements Serializable {

    private int operacao;
    private String comando;
    private ArrayList<byte[]> listaArquivos;

    public Tarefa(int id, int tipo, String comando, ArrayList<byte[]> listaArquivos) {
        this.comando = comando;
        this.listaArquivos = listaArquivos;
    }

    public Tarefa() {
    }

    public int getOperacao() {
        return operacao;
    }

    /**
     * 1 - fazer inventario 2 - armazenar inventario
     *
     * @param operacao
     */
    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public ArrayList<byte[]> getListaArquivos() {
        return listaArquivos;
    }

    public void setListaArquivos(ArrayList<byte[]> listaArquivos) {
        this.listaArquivos = listaArquivos;
    }
}
