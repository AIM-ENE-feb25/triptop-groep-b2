package han.triptop.strategy.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@NoArgsConstructor
@Configuration
public class StrategyConfig {
  private String currentStrategy = "AeroDataBoxProvider"; // Default strategy
}