package com.example.strategyPattern.controller;

import com.example.strategyPattern.service.FlightService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

  private final FlightService vluchtService;

  @Autowired
  public AirportController(FlightService vluchtService) {
    this.vluchtService = vluchtService;
  }

  @GetMapping("/search/{searchTerm}")
  public String getNearestAirport(@PathVariable String searchTerm) throws JsonProcessingException {
    return vluchtService.getNearestAirport(searchTerm);
  }
}
