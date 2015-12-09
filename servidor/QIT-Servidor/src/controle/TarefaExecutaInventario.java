package controle;

import dao.MaquinaDAO;
import java.util.ArrayList;
import modelo.Maquina;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TarefaExecutaInventario implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Tarefa para mandar os clientes fazer inventario chamada");
        MaquinaDAO mdao = new MaquinaDAO();
        ArrayList<Maquina> listaMaquina = mdao.listar(" and ativo = true");
        
        for (Maquina m : listaMaquina) {
            new ChamaAgenteSocket().executarInventarioNoCliente(m);
        }
    }

}
