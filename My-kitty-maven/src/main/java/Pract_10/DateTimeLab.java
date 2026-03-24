package Pract_10;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeLab {
    public static Instant toInstant(Event e) {
        return ZonedDateTime.of(e.getStart(), e.getZone()).toInstant();
    }
    public static long minutesBetween(Event a, Event b) {
        Instant startA = toInstant(a);
        Instant startB = toInstant(b);
        return Math.abs(Duration.between(startA, startB).toMinutes());
    }

    public static ZonedDateTime startInZone(Event e, String zone) {
        ZonedDateTime originalStart = ZonedDateTime.of(e.getStart(), e.getZone());
        ZoneId targetZone = ZoneId.of(zone);
        return originalStart.withZoneSameInstant(targetZone);
    }
}
