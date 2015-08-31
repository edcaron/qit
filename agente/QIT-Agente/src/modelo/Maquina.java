package modelo;
// Generated 14/08/2015 20:26:10 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Maquina {
    
     private int id;
     private String host;
     private BigDecimal versaoAgente;
     private String dominio;
     private String so;
     private String arquiteturaso;
     private String versaoSo;
     private String spSo;
     private String fabricanteSo;
     private String rootSo;
     private String memoriaTotal;
     private String fabicantePc;
     private String modeloPc;
     private String cpu;
     private String nucleosCpu;
     private String fabricanteCpu;
     private String bios;
     private String ipv4;
     private String mac;
     private String particoes;
     private String usuarioConectado;
     private Date dtPrimeiraDeteccao;
     private Date dtUltimaDeteccao;
     private Boolean ligado;
     private String observacao;
     private Boolean ativo;
     private Integer salaId;
     private Set placaRedes = new HashSet(0);
     private Set particoeses = new HashSet(0);

    public Maquina() {
    }

	
    public Maquina(int id, String host) {
        this.id = id;
        this.host = host;
    }
    public Maquina(int id, String host, BigDecimal versaoAgente, String dominio, String so, String arquiteturaso, String versaoSo, String spSo, String fabricanteSo, String rootSo, String memoriaTotal, String fabicantePc, String modeloPc, String cpu, String nucleosCpu, String fabricanteCpu, String bios, String ipv4, String mac, String particoes, String usuarioConectado, Date dtPrimeiraDeteccao, Date dtUltimaDeteccao, Boolean ligado, String observacao, Boolean ativo, Integer salaId, Set placaRedes, Set particoeses) {
       this.id = id;
       this.host = host;
       this.versaoAgente = versaoAgente;
       this.dominio = dominio;
       this.so = so;
       this.arquiteturaso = arquiteturaso;
       this.versaoSo = versaoSo;
       this.spSo = spSo;
       this.fabricanteSo = fabricanteSo;
       this.rootSo = rootSo;
       this.memoriaTotal = memoriaTotal;
       this.fabicantePc = fabicantePc;
       this.modeloPc = modeloPc;
       this.cpu = cpu;
       this.nucleosCpu = nucleosCpu;
       this.fabricanteCpu = fabricanteCpu;
       this.bios = bios;
       this.ipv4 = ipv4;
       this.mac = mac;
       this.particoes = particoes;
       this.usuarioConectado = usuarioConectado;
       this.dtPrimeiraDeteccao = dtPrimeiraDeteccao;
       this.dtUltimaDeteccao = dtUltimaDeteccao;
       this.ligado = ligado;
       this.observacao = observacao;
       this.ativo = ativo;
       this.salaId = salaId;
       this.placaRedes = placaRedes;
       this.particoeses = particoeses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public BigDecimal getVersaoAgente() {
        return versaoAgente;
    }

    public void setVersaoAgente(BigDecimal versaoAgente) {
        this.versaoAgente = versaoAgente;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getArquiteturaso() {
        return arquiteturaso;
    }

    public void setArquiteturaso(String arquiteturaso) {
        this.arquiteturaso = arquiteturaso;
    }

    public String getVersaoSo() {
        return versaoSo;
    }

    public void setVersaoSo(String versaoSo) {
        this.versaoSo = versaoSo;
    }

    public String getSpSo() {
        return spSo;
    }

    public void setSpSo(String spSo) {
        this.spSo = spSo;
    }

    public String getFabricanteSo() {
        return fabricanteSo;
    }

    public void setFabricanteSo(String fabricanteSo) {
        this.fabricanteSo = fabricanteSo;
    }

    public String getRootSo() {
        return rootSo;
    }

    public void setRootSo(String rootSo) {
        this.rootSo = rootSo;
    }

    public String getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(String memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public String getFabicantePc() {
        return fabicantePc;
    }

    public void setFabicantePc(String fabicantePc) {
        this.fabicantePc = fabicantePc;
    }

    public String getModeloPc() {
        return modeloPc;
    }

    public void setModeloPc(String modeloPc) {
        this.modeloPc = modeloPc;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getNucleosCpu() {
        return nucleosCpu;
    }

    public void setNucleosCpu(String nucleosCpu) {
        this.nucleosCpu = nucleosCpu;
    }

    public String getFabricanteCpu() {
        return fabricanteCpu;
    }

    public void setFabricanteCpu(String fabricanteCpu) {
        this.fabricanteCpu = fabricanteCpu;
    }

    public String getBios() {
        return bios;
    }

    public void setBios(String bios) {
        this.bios = bios;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getParticoes() {
        return particoes;
    }

    public void setParticoes(String particoes) {
        this.particoes = particoes;
    }

    public String getUsuarioConectado() {
        return usuarioConectado;
    }

    public void setUsuarioConectado(String usuarioConectado) {
        this.usuarioConectado = usuarioConectado;
    }

    public Date getDtPrimeiraDeteccao() {
        return dtPrimeiraDeteccao;
    }

    public void setDtPrimeiraDeteccao(Date dtPrimeiraDeteccao) {
        this.dtPrimeiraDeteccao = dtPrimeiraDeteccao;
    }

    public Date getDtUltimaDeteccao() {
        return dtUltimaDeteccao;
    }

    public void setDtUltimaDeteccao(Date dtUltimaDeteccao) {
        this.dtUltimaDeteccao = dtUltimaDeteccao;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getSalaId() {
        return salaId;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }

    public Set getPlacaRedes() {
        return placaRedes;
    }

    public void setPlacaRedes(Set placaRedes) {
        this.placaRedes = placaRedes;
    }

    public Set getParticoeses() {
        return particoeses;
    }

    public void setParticoeses(Set particoeses) {
        this.particoeses = particoeses;
    }
 
    
    
}


