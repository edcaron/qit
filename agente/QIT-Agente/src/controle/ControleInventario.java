/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.HashSet;
import java.util.Set;
import modelo.Inventario;
import modelo.Maquina;
import modelo.Particao;
import modelo.PlacaRede;
import modelo.Software;
import modelo.SoftwaresMaquina;

/**
 *
 * @author eduar_000
 */
public class ControleInventario {

    /**
     * Funcao para obter informacoes sobre wardware e sistema operacional da
     * maquina local
     *
     * @return Maquina com atributos preenchidos
     */
    protected Maquina obterMaquina() {
        Maquina mq = new Maquina();

        //executar o script VBS que obtem informacoes sobre o pc e colocar em uam string
        String strMaquina = strMaquina = ComunicacaoSO.executarComando("cscript C:\\QIT\\QIT-Agente\\vbs\\obterInventario.vbs", "");

        //colocar as informacoes no objeto Maquina
        String[] s = strMaquina.split("\n");
        if (s.length > 1) {
            for (String item : s) {
                item = item.replaceAll("\r", ""); //remover o caracter \r que esta presente em todas as linhas
                if (item.contains("usuario:")) {
                    String clean = item.replaceAll("usuario: ", "");
                    mq.setUsuarioConectado(clean);
                } else if (item.contains("dominio:")) {
                    String clean = item.replaceAll("dominio: ", "");
                    mq.setDominio(clean);
                } else if (item.contains("host")) {
                    String clean = item.replaceAll("host: ", "");
                    mq.setHost(clean);
                } else if (item.contains("memoria")) {
                    String clean = item.replaceAll("memoria: ", "");
                    mq.setMemoriaTotal(clean);
                } else if (item.contains("fabricante_pc")) {
                    String clean = item.replaceAll("fabricante_pc: ", "");
                    mq.setFabricantePc(clean);
                } else if (item.contains("modelo")) {
                    String clean = item.replaceAll("modelo: ", "");
                    mq.setModeloPc(clean);
                } else if (item.contains("sistema_operacional")) {
                    String clean = item.replaceAll("sistema_operacional: ", "");
                    mq.setSo(clean);
                } else if (item.contains("arquitetura")) {
                    String clean = item.replaceAll("arquitetura: ", "");
                    mq.setArquiteturaSo(clean);
                } else if (item.contains("versao")) {
                    String clean = item.replaceAll("versao: ", "");
                    mq.setVersaoSo(clean);
                } else if (item.contains("sp_so")) {
                    String clean = item.replaceAll("sp_so: ", "");
                    mq.setSpSo(clean);
                } else if (item.contains("fabricante_so")) {
                    String clean = item.replaceAll("fabricante_so: ", "");
                    mq.setFabricanteSo(clean);
                } else if (item.contains("root_so")) {
                    String clean = item.replaceAll("root_so: ", "");
                    mq.setRootSo(clean);
                } else if (item.contains("bios")) {
                    String clean = item.replaceAll("bios: ", "");
                    mq.setBios(clean);
                } else if (item.contains("processador")) {
                    String clean = item.replaceAll("processador: ", "");
                    mq.setCpu(clean);
                } else if (item.contains("nucleos")) {
                    String clean = item.replaceAll("nucleos: ", "");
                    mq.setNucleosCpu(clean);
                } else if (item.contains("fabricante_cpu")) {
                    String clean = item.replaceAll("fabricante_cpu: ", "");
                    mq.setFabricanteCpu(clean);
                }
            }
        }

        return mq;
    }

