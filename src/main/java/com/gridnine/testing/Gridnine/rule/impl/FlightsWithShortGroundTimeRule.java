package com.gridnine.testing.Gridnine.rule.impl;

import com.gridnine.testing.Gridnine.model.Flight;
import com.gridnine.testing.Gridnine.model.Segment;
import com.gridnine.testing.Gridnine.rule.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FlightsWithShortGroundTimeRule implements Rule {
    private static final Logger logger = LoggerFactory.getLogger(FlightsWithShortGroundTimeRule.class);
    @Override
    public List<Flight> processFlights(List<Flight> flights) {
        List<Flight> shortFlights = new ArrayList<>();
        for (Flight f : flights) {
            List<Segment> segments = new ArrayList<>();
            if (f.getSegments().size() == 1) {
                segments.add(f.getSegments().getFirst());
            } else {
                long result = 0;
                int i = 0;
                for (; i < f.getSegments().size()-1; i++) {
                    Duration diff = Duration.between(f.getSegments().get(i).getArrivalDate(), f.getSegments().get(i + 1).getDepartureDate());
                    result += diff.toHours();
                    segments.addAll(f.getSegments());
                }
                if (result > 2 || i < f.getSegments().size()-2) {
                    continue;
                }
            }
            shortFlights.add(new Flight(segments));
        }
        logger.debug("shortFlights - {}", shortFlights);
        return shortFlights;
    }
}
