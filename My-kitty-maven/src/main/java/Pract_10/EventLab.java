package Pract_10;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EventLab {
    public static List<Event> pick(List<Event> events, Predicate<Event> pred){
        List<Event> result = new ArrayList<>();
        for(Event e :events){
            if(pred.test(e))
                result.add(e);
        }
        return result;
    }
    public static List<String> labels(List<Event> events, Function<Event, String> lable){
        List<String> result = new ArrayList<>();
        for(Event e :events){
            result.add(lable.apply(e));
        }
        return result;
    }
    public static void notifyAll(List<Event> events, Consumer<Event> consumator){
        for (Event e : events) {
            consumator.accept(e);
        }
    }
    public static Event create(Supplier<Event> eventSupplier){
        return eventSupplier.get();
    }
    public static void findConflicts(List<Event> events){
        System.out.println("checking for conflicts");
        boolean conf = false;
        for(int i = 0; i<events.size(); i++){
            for(int j = i+1; j<events.size(); j++){
                Event ev1 = events.get(i);
                Event ev2  = events.get(j);
                ZonedDateTime start1 = ZonedDateTime.of(ev1.getStart(), ev1.getZone());
                ZonedDateTime end1 = ev1.end();
                ZonedDateTime start2 = ZonedDateTime.of(ev2.getStart(), ev2.getZone());
                ZonedDateTime end2 = ev2.end();
                if(start1.isBefore(end2)&& start2.isBefore(end1)){
                    System.out.println("new conflict");
                    System.out.println("  1: " + ev1.label() + " (" + start1.toLocalTime() + " - " + end1.toLocalTime() + ")");
                    System.out.println("  2: " + ev2.label() + " (" + start2.toLocalTime() + " - " + end2.toLocalTime() + ")");
                    conf = true;
                }
            }
        }
        if (!conf) {
            System.out.println("perfect");
        }
    }
}
