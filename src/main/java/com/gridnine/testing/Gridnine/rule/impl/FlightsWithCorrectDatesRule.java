package com.gridnine.testing.Gridnine.rule.impl;

import com.gridnine.testing.Gridnine.model.Flight;
import com.gridnine.testing.Gridnine.model.Segment;
import com.gridnine.testing.Gridnine.rule.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FlightsWithCorrectDatesRule implements Rule {
    private static final Logger logger = LoggerFactory.getLogger(FlightsWithCorrectDatesRule.class);
    @Override
    public List<Flight> processFlights(List<Flight> flights) {
        List<Flight> flightsWithCorrectDates = new ArrayList<>();
        for (Flight f : flights) {
            List<Segment> segments = new ArrayList<>();
            List<Boolean> checks = new ArrayList<>();
            for (Segment s : f.getSegments()) {
                boolean check = s.getDepartureDate().isAfter(s.getArrivalDate());
                checks.add(check);
                segments.add(s);
            }
            if (checks.contains(true)) {
                continue;
            }
            flightsWithCorrectDates.add(new Flight(segments));
        }
        logger.debug("flightsWithCorrectDates - {}", flightsWithCorrectDates);
        return flightsWithCorrectDates;
    }
}
