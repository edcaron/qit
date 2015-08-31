package modelo;


public class PlacaRede  implements java.io.Serializable {


     private int id;
     private Maquina maquina;
     private String nome;
     private String ipv4;
     private String ipv6;
     private String mac;
     private Boolean principal;

    public PlacaRede() {
    }

	
    public PlacaRede(int id, Maquina maquina) {
        this.id = id;
        this.maquina = maquina;
    }
    public PlacaRede(int id, Maquina maquina, String nome, String ipv4, String ipv6, String mac, Boolean principal) {
       this.id = id;
       this.maquina = maquina;
       this.nome = nome;
       this.ipv4 = ipv4;
       this.ipv6 = ipv6;
       this.mac = mac;
       this.principal = principal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }
   
    
}


