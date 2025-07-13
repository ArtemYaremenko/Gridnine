package com.gridnine.testing.Gridnine.service.rule.impl;

import com.gridnine.testing.Gridnine.model.Flight;
import com.gridnine.testing.Gridnine.rule.impl.FlightsWithShortGroundTimeRule;
import com.gridnine.testing.Gridnine.service.FlightBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gridnine.testing.Gridnine.testFlights.TestFlightsGetter.getTestFlightsWithShortGroundTime;
import static org.junit.jupiter.api.Assertions.*;

public class FlightsWithShortGroundTimeRuleTest {
    private final FlightsWithShortGroundTimeRule out = new FlightsWithShortGroundTimeRule();

    @Test
    void shouldReturnListOfFlightsWithShortGroundTime() {
        List<Flight> expected = getTestFlightsWithShortGroundTime();

        //test
        List<Flight> actual = out.processFlights(FlightBuilder.createFlights());

        //check
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
