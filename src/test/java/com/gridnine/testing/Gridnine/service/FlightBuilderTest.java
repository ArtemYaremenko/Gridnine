package com.gridnine.testing.Gridnine.service;

import org.junit.jupiter.api.Test;
import com.gridnine.testing.Gridnine.model.Flight;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static com.gridnine.testing.Gridnine.testFlights.TestFlightsGetter.getAllTestFlights;

public class FlightBuilderTest {

    @Test
    void shouldReturnListFlight() {
        List<Flight> expected = getAllTestFlights();

        List<Flight> actual = FlightBuilder.createFlights();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            for (int k = 0; k < expected.get(i).getSegments().size(); k++) {
                assertEquals(expected.get(i).getSegments().get(k).getDepartureDate().getDayOfYear(), actual.get(i).getSegments().get(k).getDepartureDate().getDayOfYear());
                assertEquals(expected.get(i).getSegments().get(k).getDepartureDate().getHour(), actual.get(i).getSegments().get(k).getDepartureDate().getHour());
                assertEquals(expected.get(i).getSegments().get(k).getDepartureDate().getMinute(), actual.get(i).getSegments().get(k).getDepartureDate().getMinute());
                assertEquals(expected.get(i).getSegments().get(k).getArrivalDate().getDayOfYear(), actual.get(i).getSegments().get(k).getArrivalDate().getDayOfYear());
                assertEquals(expected.get(i).getSegments().get(k).getArrivalDate().getHour(), actual.get(i).getSegments().get(k).getArrivalDate().getHour());
                assertEquals(expected.get(i).getSegments().get(k).getArrivalDate().getMinute(), actual.get(i).getSegments().get(k).getArrivalDate().getMinute());
            }
        }
    }
}
