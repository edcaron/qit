package modelo;
// Generated 17/09/2015 16:32:25 by Hibernate Tools 4.3.1

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
import org.hibernate.annotations.Generated;

/**
 * Sala generated by hbm2java
 */
@Entity
@Table(name = "sala", schema = "public"
)
public class Sala implements java.io.Serializable, IModelo {

    private int id;
    private Predio predio;
    private String nome;
    private String descricao;
    private boolean ativo;
    private Set<Maquina> maquinas = new HashSet<Maquina>(0);

    public Sala() {
    }

    public Sala(int id, Predio predio, String nome, boolean ativo) {
        this.id = id;
        this.predio = predio;
        this.nome = nome;
        this.ativo = ativo;
    }

    public Sala(int id, Predio predio, String nome, String descricao, boolean ativo, Set<Maquina> maquinas) {
        this.id = id;
        this.predio = predio;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
        this.maquinas = maquinas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predio", nullable = false)
    public Predio getPredio() {
        return this.predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    @Column(name = "nome", nullable = false, length = 50)
    @Override
    public String getNome() {
        return this.nome;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "descricao", length = 45)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "ativo", nullable = false)
    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
    public Set<Maquina> getMaquinas() {
        return this.maquinas;
    }

    public void setMaquinas(Set<Maquina> maquinas) {
        this.maquinas = maquinas;
    }
  

}
