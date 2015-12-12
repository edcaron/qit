package controle;

import java.util.ArrayList;
import modelo.ExecucaoScript;
import modelo.MaquinasExecutarScript;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TarefaExecutaScripts implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Tarefa para mandar os clientes executarem scripts chamada");
        ControleExecutarScript ces = new ControleExecutarScript();
        ExecucaoScript es = new ExecucaoScript();
        ArrayList<ExecucaoScript> lista = ces.listar(es, "and executado != true ");

        for (ExecucaoScript ec : lista) {
            System.out.println("Script:" + ec.getScript().getNome());
            for (MaquinasExecutarScript mes : ec.getMaquinasExecutarScripts()) {
                System.out.println(mes.getMaquina().getHost());
                new ChamaAgenteSocket().executarScriptNoCliente(mes, mes.getMaquina(), ec.getScript());
            }
        }
    }

}