    /**
     *  * Funcao para obter uma lista com particoes da maquina local.
     *
     * @param maquina
     * @return ArrayList com objetos Particao preenchido.
     *
     */
    protected Set<Particao> obterParticoes(Maquina maquina) {
        //executar o script VBS que obtem informacoes sobre o pc e colocar em uam string
        String strParticoes = ComunicacaoSO.executarComando("cscript C:\\QIT\\QIT-Agente\\vbs\\obterParticoes.vbs", "");

        String[] lines = strParticoes.split("___");//divide cada particao em uma posicao do vetor. Quando encontrar o carac '___' inicia uma nova particao

        Set<Particao> listaParticoes = new HashSet<Particao>();

        for (String line : lines) {
            String[] s = line.split("\n"); //divide cada linha de cada posição do vetor de particoes em uma posicao de outro vetor, para poder pegar os dados
            if (s.length > 0) {
                Particao part = new Particao();
                part.setMaquina(maquina);
                for (int j = 1; j < s.length; j++) {
                    s[j] = s[j].replaceAll("\r", ""); //remover o caracter \r que esta presente em todas as linhas
                    if (s[j].contains("nome_hd")) {
                        String clean = s[j].replaceAll("nome_hd: ", "");
                        part.setNomeHd(clean);
                    } else if (s[j].contains("letra")) {
                        String clean = s[j].replaceAll("letra: ", "");
                        part.setLetra(clean);
                    } else if (s[j].contains("label_name")) {
                        String clean = s[j].replaceAll("label_name: ", "");
                        part.setNomeVolume(clean);
                    } else if (s[j].contains("formato")) {
                        String clean = s[j].replaceAll("formato: ", "");
                        part.setFormato(clean);
                    } else if (s[j].contains("tamanho")) {
                        String clean = s[j].replaceAll("tamanho: ", "");
                        part.setEspacoMb(Double.parseDouble(clean));
                    } else if (s[j].contains("espaco_livre")) {
                        String clean = s[j].replaceAll("espaco_livre: ", "");
                        part.setEspacoLivreMb(Double.parseDouble(clean));
                    }
                }
                if (part.getNomeHd() != null) { //se o nome não estiver nulo, adicionamos a uma lista                    
                    listaParticoes.add(part);
                }
            }
        }
        return listaParticoes;
    }

    /**
     * * Funcao para obter uma lista com placas de rede da maquina local.
     * @param maquina
     * @return 
     */
    protected Set<PlacaRede> obterPlacaRede(Maquina maquina) {
        //executar o script VBS que obtem informacoes sobre o pc e colocar em uam string
        String strParticoes = ComunicacaoSO.executarComando("cscript C:\\QIT\\QIT-Agente\\vbs\\obterRede.vbs", "");

        String[] lines = strParticoes.split("___");//divide cada particao em uma posicao do vetor. Quando encontrar o carac '___' inicia uma nova particao

        Set<PlacaRede> listaPlacaRede = new HashSet<PlacaRede>();

        for (String line : lines) {
            String[] s = line.split("\n"); //divide cada linha de cada posição do vetor de particoes em uma posicao de outro vetor, para poder pegar os dados
            if (s.length > 0) {
                PlacaRede pr = new PlacaRede();
                pr.setMaquina(maquina);
                for (int j = 1; j < s.length; j++) {
                    s[j] = s[j].replaceAll("\r", ""); //remover o caracter \r que esta presente em todas as linhas
                    if (s[j].contains("nome")) {
                        String clean = s[j].replaceAll("nome: ", "");
                        pr.setNome(clean);
                    } else if (s[j].contains("mac")) {
                        String clean = s[j].replaceAll("mac: ", "");
                        pr.setMac(clean);
                    } else if (s[j].contains("ipv4")) {
                        String clean = s[j].replaceAll("ipv4: ", "");
                        pr.setIpv4(clean);
                    } else if (s[j].contains("ipv6")) {
                        String clean = s[j].replaceAll("ipv6: ", "");
                        pr.setIpv6(clean);
                    }
                }
                if (pr.getNome() != null) { //se o nome não estiver nulo, adicionamos a uma lista
                    listaPlacaRede.add(pr);
                }
            }
        }
        return listaPlacaRede;
    }

    /**
     * Funcao para obter uma lista com todos os softwares instalados na maquina
     * local.(x64 e x32)
     * @param maquina
     * @return ArrayList com objetos Software preenchidos.
     */
    protected Set<SoftwaresMaquina> obterSoftwares(Maquina maquina) {

        Set<SoftwaresMaquina> lista_softwares32;
        Set<SoftwaresMaquina> lista_softwares64;

        //consultar os softwares x64 no registro do windows
        String softwares64 = ComunicacaoSO.lerDoRegedit("HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall", " /s /reg:64");

        //preencher objetos Software
        lista_softwares64 = obterListaDeSoftwares(softwares64, maquina);

        //consultar os softwares x32 no registro do windows
        String softwares32 = ComunicacaoSO.lerDoRegedit("HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall", " /s /reg:32");

        //preencher objetos Software
        lista_softwares32 = obterListaDeSoftwares(softwares32, maquina);

        //adicionar os resultados em um vetor so
        Set<SoftwaresMaquina> lista_softwares = new HashSet<>();
        lista_softwares.addAll(lista_softwares32);
        lista_softwares.addAll(lista_softwares64);

        return lista_softwares;
    }

