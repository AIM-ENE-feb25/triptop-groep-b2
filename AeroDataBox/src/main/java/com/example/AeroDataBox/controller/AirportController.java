package com.example.AeroDataBox.controller;

import com.example.AeroDataBox.service.AeroDataBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

  private final AeroDataBoxService aeroDataBoxService;

  @Autowired
  public AirportController(AeroDataBoxService aeroDataBoxService) {
    this.aeroDataBoxService = aeroDataBoxService;
  }

  @GetMapping("/{airportCode}")
  public String getAirportData(@PathVariable String airportCode) {
    return aeroDataBoxService.getAirportData(airportCode);
  }

  @GetMapping("/search/{searchTerm}")
  public String searchAirports(@PathVariable String searchTerm) {
    return aeroDataBoxService.searchAirports(searchTerm);
  }

  @GetMapping("/routes/{airportCode}")
  public String getAirportRoutes(@PathVariable String airportCode) {
    return aeroDataBoxService.getAirportRoutes(airportCode);
  }

  @GetMapping("/distance/{airportCode1}/{airportCode2}")
  public String getAirportDistance(@PathVariable String airportCode1, @PathVariable String airportCode2) {
    return aeroDataBoxService.getAirportDistance(airportCode1, airportCode2);
  }
}
