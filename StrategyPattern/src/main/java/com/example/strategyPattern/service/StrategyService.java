package com.example.strategyPattern.service;

import com.example.strategyPattern.config.StrategyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyService {
  private final StrategyConfig strategyConfig;

  @Autowired
  public StrategyService(StrategyConfig strategyConfig) {
    this.strategyConfig = strategyConfig;
  }

  public String getCurrentStrategy() {
    return strategyConfig.getCurrentStrategy();
  }

  public void setCurrentStrategy(String strategy) {
    strategyConfig.setCurrentStrategy(strategy);
  }
}