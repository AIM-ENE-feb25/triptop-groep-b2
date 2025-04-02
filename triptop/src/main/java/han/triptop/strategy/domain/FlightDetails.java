package han.triptop.strategy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlightDetails {
  private String flightNumber;
  private String callSign;
  private String airlineName;
  private String aircraftModel;
  private String departureAirport;
  private String arrivalAirport;
  private String status;
  private double latitude;
  private double longitude;
}