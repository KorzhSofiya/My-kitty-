package Pract_10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){
        ZoneId kyivZone = ZoneId.of("Europe/Kyiv");
        Event event1 = new Event(
                "first", kyivZone,
                Duration.ofMinutes(90),
                LocalDateTime.of(2026, 3, 25, 10, 0),
                "event1"

        );

        Event event2 = new Event(
                "second",kyivZone,
                Duration.ofHours(2),
                LocalDateTime.of(2026, 3, 25, 13, 30),
                "event2"
        );
        Event event3 = new Event(
                "third",kyivZone,
                Duration.ofHours(5),
                LocalDateTime.of(2026, 12, 31, 23, 0),
                "event2"
        );

//        System.out.println(event1.label());
//        System.out.println("Ends at: " + event1.end());
//        System.out.println("Ends at: " + event2.end());
//        System.out.println("Ends at: " + event3.end());
//
        List<Event> events = Arrays.asList(
                new Event("Backend Track", kyivZone, Duration.ofMinutes(90),
                        LocalDateTime.of(2026, 3, 25, 10, 0), "ev1"),
                new Event("Frontend Track", kyivZone, Duration.ofMinutes(60),
                        LocalDateTime.of(2026, 3, 25, 11, 0), "ev2"),
                new Event("Backend Track", kyivZone, Duration.ofMinutes(120),
                        LocalDateTime.of(2026, 3, 25, 14, 0), "ev3"),
                new Event("Soft Skills", kyivZone, Duration.ofMinutes(45),
                        LocalDateTime.of(2026, 3, 25, 9, 0), "ev4")
        );
//
//        Predicate<Event> isMorning = event -> event.getStart().getHour() < 12;
//        Predicate<Event> isBackend = event -> event.getTrack().equals("Backend Track");
//        Predicate<Event> morningBackend = isMorning.and(isBackend);
//        Predicate<Event> notMorning = isMorning.negate();
//
//        System.out.println("--- Ранкові Backend події ---");
//        List<Event> filteredEvents = EventLab.pick(events, isMorning);
//        EventLab.notifyAll(filteredEvents, event -> System.out.println(event.getTitle()));
//        System.out.println();
//        System.out.println("--- Генерація ярликів (Labels) ---");
//        List<String> eventLabels = EventLab.labels(events,
//                event -> event.getTitle() + " (" + event.getDurationMinutes().toMinutes() + " хв)"
//        );
//        eventLabels.forEach(System.out::println);
//        System.out.println();
//        EventLab.findConflicts(events);
//        System.out.println("---Створення Event (Supplier)");
//        Supplier<Event> eventSupplier = () -> new Event("Backend Track", kyivZone, Duration.ofMinutes(120)
//                , LocalDateTime.of(1998, 12, 8, 16, 30), "evSup");
//        EventLab.create(eventSupplier);
//        System.out.println(EventLab.create(eventSupplier));
        List<Event> eventAnon = new ArrayList<>(events);
        LambdaRefactorLab.sortAnonymous(eventAnon);
        EventLab.notifyAll(eventAnon, e-> System.out.println(e.label()));
        System.out.println();
        List<Event> eventLam = new ArrayList<>(events);
        LambdaRefactorLab.sortLambda(eventLam);
        EventLab.notifyAll(eventLam, e-> System.out.println(e.label()));
        System.out.println();
        List<Event> eventRef= new ArrayList<>(events);
        LambdaRefactorLab.sortMethodRef(eventRef);
        EventLab.notifyAll(eventRef, e-> System.out.println(e.label()));
        System.out.println();

    }
}