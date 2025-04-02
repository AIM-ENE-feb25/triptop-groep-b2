package han.triptop.strategy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import han.triptop.strategy.IVluchtDataStrategy;
import han.triptop.strategy.domain.AirportDetails;
import han.triptop.strategy.domain.FlightDetails;
import org.springframework.stereotype.Component;

@Component("FlightRadar24Provider")
public class FlightRadar24Provider implements IVluchtDataStrategy {

  private static final String API_HOST = "flightradar24-com.p.rapidapi.com";

  @Override
  public String getFlightData(String flightNumber) throws JsonProcessingException {
    String url = "https://flightradar24-com.p.rapidapi.com/v2/flights/search?query=" + flightNumber;
    String response = ClientBuilder.buildClient(url, API_HOST);

    FlightDetails flightDetails;
    try {
      flightDetails = FlightMapper.mapFromFlightRadar(response);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return new ObjectMapper().writeValueAsString(flightDetails);
  }

  @Override
  public String getNearestAirport(String location) throws JsonProcessingException {
    String url = "https://flightradar24-com.p.rapidapi.com/airports/search?q=" + location;
    String response = ClientBuilder.buildClient(url, API_HOST);

    AirportDetails airportDetails;
    try {
      airportDetails = AirportMapper.mapFromFlightRadar(response);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return new ObjectMapper().writeValueAsString(airportDetails);
  }
}
