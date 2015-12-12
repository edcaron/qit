/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author eduar_000
 */
public class QITServidorMain {

    public static void main(String args[]) throws InterruptedException {

//          try {
//            ServidorSocket ss = new ServidorSocket(1234);
//        System.out.println("Servidor do servidor redecebeu uma conexão);
//        } catch (Exception e) {
//            System.out.println("Erro ao tentar aceitar conexao\n" + e);
//        }
//        PacoteSocket pacote = new PacoteSocket();
//        Tarefa tarefa = new Tarefa();
//        tarefa.setOperacao(1);
//        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
//        listaTarefas.add(tarefa);
//        pacote.setListaTarefas(listaTarefas);
//        PacoteSocket pacote = new PacoteSocket();
//        pacote.setId(1);
//        pacote.setTipo(2);        
//        Tarefa tarefa = new Tarefa();
//        tarefa.setOperacao(3);        
//        tarefa.setComando("\"C:\\Program Files (x86)\\Notepad++\\notepad++.exe\" \"C:\\QIT\\QIT-Agente\\softwares\\10\\qit.backup\"");        
//        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
//        listaTarefas.add(tarefa);
//        pacote.setListaTarefas(listaTarefas);
//                
//        ClienteSocket cs1 = new ClienteSocket("localhost", 1234);
//        cs1.enviarObjeto(pacote);        
//        cs1.pegarRetorno();
//        cs1.fecharConexao();
//        ClienteSocket cs2 = new ClienteSocket("10.3.9.20", 1234);
//        cs2.enviarObjeto(pacote);
//        cs2.pegarRetorno();
//        chamarTarefasAutomatizadas();
//        Inventario inventario = null;
//
//        XStream x = new XStream();
//        File arquivoXml = new File("C:\\QIT\\QIT-Agente\\inventario.xml");
//        Inventario inventario = (Inventario) x.fromXML(arquivoXml);
//
//        ControleInventario ci = new ControleInventario();
//        ci.gravarInventario(inventario);

        chamarTarefasAutomatizadas();
    }

    public static void chamarTarefasAutomatizadas() {
        try {
//            tarefa para limpar auditoria
            JobDetail tarefaLimpaAuditoria = JobBuilder.newJob(TarefaLimpaAuditoria.class)
                    .withIdentity("tarefaLimpaAuditoria", "grupo1").build();

            // executa a cada 24 horas
            Trigger triggerTarefaLimpaAuditoria = TriggerBuilder
                    .newTrigger()
                    .withIdentity("gatilhoLimpaAuditoria", "grupo1")
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInHours(24).repeatForever())
                    .build();

//            tarefa executar scripts
            JobDetail tarefaExecutaScrits = JobBuilder.newJob(TarefaExecutaScripts.class)
                    .withIdentity("tarefaExecutaScrits", "grupo1").build();

            // executa a cada 1 minuto
            Trigger triggerExecutaScrits = TriggerBuilder
                    .newTrigger()
                    .withIdentity("triggerExecutaScrits", "grupo1")
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInMinutes(1).repeatForever())
                    .build();

//            tarefa para executar inventario
            JobDetail tarefaExecutaInventario = JobBuilder.newJob(TarefaExecutaInventario.class)
                    .withIdentity("tarefaExecutaInventario", "grupo1").build();

            // executa a cada 2 horas
            Trigger triggerExecutaInventario = TriggerBuilder
                    .newTrigger()
                    .withIdentity("triggerExecutaInventario", "grupo1")
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInMinutes(1).repeatForever())
                    .build();

            // agendar as tarefas
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//            scheduler.scheduleJob(tarefaLimpaAuditoria, triggerTarefaLimpaAuditoria);
            scheduler.scheduleJob(tarefaExecutaScrits, triggerExecutaScrits);
            scheduler.scheduleJob(tarefaExecutaInventario, triggerExecutaInventario);

            scheduler.start();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
