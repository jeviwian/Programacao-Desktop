import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Gerenciamento de Tarefas");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Listar Tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    Tarefa novaTarefa = new Tarefa(titulo, descricao);
                    gerenciador.adicionarTarefa(novaTarefa);
                    break;
                case 2:
                    System.out.print("Digite o título da tarefa a ser removida: ");
                    String tituloRemover = scanner.nextLine();
                    gerenciador.removerTarefa(tituloRemover);
                    break;
                case 3:
                    System.out.print("Digite o título da tarefa a ser marcada como concluída: ");
                    String tituloConcluir = scanner.nextLine();
                    gerenciador.marcarComoConcluida(tituloConcluir);
                    break;
                case 4:
                    System.out.println("Lista de Tarefas:");
                    gerenciador.listarTarefas();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}
