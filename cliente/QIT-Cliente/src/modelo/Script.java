package modelo;
// Generated 17/10/2015 22:43:46 by Hibernate Tools 4.3.1

import controle.IModelo;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OrderBy;

/**
 * Script generated by hbm2java
 */
@Entity
@Table(name = "script", schema = "public"
)
public class Script implements java.io.Serializable, IModelo {

    private int id;
    private Tipo tipo;
    private Usuario usuario;
    private String texto;
    private String nome;
    private String dtCriacao;
    private Boolean ativo;
    private Set<ExecucaoScript> execucaoScripts = new HashSet<ExecucaoScript>(0);
    private Set<Dependencia> dependencias = new HashSet<Dependencia>(0);

    public Script() {
    }

    public Script(int id, Tipo tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Script(int id, Tipo tipo, Usuario usuario, String texto, String nome, String dtCriacao, Boolean ativo, Set<ExecucaoScript> execucaoScripts, Set<Dependencia> dependencias) {
        this.id = id;
        this.tipo = tipo;
        this.usuario = usuario;
        this.texto = texto;
        this.nome = nome;
        this.dtCriacao = dtCriacao;
        this.ativo = ativo;
        this.execucaoScripts = execucaoScripts;
        this.dependencias = dependencias;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo", nullable = false)
    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_modificador")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "texto")
    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Column(name = "nome", length = 45)
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "dt_criacao", length = 45)
    public String getDtCriacao() {
        return this.dtCriacao;
    }

    public void setDtCriacao(String dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    @Column(name = "ativo")
    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "script")
    public Set<ExecucaoScript> getExecucaoScripts() {
        return this.execucaoScripts;
    }

    public void setExecucaoScripts(Set<ExecucaoScript> execucaoScripts) {
        this.execucaoScripts = execucaoScripts;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "script")
    @OrderBy(clause = "id DESC")
    public Set<Dependencia> getDependencias() {
        return this.dependencias;
    }

    public void setDependencias(Set<Dependencia> dependencias) {
        this.dependencias = dependencias;
    }

}
