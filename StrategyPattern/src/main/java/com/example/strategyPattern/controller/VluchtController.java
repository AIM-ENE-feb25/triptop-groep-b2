package com.example.strategyPattern.controller;

import com.example.strategyPattern.service.VluchtService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flights")
public class VluchtController {

  private final VluchtService aeroDataBoxService;

  @Autowired
  public VluchtController(VluchtService aeroDataBoxService) {
    this.aeroDataBoxService = aeroDataBoxService;
  }

  // Endpoint to get flight data
  @GetMapping("/{flightNumber}")
  public String getFlightData(@PathVariable String flightNumber) throws JsonProcessingException {
    return aeroDataBoxService.getFlightData(flightNumber);
  }
}
