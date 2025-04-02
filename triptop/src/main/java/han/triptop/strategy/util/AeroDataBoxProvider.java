package han.triptop.strategy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import han.triptop.strategy.IVluchtDataStrategy;
import han.triptop.strategy.domain.AirportDetails;
import han.triptop.strategy.domain.FlightDetails;
import org.springframework.stereotype.Component;

@Component("AeroDataBoxProvider")
public class AeroDataBoxProvider implements IVluchtDataStrategy {
  private static final String API_HOST = "aerodatabox.p.rapidapi.com";

  @Override
  public String getFlightData(String flightNumber) throws JsonProcessingException {
    String url = "https://aerodatabox.p.rapidapi.com/flights/number/" + flightNumber +
                 "?withAircraftImage=false&withLocation=false";
    String response = ClientBuilder.buildClient(url, API_HOST);
    FlightDetails flightDetails;
    try {
      flightDetails = FlightMapper.mapFromAeroDataBox(response);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return new ObjectMapper().writeValueAsString(flightDetails);
  }

  @Override
  public String getNearestAirport(String location) throws JsonProcessingException {
    String url = "https://aerodatabox.p.rapidapi.com/airports/search/term?q=" + location + "&limit=10";
    String response = ClientBuilder.buildClient(url, API_HOST);
    AirportDetails airportDetails;
    try {
      airportDetails = AirportMapper.mapFromAeroDataBox(response);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return new ObjectMapper().writeValueAsString(airportDetails);
  }

  //  @Override
  //  public String getNearbyAirports(String latitude, String longitude) {
  //    String url = "https://aerodatabox.p.rapidapi.com/airports/search/location?lat=" + latitude + "&lon=" +
  //    longitude + "&radiusKm=50&limit=10&withFlightInfoOnly=false";
  //    return ClientBuilder.buildClient(url, API_HOST);
  //  }
  //
  //  @Override
  //  public String getAirportData(String airportCode) {
  //    String url = "https://aerodatabox.p.rapidapi.com/airports/iata/" + airportCode;
  //    return ClientBuilder.buildClient(url, API_HOST);
  //  }
  //
  //  @Override
  //  public String searchAirports(String searchTerm) {
  //    String url = "https://aerodatabox.p.rapidapi.com/airports/search/term?q=" + searchTerm + "&limit=10";
  //    return ClientBuilder.buildClient(url, API_HOST);
  //  }
  //
  //  @Override
  //  public String getAirportRoutes(String airportCode) {
  //    LocalDate currentDate = LocalDate.now();
  //    String url = "https://aerodatabox.p.rapidapi.com/airports/iata/" + airportCode + "/stats/routes/daily/" +
  //    currentDate;
  //    return ClientBuilder.buildClient(url, API_HOST);
  //  }
  //
  //  @Override
  //  public String getAirportDistance(String airportCode1, String airportCode2) {
  //    String url = "https://aerodatabox.p.rapidapi.com/airports/iata/" + airportCode1 + "/distance-time/" +
  //    airportCode2 + "?flightTimeModel=Standard&aircraftName=Standard";
  //    return ClientBuilder.buildClient(url, API_HOST);
  //  }
}