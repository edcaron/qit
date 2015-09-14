package regedit;

import modelo.Software;
import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.Inventario;
import modelo.Maquina;
import modelo.Particao;
import modelo.PlacaRede;

public class WindowsReqistry {

    /**
     * Funcao para fazer uma pesquisa no arquivo de registro do windows
     *
     * @param location path in the registry
     * @param parameters parameters for the reg query on cmd
     * @return String com conteudo retornado pelo processo
     */
    public static String readRegistry(String location, String parameters) {
        try {
            // Run reg query, then read output with StreamReader (internal class)
            String cmd = "reg query " + location + " " + parameters;
            System.out.println("comando: " + cmd);
            Process process = Runtime.getRuntime().exec(cmd);

            StreamReader reader = new StreamReader(process.getInputStream());
            reader.start();
            process.waitFor();
            reader.join();
            String output = reader.getResult();

            return output;
        } catch (IOException | InterruptedException e) {
            System.err.println("erro em readRegistry /n" + e);
            return null;
        }
    }

    /**
     * Funcao para executar qualquer tipo de comando no CMD do windows
     *
     * @param comando programa ou comando a ser executado
     * @param parametro parametros adicionais para o comando enviado
     * anteriormente
     * @return String com o retorno dado pelo cmd
     */
    protected static String executarComando(String comando, String parametro) {
        try {

            // executar comando no cmd
            String cmd = comando + parametro;
            System.out.println("comando: " + cmd);
            Process process = Runtime.getRuntime().exec(cmd);

            StreamReader reader = new StreamReader(process.getInputStream());
            reader.start();
            process.waitFor();
            reader.join();
            String output = reader.getResult();

            return output;
        } catch (IOException | InterruptedException e) {
            System.err.println("erro em executarComando /n" + e);
            return null;
        }
    }

    protected static class StreamReader extends Thread {

        private InputStream is;
        private StringWriter sw = new StringWriter();

        public StreamReader(InputStream is) {
            this.is = is;
        }

        public void run() {
            try {
                int c;
                while ((c = is.read()) != -1) {
                    sw.write(c);
                }
            } catch (IOException e) {
                System.err.println("erro em static class StreamReader extends Thread \n" + e);
            }
        }

        public String getResult() {
            return sw.toString();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        XStream xstream = new XStream();

        try {
            try (OutputStream output = new FileOutputStream("C:\\QIT\\QIT-Agente\\inventario.xml")) {
                xstream.toXML(fazerInventario(), output);
            }
        } catch (IOException e) {
            System.err.println(""+e);            
        }
//        ArrayList<PlacaRede> listaPlacaRede = obterPlacaRede();
//        for (int i = 0; i < listaPlacaRede.size(); i++) {
//            System.out.println("{ ");
//            System.out.println("nome " + listaPlacaRede.get(i).getNome());
//            System.out.println("mac " + listaPlacaRede.get(i).getMac());
//            System.out.println("ipv4 " + listaPlacaRede.get(i).getIpv4());
//            System.out.println("ipv6 " + listaPlacaRede.get(i).getIpv6());
//            System.out.println("}");
//        }
//        ArrayList<Particao> listaParticoes = obterParticoes();
//        for (int i = 0; i < listaParticoes.size(); i++) {
//            System.out.println("{ ");
//            System.out.println("hd " + listaParticoes.get(i).getNomeHd());
//            System.out.println("letra " + listaParticoes.get(i).getLetra());
//            System.out.println("volume " + listaParticoes.get(i).getNomeVolume());
//            System.out.println("formato " + listaParticoes.get(i).getFormato());
//            System.out.println("tamanho " + listaParticoes.get(i).getEspaco());
//            System.out.println("livre " + listaParticoes.get(i).getEspacoLivre());
//            System.out.println("}");
//        }
//        ArrayList<Software> softwares = new ArrayList<>();
//        softwares = obterSoftwares();
        //
//        System.out.println("user " + mq.getUsuarioConectado());
//        System.out.println("dominio " + mq.getDominio());
//        System.out.println("host " + mq.getHost());
//        System.out.println("memoria " + mq.getMemoriaTotal());
//        System.out.println("faricantePC " + mq.getFabicantePc());
//        System.out.println("modeloPC " + mq.getModeloPc());
//        System.out.println("so " + mq.getSo());
//        System.out.println("arquit " + mq.getArquiteturaso());
//        System.out.println("versao " + mq.getVersaoSo());
//        System.out.println("sp " + mq.getSpSo());
//        System.out.println("fabSO " + mq.getFabricanteSo());
//        System.out.println("rootso " + mq.getRootSo());
//        System.out.println("bios " + mq.getBios());
//        System.out.println("cpu " + mq.getCpu());
//        System.out.println("nucleos " + mq.getNucleosCpu());
//        System.out.println("fabCPU " + mq.getFabricanteCpu());
//        for (int i = 0; i < softwares.size(); i++) {
//            System.out.println("{ ");
//            System.out.println("nome " + softwares.get(i).getDisplayName());
//            System.out.println("versao " + softwares.get(i).getDisplayVersion());
//            System.out.println("helpkink " + softwares.get(i).getHelpLink());
//            if (softwares.get(i).getInstallDate() != null) {
//                System.out.println("dt_inst " + softwares.get(i).getInstallDate().toString());
//            } else {
//                System.out.println("dt_inst = null");
//            }
//
//            System.out.println("publisher " + softwares.get(i).getPublisher());
//            System.out.println("comando Normal " + softwares.get(i).getUninstallString());
//            System.out.println("comando Silent " + softwares.get(i).getQuietUninstallString());
//            System.out.println("info " + softwares.get(i).getUrlInfoAbout());
//            System.out.println("}");
//        }
    }

