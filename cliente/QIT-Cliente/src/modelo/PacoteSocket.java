/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author eduar_000
 */
public class PacoteSocket {

    private String tipoTarefa;
    private int idTipoTarefa;
    private ArrayList<Maquina> listaMaquinas;
    private int[] listaTarefas;
    private ArrayList<File> listaArquivos;

    public PacoteSocket() {
    }

    public PacoteSocket(String tipoTarefa, int idTipoTarefa, ArrayList<Maquina> listaMaquinas, int[] listaTarefas, ArrayList<File> listaArquivos) {
        this.tipoTarefa = tipoTarefa;
        this.idTipoTarefa = idTipoTarefa;
        this.listaMaquinas = listaMaquinas;
        this.listaTarefas = listaTarefas;
        this.listaArquivos = listaArquivos;
    }

    public String getTipoTarefa() {
        return tipoTarefa;
    }

    public void setTipoTarefa(String tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    public int getIdTipoTarefa() {
        return idTipoTarefa;
    }

    public void setIdTipoTarefa(int idTipoTarefa) {
        this.idTipoTarefa = idTipoTarefa;
    }

    public ArrayList<Maquina> getListaMaquinas() {
        return listaMaquinas;
    }

    public void setListaMaquinas(ArrayList<Maquina> listaMaquinas) {
        this.listaMaquinas = listaMaquinas;
    }

    public int[] getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(int[] listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public ArrayList<File> getListaArquivos() {
        return listaArquivos;
    }

    public void setListaArquivos(ArrayList<File> listaArquivos) {
        this.listaArquivos = listaArquivos;
    }

}
