import java.time.LocalDate;


public class RecurringTask extends Task {
    private String recurrencePattern;
    private LocalDate nextDueDate;


    public RecurringTask(String nome, String descrição, String prioridade, String recurrencePattern, LocalDate nextDueDate) {
        super(nome, descrição, prioridade);
        this.recurrencePattern = recurrencePattern;
        this.nextDueDate = nextDueDate;
    }

    public String getRecurrencePattern() {
        return recurrencePattern;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public void updateNextDueDate() {
        switch(recurrencePattern.toLowerCase()) {
            case "diária":
                nextDueDate = nextDueDate.plusDays(1);
                break;
            case "semanal":
                nextDueDate = nextDueDate.plusWeeks(1);
                break;
            case "mensal":
                nextDueDate = nextDueDate.plusMonths(1);
                break;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRecorrência: " + recurrencePattern +
                "\nPróxima Data: " + nextDueDate;
    }
}