    /**
     * Funcao para obter informacoes sobre wardware e sistema operacional da
     * maquina local
     *
     * @return Maquina com atributos preenchidos
     */
    protected static Maquina obterMaquina() {
        Maquina mq = new Maquina();

        //executar o script VBS que obtem informacoes sobre o pc e colocar em uam string
        String strMaquina = executarComando("cscript C:\\QIT\\QIT-Agente\\vbs\\obterInventario.vbs", "");

        //colocar as informacoes no objeto Maquina
        String[] s = strMaquina.split("\n");
        if (s.length > 1) {
            for (String item : s) {
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
                    mq.setFabicantePc(clean);
                } else if (item.contains("modelo")) {
                    String clean = item.replaceAll("modelo: ", "");
                    mq.setModeloPc(clean);
                } else if (item.contains("sistema_operacional")) {
                    String clean = item.replaceAll("sistema_operacional: ", "");
                    mq.setSo(clean);
                } else if (item.contains("arquitetura")) {
                    String clean = item.replaceAll("arquitetura: ", "");
                    mq.setArquiteturaso(clean);
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
     * Funcao para obter uma lista com particoes da maquina local.
     *
     * @return ArrayList com objetos Particao preenchido.
     */
    protected static ArrayList<Particao> obterParticoes() {
        //executar o script VBS que obtem informacoes sobre o pc e colocar em uam string
        String strParticoes = executarComando("cscript C:\\QIT\\QIT-Agente\\vbs\\obterParticoes.vbs", "");

        String[] lines = strParticoes.split("___");//divide cada particao em uma posicao do vetor. Quando encontrar o carac '___' inicia uma nova particao

        ArrayList<Particao> listaParticoes = new ArrayList();

        for (String line : lines) {
            String[] s = line.split("\n"); //divide cada linha de cada posição do vetor de particoes em uma posicao de outro vetor, para poder pegar os dados
            if (s.length > 0) {
                Particao part = new Particao();
                for (int j = 1; j < s.length; j++) {
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
                        part.setEspaco(clean);
                    } else if (s[j].contains("espaco_livre")) {
                        String clean = s[j].replaceAll("espaco_livre: ", "");
                        part.setEspacoLivre(clean);
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
     * Funcao para obter uma lista com placas de rede da maquina local.
     *
     * @return ArrayList com objetos Maquina preenchida.
     */
    protected static ArrayList<PlacaRede> obterPlacaRede() {
        //executar o script VBS que obtem informacoes sobre o pc e colocar em uam string
        String strParticoes = executarComando("cscript C:\\QIT\\QIT-Agente\\vbs\\obterRede.vbs", "");

        String[] lines = strParticoes.split("___");//divide cada particao em uma posicao do vetor. Quando encontrar o carac '___' inicia uma nova particao

        ArrayList<PlacaRede> listaPlacaRede = new ArrayList();

        for (String line : lines) {
            String[] s = line.split("\n"); //divide cada linha de cada posição do vetor de particoes em uma posicao de outro vetor, para poder pegar os dados
            if (s.length > 0) {
                PlacaRede pr = new PlacaRede();
                for (int j = 1; j < s.length; j++) {
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
     *
     * @return ArrayList com objetos Software preenchidos.
     */
    protected static ArrayList<Software> obterSoftwares() {

        ArrayList<Software> lista_softwares32;
        ArrayList<Software> lista_softwares64;

        //consultar os softwares x64 no registro do windows
        String softwares64 = WindowsReqistry.readRegistry("HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall", " /s /reg:64");

        //preencher objetos Software
        lista_softwares64 = obterListaDeSoftwares(softwares64);

        //consultar os softwares x32 no registro do windows
        String softwares32 = WindowsReqistry.readRegistry("HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall", " /s /reg:32");

        //preencher objetos Software
        lista_softwares32 = obterListaDeSoftwares(softwares32);

        //adicionar os resultados em um vetor so
        ArrayList<Software> lista_softwares = new ArrayList<>();
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
    protected static ArrayList<Software> obterListaDeSoftwares(String softwareStr) {

        String[] lines = softwareStr.split("HKEY_LOCAL_MACHINE"); //divide cada chave (software) em uma posicao do vetor

        ArrayList<Software> softwares = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String[] s = lines[i].split("\n"); //divide cada linha do software em uma posicao do vetor, para poder pegar os dados
            if (s.length > 1) {
                Software sf = new Software();
                for (int j = 1; j < s.length; j++) {
                    if (s[j].contains("QuietUninstallString")) {
                        String clean = s[j].replaceAll("QuietUninstallString", "");
                        s[j] = clean; //cleaning the QuietUninstallString line because conflict with UninstallString
                        sf.setQuietUninstallString(cleanTrash((clean)));
                    }
                    if (s[j].contains("DisplayName")) {
                        String clean = s[j].replaceAll("DisplayName", "");
                        sf.setDisplayName(cleanTrash((clean)));
                    }
                    if (s[j].contains("DisplayVersion")) {
                        String clean = s[j].replaceAll("DisplayVersion", "");
                        sf.setDisplayVersion(cleanTrash((clean)));
                    }
                    if (s[j].contains("Publisher")) {
                        String clean = s[j].replaceAll("Publisher", "");
                        sf.setPublisher(cleanTrash((clean)));
                    }
                    if (s[j].contains("UninstallString")) {
                        String clean = s[j].replaceAll("UninstallString", "");
                        sf.setUninstallString(cleanTrash((clean)));
                    }
                    if (s[j].contains("URLInfoAbout")) {
                        String clean = s[j].replaceAll("URLInfoAbout", "");
                        sf.setUrlInfoAbout(cleanTrash((clean)));
                    }
                    if (s[j].contains("HelpLink")) {
                        String clean = s[j].replaceAll("HelpLink", "");
                        sf.setHelpLink(cleanTrash((clean)));
                    }
                    if (s[j].contains("InstallDate")) {
                        String clean = s[j].replaceAll("InstallDate", "");
                        sf.setInstallDate(formataDataCmd(cleanTrash((clean))));
                    }
                }
                if (sf.getDisplayName() != null) { //se o nome não estiver nulo, adicionamos o software obtidos a uma lista de softwares
                    softwares.add(sf);
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
    protected static String cleanTrash(String suja) {
        String retorno = suja.replaceAll("REG_SZ", "");
        retorno = retorno.replaceAll("REG_EXPAND_SZ", "");
        retorno = retorno.replaceAll("Parent", "");
        retorno = retorno.replaceAll("            ", "");
        return retorno;
    }

    /**
     *
     * @param data Sting com data vinda do cmd
     * @return Date do java
     */
    protected static Date formataDataCmd(String data) {
        Date date = null;
        if ((data != null) && data.length() == 9) {
            try {
                String dataF = "" + data.charAt(6) + data.charAt(7) + "-" + data.charAt(4) + data.charAt(5) + "-" + data.charAt(0) + data.charAt(1) + data.charAt(2) + data.charAt(3);
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                date = new Date(format.parse(dataF).getTime());

            } catch (Exception e) {
                System.err.println("Erro em formataDataCmd: " + e);
            }
        }
        return date;
    }

    /**
     * Funcao para obter todas informacoes sobre a maquina local.
     *
     * @return Inventario
     */
    private static Inventario fazerInventario() {
        //obter softwares
        ArrayList<Software> listaSoftwares = obterSoftwares();
        ArrayList<Particao> listaParticoes = obterParticoes();
        ArrayList<PlacaRede> listaPlacaRede = obterPlacaRede();
        Maquina maquina = obterMaquina();
        String dataAtual = modelo.Util.getCurrentDate();
        Inventario inventario = new Inventario(maquina, dataAtual, listaParticoes, listaPlacaRede, listaSoftwares);

        return inventario;
    }

}