import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

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

    public void listTaskByPriority(String priority) {
        System.out.println("Tarefas com prioridade " + priority + ":");
        for (Task task : tasks) {
            if (task.getPriority().equals(priority)) {
                System.out.println(task + "\n");
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

    public void editTaskName(int index, String newName) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Inválido!");
        } else {
            tasks.get(index).setName(newName);
            System.out.println("Nome da tarefa editada com sucesso!");
        }
    }

    public void editTaskDescription(int index, String newDescription) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Inválido!");
        } else {
            tasks.get(index).setDescription(newDescription);
            System.out.println("Nome da descrição editada com sucesso!");
        }
    }

    public void editTaskPriority(int index, String newPriority) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Inválido!");
        } else {
            tasks.get(index).setPriority(newPriority);
            System.out.println("Nome da prioridade editada com sucesso!");
        }
    }

    public void saveTasksToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tasks);
            System.out.println("Tarefas salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTasksFromFile(String filename) {
        try (ObjectInputStream  ois = new ObjectInputStream(new FileInputStream(filename))) {
            tasks = (ArrayList<Task>) ois.readObject();
            System.out.println("Tarefas carregadas com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar tarefas: " + e.getMessage());
        }
    }

    public void addRecurringTask(String name, String description, String priority, String recurrencePattern, LocalDate nextDueDate) {
        tasks.add(new RecurringTask(name, description, priority, recurrencePattern, nextDueDate));
        System.out.println("Tarefa recorrente adicionada com sucesso!");
    }


    public void searchTasks(String keyword) {
        System.out.println("Resultados da busca por: " + keyword);
        for (Task task : tasks) {
            if (task.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task + "\n");
            }
        }
    }
}

