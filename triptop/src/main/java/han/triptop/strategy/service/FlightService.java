package han.triptop.strategy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import han.triptop.strategy.IVluchtDataStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FlightService {
  private final Map<String, IVluchtDataStrategy> strategies;
  private final StrategyService strategyService;

  @Autowired
  public FlightService(Map<String, IVluchtDataStrategy> strategies, StrategyService strategyService) {
    this.strategies = strategies;
    this.strategyService = strategyService;
  }

  private IVluchtDataStrategy getStrategy() {
    String strategyName = strategyService.getCurrentStrategy();
    return strategies.get(strategyName);
  }

  public String getFlightData(String flightNumber) throws JsonProcessingException {
    return getStrategy().getFlightData(flightNumber);
  }

  public String getNearestAirport(String location) throws JsonProcessingException {
    return getStrategy().getNearestAirport(location);
  }
}