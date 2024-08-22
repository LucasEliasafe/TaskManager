import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskManagerGUI extends JFrame {
    private TaskManager taskManager;

    public TaskManagerGUI() {
        taskManager = new TaskManager();
        setTitle("Gerenciador de Tarefas");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 3));


        String[] buttonLabels = {
                "1. Adicionar Tarefa",
                "2. Listar Tarefas",
                "3. Editar Tarefa",
                "4. Remover Tarefa",
                "5. Buscar Tarefa",
                "6. Marcar Tarefa como Concluída",
                "7. Desmarcar Tarefa Concluída",
                "8. Listar Tarefas Concluídas",
                "9. Priorizar Tarefa",
                "10. Listar Tarefas por Prioridade",
                "11. Buscar por Palavra-Chave",
                "12. Adicionar Tarefa Recorrente",
                "13. Sair"
        };


        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            final int index = i;
            button.addActionListener(e -> handleButtonAction(index + 1));
            add(button);
        }

        setVisible(true);
    }

    private void handleButtonAction(int option) {
        switch (option) {
            case 1:
                showAddTaskScreen();
                break;
            case 2:
                showListTasksScreen();
                break;
            case 3:
                showEditTaskScreen();
                break;
            case 13:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opção não implementada ainda.");
        }
    }

    private void showAddTaskScreen() {
        JFrame addTaskFrame = new JFrame("Adicionar Tarefa");
        addTaskFrame.setSize(400, 300);
        addTaskFrame.setLayout(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField priorityField = new JTextField();

        addTaskFrame.add(new JLabel("Nome:"));
        addTaskFrame.add(nameField);
        addTaskFrame.add(new JLabel("Descrição:"));
        addTaskFrame.add(descriptionField);
        addTaskFrame.add(new JLabel("Prioridade:"));
        addTaskFrame.add(priorityField);

        JButton addButton = new JButton("Adicionar");
        addTaskFrame.add(addButton);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String description = descriptionField.getText();
            String priority = priorityField.getText();
            taskManager.addTask(name, description, priority); // Chama o método de TaskManager

            JOptionPane.showMessageDialog(addTaskFrame, "Tarefa adicionada: " + name);
            addTaskFrame.dispose();
        });

        addTaskFrame.setVisible(true);
    }

    private void showListTasksScreen() {
        JFrame listTasksFrame = new JFrame("Listar Tarefas");
        listTasksFrame.setSize(400, 300);
        listTasksFrame.setLayout(new BorderLayout());

        JTextArea taskListArea = new JTextArea();
        for (String task : taskManager.getTasks()) { // Obtém a lista de tarefas da TaskManager
            taskListArea.append(task + "\n");
        }

        listTasksFrame.add(new JScrollPane(taskListArea), BorderLayout.CENTER);
        listTasksFrame.setVisible(true);
    }

    private void showEditTaskScreen() {
        JFrame editTaskFrame = new JFrame("Editar Tarefa");
        editTaskFrame.setSize(400, 300);
        editTaskFrame.setLayout(new GridLayout(4, 2));

        JTextField taskIdField = new JTextField();
        JTextField newNameField = new JTextField();
        JTextField newDescriptionField = new JTextField();
        JTextField newPriorityField = new JTextField();

        editTaskFrame.add(new JLabel("ID da Tarefa:"));
        editTaskFrame.add(taskIdField);
        editTaskFrame.add(new JLabel("Novo Nome:"));
        editTaskFrame.add(newNameField);
        editTaskFrame.add(new JLabel("Nova Descrição:"));
        editTaskFrame.add(newDescriptionField);
        editTaskFrame.add(new JLabel("Nova Prioridade:"));
        editTaskFrame.add(newPriorityField);

        JButton editButton = new JButton("Editar");
        editTaskFrame.add(editButton);

        editButton.addActionListener(e -> {
            int taskId = Integer.parseInt(taskIdField.getText());
            String newName = newNameField.getText();
            String newDescription = newDescriptionField.getText();
            String newPriority = newPriorityField.getText();
            taskManager.editTask(taskId, newName, newDescription, newPriority); // Chama o método de TaskManager

            JOptionPane.showMessageDialog(editTaskFrame, "Tarefa editada: " + newName);
            editTaskFrame.dispose();
        });

        editTaskFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagerGUI());
    }
}