    /**
     * Funcao para preencher objetos do tipo Software com base em uma string
     * vinda do regedit do windows. local.(x64 e x32)
     *
     * @param softwareStr string com arquivo de registro contendo softwares
     * @return ArrayList com objetos Software preenchidos.
     */
    protected Set<SoftwaresMaquina> obterListaDeSoftwares(String softwareStr, Maquina maquina) {

        String[] lines = softwareStr.split("HKEY_LOCAL_MACHINE"); //divide cada chave (software) em uma posicao do vetor

        Set<SoftwaresMaquina> softwares = new HashSet<SoftwaresMaquina>() {
        };

        for (int i = 0; i < lines.length; i++) {
            String[] s = lines[i].split("\n"); //divide cada linha do software em uma posicao do vetor, para poder pegar os dados
            if (s.length > 1) {
                Software sf = new Software();
                SoftwaresMaquina sm = new SoftwaresMaquina();
                for (int j = 1; j < s.length; j++) {
                    s[j] = s[j].replaceAll("\r", ""); //removing the \r from the line
                    s[j] = s[j].replaceAll("%", "\\\\"); //removing the % from the line because he cause conficts with postgres
                    if (s[j].contains("UninstallString")) {
                        String clean = s[j].replaceAll("UninstallString", "");
                        s[j] = clean; //cleaning the QuietUninstallString line because conflict with UninstallString
                        sf.setComandoDesinstalacao(cleanTrash((clean)));
                    }
                    if (s[j].contains("DisplayName_Localized")) {
                        s[j] = ""; // cleaning the DisplayName_Localized line because conflict with DisplayName                     
                    }
                    if (s[j].contains("DisplayName")) {
                        String clean = s[j].replaceAll("DisplayName", "");
                        sf.setNome(cleanTrash((clean)));
                    }
                    if (s[j].contains("DisplayVersion")) {
                        String clean = s[j].replaceAll("DisplayVersion", "");
                        sf.setVersao(cleanTrash((clean)));
                    }
                    if (s[j].contains("Publisher")) {
                        String clean = s[j].replaceAll("Publisher", "");
                        sf.setDesenvolvedor(cleanTrash((clean)));
                    }
                    if (s[j].contains("URLInfoAbout")) {
                        String clean = s[j].replaceAll("URLInfoAbout", "");
                        sf.setSiteDesenvolvedor(cleanTrash((clean)));
                    }
                    if (s[j].contains("HelpLink")) {
                        String clean = s[j].replaceAll("HelpLink", "");
                        sf.setSiteSoftware(cleanTrash((clean)));
                    }
                    if (s[j].contains("InstallDate")) {
                        String clean = s[j].replaceAll("InstallDate", "");
                        sm.setDtInstalacao(Util.formataDataCmd(cleanTrash((clean))));
                    }
                }
                if (sf.getNome() != null) { //se o nome não estiver nulo, adicionamos o software obtidos a uma lista de softwares                    
                    sm.setSoftware(sf);
                    sm.setInstalado(true);
                    sm.setDtUltimaDeteccao(controle.Util.getCurrentDate());
                    sm.setMaquina(maquina);
                    softwares.add(sm);
                    if (sf.getVersao() == null) {
                        sf.setVersao("--");
                    }
                }
            }

        }
        return softwares;
    }

    /**
     *
     * @param suja Sting com caracteres em branco e com o tipo de valor do
     * regedit (REG_SZ,REG_EXPAND_SZ)
     * @return String com o valor em formato amigavel
     */
    protected String cleanTrash(String suja) {
        String retorno = suja.replaceAll("REG_SZ", "");
        retorno = retorno.replaceAll("REG_EXPAND_SZ", "");
        retorno = retorno.replaceAll("Parent", "");
        retorno = retorno.replaceAll("            ", "");
        return retorno;
    }

    /**
     * Funcao para obter todas informacoes sobre a maquina local.
     *
     * @return Inventario
     */
    public Inventario fazerInventario() {
        //obter softwares
        String dataAtual = controle.Util.getCurrentTimestamp();
        Maquina maquina = obterMaquina();

        maquina.setSoftwaresMaquinas(obterSoftwares(maquina));

        maquina.setParticaos(obterParticoes(maquina));
        maquina.setPlacaRedes(obterPlacaRede(maquina));

        Inventario inventario = new Inventario(maquina, dataAtual);

        return inventario;
    }

}
