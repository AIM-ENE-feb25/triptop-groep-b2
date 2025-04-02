package han.triptop.strategy.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import han.triptop.strategy.domain.AirportDetails;

import java.util.List;
import java.util.Map;

public class AirportMapper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static AirportDetails mapFromAeroDataBox(String response) throws Exception {
    Map<String, Object> responseMap = mapper.readValue(response, Map.class);
    Map<String, Object> firstItem = (Map<String, Object>)((List<Object>)responseMap.get("items")).get(0);
    AirportDetails airportDetails = new AirportDetails();
    airportDetails.setAirportCode((String)firstItem.get("iata"));
    airportDetails.setName((String)firstItem.get("name"));
    airportDetails.setCity((String)firstItem.get("municipalityName"));
    airportDetails.setCountry((String)firstItem.get("countryCode"));
    Map<String, Object> locationMap = (Map<String, Object>)firstItem.get("location");
    airportDetails.setLatitude((Double)locationMap.get("lat"));
    airportDetails.setLongitude((Double)locationMap.get("lon"));
    return airportDetails;
  }

  public static AirportDetails mapFromFlightRadar(String response) throws Exception {
    Map<String, Object> responseMap = mapper.readValue(response, Map.class);
    Map<String, Object> firstItem = (Map<String, Object>)((List<Object>)responseMap.get("data")).get(0);
    Map<String, Object> detail = (Map<String, Object>)firstItem.get("detail");
    AirportDetails airportDetails = new AirportDetails();
    airportDetails.setAirportCode((String)firstItem.get("id"));
    airportDetails.setName((String)firstItem.get("label"));
    airportDetails.setCity(""); // City is not provided in the response
    airportDetails.setCountry(""); // Country is not provided in the response
    airportDetails.setLatitude((Double)detail.get("lat"));
    airportDetails.setLongitude((Double)detail.get("lon"));
    return airportDetails;
  }
}