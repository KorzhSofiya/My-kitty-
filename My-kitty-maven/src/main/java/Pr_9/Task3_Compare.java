package Pr_9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task3_Compare {
    //nested comp
    public static class PriorityComparator implements Comparator<Ticket>{
        @Override
        public int compare(Ticket t1, Ticket t2){
            return Integer.compare(t1.getPriority(), t2.getPriority());
        }
    }
    //anon
    List<Ticket> tickets = new ArrayList<>(List.of(new Ticket(1, LocalDate.now().minusDays(3)),
            new Ticket(2, LocalDate.now().minusDays(2)), new Ticket(3, LocalDate.now().minusDays(3))));
    tickets.sort(new Comparator<Ticket>){
        @Override
                public int compare(Ticket t1, Ticket )
    }
    //method reference
    public static final Comparator<Ticket> BY_PRIORITY = Comparator.comparingInt(Ticket::getPriority);
    public static final Comparator<Ticket> BY_CREATED_AT = Comparator.comparing(Ticket::getCreatedAt);
    //kombain
    public static final Comparator<Ticket> PRIORITY_THEN_CREATED_AT = Comparator.comparing(Ticket::getPriority).thenComparing(Ticket::getCreatedAt);

}
