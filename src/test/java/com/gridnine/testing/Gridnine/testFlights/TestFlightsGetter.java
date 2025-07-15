package com.gridnine.testing.Gridnine.testFlights;

import com.gridnine.testing.Gridnine.model.Flight;
import com.gridnine.testing.Gridnine.model.Segment;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestFlightsGetter {

    public static List<Flight> getAllTestFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> s1 = List.of(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        List<Segment> s2 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)));
        List<Segment> s3 = List.of(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow));
        List<Segment> s4 = List.of(new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6)));
        List<Segment> s5 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)));
        List<Segment> s6 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
                new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
        Flight flight1 = new Flight(s1);
        Flight flight2 = new Flight(s2);
        Flight flight3 = new Flight(s3);
        Flight flight4 = new Flight(s4);
        Flight flight5 = new Flight(s5);
        Flight flight6 = new Flight(s6);
        return Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6);
    }

    public static List<Flight> getActualTestFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> s1 = List.of(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        List<Segment> s2 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)));
        List<Segment> s3 = List.of(new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6)));
        List<Segment> s4 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)));
        List<Segment> s5 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
                new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
        Flight flight1 = new Flight(s1);
        Flight flight2 = new Flight(s2);
        Flight flight3 = new Flight(s3);
        Flight flight4 = new Flight(s4);
        Flight flight5 = new Flight(s5);
        return Arrays.asList(flight1, flight2, flight3, flight4, flight5);
    }

    public static List<Flight> getTestFlightsWithCorrectDates() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> s1 = List.of(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        List<Segment> s2 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)));
        List<Segment> s3 = List.of(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow));
        List<Segment> s4 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)));
        List<Segment> s5 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
                new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
        Flight flight1 = new Flight(s1);
        Flight flight2 = new Flight(s2);
        Flight flight3 = new Flight(s3);
        Flight flight4 = new Flight(s4);
        Flight flight5 = new Flight(s5);
        return Arrays.asList(flight1, flight2, flight3, flight4, flight5);
    }

    public static List<Flight> getTestFlightsWithShortGroundTime() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> s1 = List.of(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        List<Segment> s2 = Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)));
        List<Segment> s3 = List.of(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow));
        List<Segment> s4 = List.of(new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6)));
        Flight flight1 = new Flight(s1);
        Flight flight2 = new Flight(s2);
        Flight flight3 = new Flight(s3);
        Flight flight4 = new Flight(s4);
        return Arrays.asList(flight1, flight2, flight3, flight4);
    }
}
