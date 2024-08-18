import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        int option;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Inserir uma nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Listar tarefas por prioridade");
            System.out.println("4. Marcar tarefa como concluída");
            System.out.println("5. Remover tarefa");
            System.out.println("6. Editar nome da tarefa");
            System.out.println("7. Editar descrição da tarefa");
            System.out.println("8. Editar prioridade da tarefa");
            System.out.println("9. Sair");
            System.out.println("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = scanner.nextLine();
                    System.out.print("Digite a prioridade da tarefa: ");
                    String priority = scanner.nextLine();
                    taskManager.addTask(name, description, priority);
                    break;
                case 2:
                    taskManager.listTasks();
                    break;
                case 3:
                    System.out.print("Digite a prioridade a filtrar");
                    int completeIndex = scanner.nextInt() - 1;
                    taskManager.marktaskCompleted(completeIndex);
                    break;
                case 4:
                    System.out.println("Digite o número da tarefa a ser removida: ");
                    int removeIndex = scanner.nextInt() - 1;
                    taskManager.removeTask(removeIndex);
                    break;
                case 5:
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente!");
            }
        } while (option != 5);
        scanner.close();
    }
}