package modelo;
// Generated 17/09/2015 16:32:25 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MaquinasExecutarScriptId generated by hbm2java
 */
@Embeddable
public class MaquinasExecutarScriptId  implements java.io.Serializable {


     private int idExecutarScript;
     private int idMaquina;

    public MaquinasExecutarScriptId() {
    }

    public MaquinasExecutarScriptId(int idExecutarScript, int idMaquina) {
       this.idExecutarScript = idExecutarScript;
       this.idMaquina = idMaquina;
    }
   


    @Column(name="id_executar_script", nullable=false)
    public int getIdExecutarScript() {
        return this.idExecutarScript;
    }
    
    public void setIdExecutarScript(int idExecutarScript) {
        this.idExecutarScript = idExecutarScript;
    }


    @Column(name="id_maquina", nullable=false)
    public int getIdMaquina() {
        return this.idMaquina;
    }
    
    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MaquinasExecutarScriptId) ) return false;
		 MaquinasExecutarScriptId castOther = ( MaquinasExecutarScriptId ) other; 
         
		 return (this.getIdExecutarScript()==castOther.getIdExecutarScript())
 && (this.getIdMaquina()==castOther.getIdMaquina());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdExecutarScript();
         result = 37 * result + this.getIdMaquina();
         return result;
   }   


}


