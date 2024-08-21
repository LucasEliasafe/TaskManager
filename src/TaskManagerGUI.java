import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskManagerGUI extends JFrame {

    public TaskManagerGUI() {
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
            add(button);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagerGUI());
    }
}