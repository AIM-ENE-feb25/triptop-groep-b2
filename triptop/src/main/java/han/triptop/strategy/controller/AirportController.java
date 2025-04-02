package han.triptop.strategy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import han.triptop.strategy.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
