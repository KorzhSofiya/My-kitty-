package Pr_9;

import java.time.LocalDate;

public class Ticket {
    private int priority;
    private LocalDate createdAt;

    public Ticket(int priority, LocalDate createdAt) {
        this.priority = priority;
        this.createdAt = createdAt;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
