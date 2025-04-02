package com.example.strategyPattern.service;

import com.example.strategyPattern.IVluchtDataStrategy;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VluchtService {
  private final Map<String, IVluchtDataStrategy> strategies;
  private final StrategyService strategyService;

  @Autowired
  public VluchtService(Map<String, IVluchtDataStrategy> strategies, StrategyService strategyService) {
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