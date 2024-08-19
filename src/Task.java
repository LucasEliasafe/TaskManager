import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private boolean isCompleted;
    private String description;
    private String priority;

    public Task(String name, String description, String priority) {
        this.name = name;
        this.isCompleted = false;
        this.description = description;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted(){
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "Tarefa: " + name +
                "\nDescrição: " + description +
                "\nPrioridade: " + priority +
                "\nStatus: " + (isCompleted ? "Concluída" : "Pendente");
    }
}
