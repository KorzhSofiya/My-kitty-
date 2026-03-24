package Pract_10;

import java.util.Comparator;
import java.util.List;

public class LambdaRefactorLab {
    public static void sortAnonymous(List<Event> events) {
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getDurationMinutes().compareTo(e2.getDurationMinutes());
            }
        });
    }
    public static void sortLambda(List<Event> events) {
        events.sort((e1, e2) -> e1.getDurationMinutes().compareTo(e2.getDurationMinutes()));
    }
    public static void sortMethodRef(List<Event> events) {
        events.sort(Comparator.comparing(Event::getDurationMinutes));
    }
}
