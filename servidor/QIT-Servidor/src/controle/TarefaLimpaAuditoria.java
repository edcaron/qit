package controle;

import dao.AuditoriaDAO;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TarefaLimpaAuditoria implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Tarefa para limpar auditoria chamada");
        AuditoriaDAO ad = new AuditoriaDAO();
        ad.chamarFuncaoLimpaAuditoria();
    }

}
