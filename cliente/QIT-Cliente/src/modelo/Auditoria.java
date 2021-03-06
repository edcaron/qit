package modelo;
// Generated 11/12/2015 23:47:41 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Auditoria generated by hbm2java
 */
@Entity
@Table(name = "auditoria", schema = "public"
)
public class Auditoria implements java.io.Serializable {

    private int id;
    private Usuario usuario;
    private String tabela;
    private Boolean alteradoSistema;
    private char operacao;
    private String alteracoes;
    private Date dt;
    private int idConteudo;
    private String valoresNovos;
    private String valoresAntigos;

    public Auditoria() {
    }

    public Auditoria(int id, String tabela, char operacao, int idConteudo) {
        this.id = id;
        this.tabela = tabela;
        this.operacao = operacao;
        this.idConteudo = idConteudo;
    }

    public Auditoria(int id, Usuario usuario, String tabela, Boolean alteradoSistema, char operacao, String alteracoes, Date dt, int idConteudo, String valoresNovos, String valoresAntigos) {
        this.id = id;
        this.usuario = usuario;
        this.tabela = tabela;
        this.alteradoSistema = alteradoSistema;
        this.operacao = operacao;
        this.alteracoes = alteracoes;
        this.dt = dt;
        this.idConteudo = idConteudo;
        this.valoresNovos = valoresNovos;
        this.valoresAntigos = valoresAntigos;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "tabela", nullable = false, length = 45)
    public String getTabela() {
        return this.tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    @Column(name = "alterado_sistema")
    public Boolean getAlteradoSistema() {
        return this.alteradoSistema;
    }

    public void setAlteradoSistema(Boolean alteradoSistema) {
        this.alteradoSistema = alteradoSistema;
    }

    @Column(name = "operacao", nullable = false, length = 1)
    public char getOperacao() {
        return this.operacao;
    }

    public void setOperacao(char operacao) {
        this.operacao = operacao;
    }

    @Column(name = "alteracoes")
    public String getAlteracoes() {
        return this.alteracoes;
    }

    public void setAlteracoes(String alteracoes) {
        this.alteracoes = alteracoes;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt", length = 29)
    public Date getDt() {
        return this.dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    @Column(name = "id_conteudo", nullable = false)
    public int getIdConteudo() {
        return this.idConteudo;
    }

    public void setIdConteudo(int idConteudo) {
        this.idConteudo = idConteudo;
    }

    @Column(name = "valores_novos")
    public String getValoresNovos() {
        return this.valoresNovos;
    }

    public void setValoresNovos(String valoresNovos) {
        this.valoresNovos = valoresNovos;
    }

    @Column(name = "valores_antigos")
    public String getValoresAntigos() {
        return this.valoresAntigos;
    }

    public void setValoresAntigos(String valoresAntigos) {
        this.valoresAntigos = valoresAntigos;
    }

}
