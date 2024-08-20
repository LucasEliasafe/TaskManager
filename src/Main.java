import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        int option;

        taskManager.loadTasksFromFile("tasks.dat");

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
            System.out.println("9. Salvar tarefas");
            System.out.println("10. Carregar tarefas");
            System.out.println("11. Buscar tarefas");
            System.out.println("12. Adicionar tarefa recorrente");
            System.out.println("13. Sair");
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
                    System.out.print("Digite a prioridade a filtrar (Alta, Média, Baixa): ");
                    String filterPriority = scanner.nextLine();
                    taskManager.listTaskByPriority(filterPriority);
                    break;
                case 4:
                    System.out.print("Digite o número da tarefa a ser marcada como concluída: ");
                    int completeIndex = scanner.nextInt() - 1;
                    taskManager.marktaskCompleted(completeIndex);
                    break;
                case 5:
                    System.out.print("Digite o número da tarefa a ser removida: ");
                    int removeIndex = scanner.nextInt() - 1;
                    taskManager.removeTask(removeIndex);
                    break;
                case 6:
                    System.out.print("Digite o número da tarefa a ser editada: ");
                    int editIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.print("Digite o novo nome da tarefa: ");
                    String newName = scanner.nextLine();
                    taskManager.editTaskName(editIndex, newName);
                    break;
                case 7:
                    System.out.print("Digite o número da tarefa a ser editada: ");
                    int editDescIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.print("Digite a nova descrição da tarefa: ");
                    String newDescription = scanner.nextLine();
                    taskManager.editTaskDescription(editDescIndex, newDescription);
                    break;
                case 8:
                    System.out.print("Digite o nome da tarefa a ser editada: ");
                    int editPriorityIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.print("Digite a nova prioridade da tarefa (Alta, Médio, Baixa): ");
                    String newPriority = scanner.nextLine();
                    taskManager.editTaskPriority(editPriorityIndex, newPriority);
                    break;
                case 9:
                    taskManager.saveTasksToFile("tasks.dat");
                    break;
                case 10:
                    taskManager.loadTasksFromFile("tasks.dat");
                    break;
                case 11:
                    System.out.print("Digite a palavra-chave para buscar: ");
                    String keyword = scanner.nextLine();
                    taskManager.searchTasks(keyword);
                    break;
                case 12:
                    System.out.print("Digite o nome da tarefa recorrente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descrição = scanner.nextLine();
                    System.out.print("Digite a prioridade da tarefa (Alta, Média, Baixa): ");
                    String prioridade = scanner.nextLine();
                    System.out.print("Digite o padrão de recorrência (Diária, Semanal, Mensal): ");
                    String recurrencePattern = scanner.nextLine();

                    try {
                        System.out.print("Digite a data da próxima ocorrência (YYYY-MM-DD): ");
                        LocalDate nextDueDate = LocalDate.parse(scanner.nextLine());
                        taskManager.addRecurringTask(nome, descrição, prioridade, recurrencePattern, nextDueDate);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido! Por favor, use o formato YYYY-MM-DD.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente!");
            }
        } while (option != 13);
        scanner.close();
    }
}