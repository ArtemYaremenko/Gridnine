package com.gridnine.testing.Gridnine.service;

import com.gridnine.testing.Gridnine.model.Flight;
import com.gridnine.testing.Gridnine.model.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс, создающий тестовый список рейсов.
 */
public interface FlightBuilder {
    static List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                //Обычный двухчасовой рейс
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                //Обычный рейс с одной пересадкой
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                //Рейс, вылетевший в прошлом
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                //Рейс, который отправляется раньше, чем прибывает
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                //Рейс со временем ожидания на земле более 2х часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                //Ещё один рейс со временем ожидания на земле более 2х часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7))
        );
    }

    private static Flight createFlight(final LocalDateTime... dateTimes) {
        if ((dateTimes.length % 2) != 0) {
            throw new IllegalArgumentException("Вы должны ввести четное количество дат!");
        }
        List<Segment> segments = new ArrayList<>(dateTimes.length / 2);
        for (int i = 0; i < (dateTimes.length - 1); i += 2) {
            segments.add(new Segment(dateTimes[i], dateTimes[i + 1]));
        }
        return new Flight(segments);
    }
}
