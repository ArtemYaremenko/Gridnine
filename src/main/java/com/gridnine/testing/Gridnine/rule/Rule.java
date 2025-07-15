package com.gridnine.testing.Gridnine.rule;

import com.gridnine.testing.Gridnine.model.Flight;

import java.util.List;

public interface Rule {
    List<Flight> processFlights(List<Flight> flights);
}
