package han.triptop.strategy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AirportDetails {
  private String airportCode;
  private String name;
  private String city;
  private String country;
  private double latitude;
  private double longitude;
}