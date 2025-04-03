package han.triptop.strategy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import han.triptop.strategy.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
  private final FlightService flightService;

  @Autowired
  public FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  // Endpoint to get flight data
  @GetMapping("/{flightNumber}")
  public String getFlightData(@PathVariable String flightNumber) throws JsonProcessingException {
    return flightService.getFlightData(flightNumber);
  }

  @GetMapping("/search/{searchTerm}")
  public String getNearestAirport(@PathVariable String searchTerm) throws JsonProcessingException {
    return flightService.getNearestAirport(searchTerm);
  }
}
