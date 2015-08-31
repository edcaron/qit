package modelo;
// Generated 31/08/2015 19:49:55 by Hibernate Tools 4.3.1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ExecucaoScript generated by hbm2java
 */
@Entity
@Table(name="execucao_script"
    ,schema="public"
)
public class ExecucaoScript  implements java.io.Serializable {


     private int id;
     private Script script;
     private Usuario usuario;
     private Date data;
     private Set maquinasExecutarScripts = new HashSet(0);

    public ExecucaoScript() {
    }

	
    public ExecucaoScript(int id, Script script, Usuario usuario, Date data) {
        this.id = id;
        this.script = script;
        this.usuario = usuario;
        this.data = data;
    }
    public ExecucaoScript(int id, Script script, Usuario usuario, Date data, Set maquinasExecutarScripts) {
       this.id = id;
       this.script = script;
       this.usuario = usuario;
       this.data = data;
       this.maquinasExecutarScripts = maquinasExecutarScripts;
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
    @JoinColumn(name="id_script", nullable=false)
    public Script getScript() {
        return this.script;
    }
    
    public void setScript(Script script) {
        this.script = script;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usuario_criacao", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data", nullable=false, length=29)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="execucaoScript")
    public Set getMaquinasExecutarScripts() {
        return this.maquinasExecutarScripts;
    }
    
    public void setMaquinasExecutarScripts(Set maquinasExecutarScripts) {
        this.maquinasExecutarScripts = maquinasExecutarScripts;
    }




}


