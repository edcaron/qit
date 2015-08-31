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
 * Tela generated by hbm2java
 */
@Entity
@Table(name="tela"
    ,schema="public"
)
public class Tela  implements java.io.Serializable {


     private int id;
     private String descricao;
     private String nome;
     private Set permissaos = new HashSet(0);

    public Tela() {
    }

	
    public Tela(int id, String descricao, String nome) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
    }
    public Tela(int id, String descricao, String nome, Set permissaos) {
       this.id = id;
       this.descricao = descricao;
       this.nome = nome;
       this.permissaos = permissaos;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="descricao", nullable=false, length=45)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Column(name="nome", nullable=false, length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tela")
    public Set getPermissaos() {
        return this.permissaos;
    }
    
    public void setPermissaos(Set permissaos) {
        this.permissaos = permissaos;
    }




}


