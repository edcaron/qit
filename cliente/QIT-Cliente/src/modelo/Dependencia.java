package modelo;
// Generated 31/08/2015 19:49:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Dependencia generated by hbm2java
 */
@Entity
@Table(name="dependencia"
    ,schema="public"
)
public class Dependencia  implements java.io.Serializable {


     private int id;
     private Script script;
     private String nome;
     private String diretorio;
     private String md5;
     private Set softwares = new HashSet(0);

    public Dependencia() {
    }

	
    public Dependencia(int id, String nome, String diretorio) {
        this.id = id;
        this.nome = nome;
        this.diretorio = diretorio;
    }
    public Dependencia(int id, Script script, String nome, String diretorio, String md5, Set softwares) {
       this.id = id;
       this.script = script;
       this.nome = nome;
       this.diretorio = diretorio;
       this.md5 = md5;
       this.softwares = softwares;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_script")
    public Script getScript() {
        return this.script;
    }
    
    public void setScript(Script script) {
        this.script = script;
    }

    
    @Column(name="nome", nullable=false, length=100)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="diretorio", nullable=false, length=100)
    public String getDiretorio() {
        return this.diretorio;
    }
    
    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    
    @Column(name="md5", length=32)
    public String getMd5() {
        return this.md5;
    }
    
    public void setMd5(String md5) {
        this.md5 = md5;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dependencia")
    public Set getSoftwares() {
        return this.softwares;
    }
    
    public void setSoftwares(Set softwares) {
        this.softwares = softwares;
    }




}


