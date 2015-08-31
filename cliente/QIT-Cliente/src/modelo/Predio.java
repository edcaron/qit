package modelo;
// Generated 31/08/2015 19:49:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Predio generated by hbm2java
 */
@Entity
@Table(name="predio"
    ,schema="public"
)
public class Predio  implements java.io.Serializable {


     private int id;
     private String nome;
     private String descricao;
     private boolean ativo;
     private Set salas = new HashSet(0);

    public Predio() {
    }

	
    public Predio(int id, String nome, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }
    public Predio(int id, String nome, String descricao, boolean ativo, Set salas) {
       this.id = id;
       this.nome = nome;
       this.descricao = descricao;
       this.ativo = ativo;
       this.salas = salas;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="nome", nullable=false, length=50)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="descricao", length=45)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Column(name="ativo", nullable=false)
    public boolean isAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="predio")
    public Set getSalas() {
        return this.salas;
    }
    
    public void setSalas(Set salas) {
        this.salas = salas;
    }




}


