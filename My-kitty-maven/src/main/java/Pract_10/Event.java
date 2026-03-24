package Pract_10;

import java.time.*;


public class Event {
    private String title;
    private LocalDateTime start;
    private Duration durationMinutes;
    private ZoneId zone;
    private String track;

    public Event(String track, ZoneId zone, Duration durationMinutes, LocalDateTime start, String title) {
        this.track = track;
        this.zone = zone;
        this.durationMinutes = durationMinutes;
        this.start = start;
        this.title = title;
    }
    public ZonedDateTime end(){
        return ZonedDateTime.of(this.start, this.zone).plus(this.durationMinutes);
    }
    public String label() {
        return this.title + " [" + this.track + "]   " + this.durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public Duration getDurationMinutes() {
        return durationMinutes;
    }

    public ZoneId getZone() {
        return zone;
    }

    public String getTrack() {
        return track;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", durationMinutes=" + durationMinutes +
                ", zone=" + zone +
                ", track='" + track + '\'' +
                '}';
    }
}
