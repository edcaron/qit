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
 * MaquinasExecucaoInstalacao generated by hbm2java
 */
@Entity
@Table(name="maquinas_execucao_instalacao"
    ,schema="public"
)
public class MaquinasExecucaoInstalacao  implements java.io.Serializable {


     private MaquinasExecucaoInstalacaoId id;
     private ExecucaoInstalacao execucaoInstalacao;
     private Maquina maquina;
     private Boolean sucesso;
     private String retorno;
     private Date dtRetorno;

    public MaquinasExecucaoInstalacao() {
    }

	
    public MaquinasExecucaoInstalacao(MaquinasExecucaoInstalacaoId id, ExecucaoInstalacao execucaoInstalacao, Maquina maquina) {
        this.id = id;
        this.execucaoInstalacao = execucaoInstalacao;
        this.maquina = maquina;
    }
    public MaquinasExecucaoInstalacao(MaquinasExecucaoInstalacaoId id, ExecucaoInstalacao execucaoInstalacao, Maquina maquina, Boolean sucesso, String retorno, Date dtRetorno) {
       this.id = id;
       this.execucaoInstalacao = execucaoInstalacao;
       this.maquina = maquina;
       this.sucesso = sucesso;
       this.retorno = retorno;
       this.dtRetorno = dtRetorno;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idMaquina", column=@Column(name="id_maquina", nullable=false) ), 
        @AttributeOverride(name="idExecucaoInstalacao", column=@Column(name="id_execucao_instalacao", nullable=false) ) } )
    public MaquinasExecucaoInstalacaoId getId() {
        return this.id;
    }
    
    public void setId(MaquinasExecucaoInstalacaoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_execucao_instalacao", nullable=false, insertable=false, updatable=false)
    public ExecucaoInstalacao getExecucaoInstalacao() {
        return this.execucaoInstalacao;
    }
    
    public void setExecucaoInstalacao(ExecucaoInstalacao execucaoInstalacao) {
        this.execucaoInstalacao = execucaoInstalacao;
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


