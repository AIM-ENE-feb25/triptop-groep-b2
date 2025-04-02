package com.example.strategyPattern.controller;

import com.example.strategyPattern.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/strategy")
public class StrategyController {

  private final StrategyService strategyService;

  @Autowired
  public StrategyController(StrategyService strategyService) {
    this.strategyService = strategyService;
  }

  @PostMapping("/set")
  public void setStrategy(@RequestParam String strategy) {
    strategyService.setCurrentStrategy(strategy);
  }

  @GetMapping("/current")
  public String getCurrentStrategy() {
    return strategyService.getCurrentStrategy();
  }
}