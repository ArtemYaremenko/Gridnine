package com.gridnine.testing.Gridnine.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Бин представляющий сегмент — это атомарная перевозка,
 * которую для простоты будем характеризовать всего двумя атрибутами:
 * дата/время вылета и дата/время прилёта.
 */
public class Segment {
    private final LocalDateTime departureDate;

    private final LocalDateTime arrivalDate;

    public Segment(final LocalDateTime departureDate, final LocalDateTime arrivalDate) {
        this.departureDate = Objects.requireNonNull(departureDate);
        this.arrivalDate = Objects.requireNonNull(arrivalDate);
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt) + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segment segment)) return false;
        return Objects.equals(getDepartureDate(), segment.getDepartureDate()) && Objects.equals(getArrivalDate(), segment.getArrivalDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartureDate(), getArrivalDate());
    }
}
