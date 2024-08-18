import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String name, String description, String priority) {
        tasks.add(new Task(name, description, priority));
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.print("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("Tarefas cadastradas:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i) + "\n");
            }
        }
    }



    public void marktaskCompleted(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Inválido");
        } else {
            tasks.get(index).markCompleted();
            System.out.println("Tarefa finalizada com sucesso!");
        }
    }

    public void removeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Inválida");
        } else {
            tasks.remove(index);
            System.out.println("Tarefa removida com sucesso!");
        }
    }
}

