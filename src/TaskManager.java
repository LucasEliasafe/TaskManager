import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String name) {
        tasks.add(new Task(name));
        System.out.println("Tarefa adicionada com sucesso!");
    }


}

