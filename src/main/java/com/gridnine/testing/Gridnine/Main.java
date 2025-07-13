package com.gridnine.testing.Gridnine;

import com.gridnine.testing.Gridnine.model.Flight;
import com.gridnine.testing.Gridnine.rule.impl.ActualFlightsRule;
import com.gridnine.testing.Gridnine.rule.impl.FlightsWithCorrectDatesRule;
import com.gridnine.testing.Gridnine.rule.impl.FlightsWithShortGroundTimeRule;
import com.gridnine.testing.Gridnine.service.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Получаем весь тестовый набор полетов
        List<Flight> flights =  FlightBuilder.createFlights();
        System.out.println(flights);

        ActualFlightsRule actualFlightsRule = new ActualFlightsRule();
        List<Flight> actualFlights = actualFlightsRule.processFlights(flights);
        System.out.println(actualFlights.toString());

        FlightsWithCorrectDatesRule flightsWithCorrectDatesRule = new FlightsWithCorrectDatesRule();
        List<Flight> flightsWithCorrectDates = flightsWithCorrectDatesRule.processFlights(flights);
        System.out.println(flightsWithCorrectDates);

        FlightsWithShortGroundTimeRule flightsWithShortGroundTimeRule = new FlightsWithShortGroundTimeRule();
        List<Flight> shortFlights = flightsWithShortGroundTimeRule.processFlights(flights);
        System.out.println(shortFlights);
    }
}
