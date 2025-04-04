package com.example.AeroDataBox.controller;

import com.example.AeroDataBox.service.AeroDataBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

  private final AeroDataBoxService aeroDataBoxService;

  @Autowired
  public FlightController(AeroDataBoxService aeroDataBoxService) {
    this.aeroDataBoxService = aeroDataBoxService;
  }

  // Endpoint to get flight data
  @GetMapping("/{flightNumber}")
  public String getFlightData(@PathVariable String flightNumber) {
    return aeroDataBoxService.getFlightData(flightNumber);
  }
}
