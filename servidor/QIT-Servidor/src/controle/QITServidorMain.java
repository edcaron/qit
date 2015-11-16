/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.PacoteSocket;
import modelo.Tarefa;
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
        
        PacoteSocket pacote = new PacoteSocket();
        Tarefa tarefa = new Tarefa();
        tarefa.setOperacao(1);
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
        listaTarefas.add(tarefa);
        pacote.setListaTarefas(listaTarefas);
                
//        ClienteSocket cs1 = new ClienteSocket("localhost", 1234);
//        cs1.enviarObjeto(pacote);
//        cs1.pegarRetorno();
        
        ClienteSocket cs2 = new ClienteSocket("10.3.9.20", 1234);
        cs2.enviarObjeto(pacote);
        cs2.pegarRetorno();


//        chamarTarefasAutomatizadas();
//        Inventario inventario = null;
//
//        XStream x = new XStream();
//        File arquivoXml = new File("C:\\QIT\\QIT-Agente\\inventario.xml");
//        inventario = (Inventario) x.fromXML(arquivoXml);
//        
//        ControleInventario ci = new ControleInventario();
//        ci.gravarInventario(inventario);
    }

    public static void chamarTarefasAutomatizadas() {

        try {
            JobDetail job = JobBuilder.newJob(TarefaLimpaAuditoria.class)
                    .withIdentity("tarefaLimpaAuditoria", "grupo1").build();

            // executa a cada 24 horas
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("gatilhoLimpaAuditoria", "grupo1")
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInHours(24).repeatForever())
                    //                            .withIntervalInSeconds(2).repeatForever())
                    .build();

            // schedule it
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
