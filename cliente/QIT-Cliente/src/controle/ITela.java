/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author eduar_000
 */
public interface ITela {

    public boolean inserir();

    public boolean ler();

    public boolean editar();

    public boolean inativar();

    public void limparCampos();

    public void popularCampos();

    public void setRelacionado1(String id, String nome);

    public void setRelacionado2(String id, String nome);

    public void setRelacionado3(String id, String nome);

    public void setRelacionado4(String id, String nome);
}
