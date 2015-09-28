package modelo;
// Generated 17/09/2015 16:32:25 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Particao generated by hbm2java
 */
@Entity
@Table(name="particao"
    ,schema="public"
)
public class Particao  implements java.io.Serializable {


     private int id;
     private Maquina maquina;
     private String nomeHd;
     private String formato;
     private String letra;
     private String nomeVolume;
     private boolean principal;
     private Double espacoMb;
     private Double espacoLivreMb;

    public Particao() {
    }

	
    public Particao(int id, Maquina maquina, String letra, boolean principal) {
        this.id = id;
        this.maquina = maquina;
        this.letra = letra;
        this.principal = principal;
    }
    public Particao(int id, Maquina maquina, String nomeHd, String formato, String letra, String nomeVolume, boolean principal, Double espacoMb, Double espacoLivreMb) {
       this.id = id;
       this.maquina = maquina;
       this.nomeHd = nomeHd;
       this.formato = formato;
       this.letra = letra;
       this.nomeVolume = nomeVolume;
       this.principal = principal;
       this.espacoMb = espacoMb;
       this.espacoLivreMb = espacoLivreMb;
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
    @JoinColumn(name="id_maquina", nullable=false)
    public Maquina getMaquina() {
        return this.maquina;
    }
    
    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    
    @Column(name="nome_hd", length=100)
    public String getNomeHd() {
        return this.nomeHd;
    }
    
    public void setNomeHd(String nomeHd) {
        this.nomeHd = nomeHd;
    }

    
    @Column(name="formato", length=10)
    public String getFormato() {
        return this.formato;
    }
    
    public void setFormato(String formato) {
        this.formato = formato;
    }

    
    @Column(name="letra", nullable=false, length=45)
    public String getLetra() {
        return this.letra;
    }
    
    public void setLetra(String letra) {
        this.letra = letra;
    }

    
    @Column(name="nome_volume", length=45)
    public String getNomeVolume() {
        return this.nomeVolume;
    }
    
    public void setNomeVolume(String nomeVolume) {
        this.nomeVolume = nomeVolume;
    }

    
    @Column(name="principal", nullable=false)
    public boolean isPrincipal() {
        return this.principal;
    }
    
    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    
    @Column(name="espaco_mb", precision=17, scale=17)
    public Double getEspacoMb() {
        return this.espacoMb;
    }
    
    public void setEspacoMb(Double espacoMb) {
        this.espacoMb = espacoMb;
    }

    
    @Column(name="espaco_livre_mb", precision=17, scale=17)
    public Double getEspacoLivreMb() {
        return this.espacoLivreMb;
    }
    
    public void setEspacoLivreMb(Double espacoLivreMb) {
        this.espacoLivreMb = espacoLivreMb;
    }




}

