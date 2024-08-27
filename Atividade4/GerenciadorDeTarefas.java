import java.util.ArrayList;
import java.util.Iterator;

public class GerenciadorDeTarefas {
    private ArrayList<Tarefa> tarefas;

    // Construtor
    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    // Método para adicionar uma nova tarefa
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada: " + tarefa.getTitulo());
    }

    // Método para remover uma tarefa pelo título
    public void removerTarefa(String titulo) {
        Iterator<Tarefa> iterator = tarefas.iterator();
        while (iterator.hasNext()) {
            Tarefa tarefa = iterator.next();
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                iterator.remove();
                System.out.println("Tarefa removida: " + titulo);
                return;
            }
        }
        System.out.println("Tarefa não encontrada: " + titulo);
    }

    // Método para marcar uma tarefa como concluída
    public void marcarComoConcluida(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa.setConcluida(true);
                System.out.println("Tarefa marcada como concluída: " + titulo);
                return;
            }
        }
        System.out.println("Tarefa não encontrada: " + titulo);
    }

    // Método para listar todas as tarefas
    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa tarefa : tarefas) {
                String status = tarefa.isConcluida() ? "Concluída" : "Não Concluída";
                System.out.println(tarefa.getTitulo() + " - " + status + ": " + tarefa.getDescricao());
            }
        }
    }
}
