package han.triptop.strategy.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyConfig {
  private String currentStrategy = "AeroDataBoxProvider"; // Default strategy

  public String getCurrentStrategy() {
    return currentStrategy;
  }

  public void setCurrentStrategy(String currentStrategy) {
    this.currentStrategy = currentStrategy;
  }
}