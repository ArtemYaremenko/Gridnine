package com.gridnine.testing.Gridnine.rule.impl;

import com.gridnine.testing.Gridnine.model.Flight;
import com.gridnine.testing.Gridnine.model.Segment;
import com.gridnine.testing.Gridnine.rule.Rule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActualFlightsRule implements Rule {

    @Override
    public List<Flight> processFlights(List<Flight> flights) {
        List<Flight> actualFlights = new ArrayList<>();
        for (Flight f : flights) {
            List<Segment> segments = new ArrayList<>();
            List<Boolean> checks = new ArrayList<>();
            for (Segment s : f.getSegments()) {
                boolean check = s.getDepartureDate().isBefore(LocalDateTime.now());
                checks.add(check);
                segments.add(s);
            }
            if (checks.contains(true)) {
                continue;
            }
            actualFlights.add(new Flight(segments));
        }
        return actualFlights;
    }
}
