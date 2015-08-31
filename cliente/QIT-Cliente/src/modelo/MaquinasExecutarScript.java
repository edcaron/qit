package modelo;
// Generated 31/08/2015 19:49:55 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MaquinasExecutarScript generated by hbm2java
 */
@Entity
@Table(name="maquinas_executar_script"
    ,schema="public"
)
public class MaquinasExecutarScript  implements java.io.Serializable {


     private MaquinasExecutarScriptId id;
     private ExecucaoScript execucaoScript;
     private Maquina maquina;
     private Boolean sucesso;
     private String retorno;
     private Date dtRetorno;

    public MaquinasExecutarScript() {
    }

	
    public MaquinasExecutarScript(MaquinasExecutarScriptId id, ExecucaoScript execucaoScript, Maquina maquina) {
        this.id = id;
        this.execucaoScript = execucaoScript;
        this.maquina = maquina;
    }
    public MaquinasExecutarScript(MaquinasExecutarScriptId id, ExecucaoScript execucaoScript, Maquina maquina, Boolean sucesso, String retorno, Date dtRetorno) {
       this.id = id;
       this.execucaoScript = execucaoScript;
       this.maquina = maquina;
       this.sucesso = sucesso;
       this.retorno = retorno;
       this.dtRetorno = dtRetorno;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idExecutarScript", column=@Column(name="id_executar_script", nullable=false) ), 
        @AttributeOverride(name="idMaquina", column=@Column(name="id_maquina", nullable=false) ) } )
    public MaquinasExecutarScriptId getId() {
        return this.id;
    }
    
    public void setId(MaquinasExecutarScriptId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_executar_script", nullable=false, insertable=false, updatable=false)
    public ExecucaoScript getExecucaoScript() {
        return this.execucaoScript;
    }
    
    public void setExecucaoScript(ExecucaoScript execucaoScript) {
        this.execucaoScript = execucaoScript;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_maquina", nullable=false, insertable=false, updatable=false)
    public Maquina getMaquina() {
        return this.maquina;
    }
    
    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    
    @Column(name="sucesso")
    public Boolean getSucesso() {
        return this.sucesso;
    }
    
    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    
    @Column(name="retorno")
    public String getRetorno() {
        return this.retorno;
    }
    
    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_retorno", length=29)
    public Date getDtRetorno() {
        return this.dtRetorno;
    }
    
    public void setDtRetorno(Date dtRetorno) {
        this.dtRetorno = dtRetorno;
    }




}


