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
            System.out.println("3. Marcar uma tarefa como concluída");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Tarefa inserida com sucesso!");

            }
        }
    }
}