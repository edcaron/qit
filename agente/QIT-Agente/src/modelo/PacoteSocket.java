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
public class PacoteSocket implements Serializable {

    private int id;
    private int tipo;
    private ArrayList<Maquina> listaMaquinas;
    private ArrayList<Tarefa> listaTarefas;

//    private byte[] listaArquivos;
    public PacoteSocket() {
    }

    public ArrayList<Maquina> getListaMaquinas() {
        return listaMaquinas;
    }

    public void setListaMaquinas(ArrayList<Maquina> listaMaquinas) {
        this.listaMaquinas = listaMaquinas;
    }

    public ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public int getId() {
        return id;
    }

    /**
     * 1 - fazer inventario 2 - armazenar inventario
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 1 = script 2 = software
     *
     * @return
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * 1 = script 2 = software
     *
     * @param tipo
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
