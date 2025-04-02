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
  private final FlightService aeroDataBoxService;

  @Autowired
  public FlightController(FlightService aeroDataBoxService) {
    this.aeroDataBoxService = aeroDataBoxService;
  }

  // Endpoint to get flight data
  @GetMapping("/{flightNumber}")
  public String getFlightData(@PathVariable String flightNumber) throws JsonProcessingException {
    return aeroDataBoxService.getFlightData(flightNumber);
  }
}
