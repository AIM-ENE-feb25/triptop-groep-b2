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
    AirportDetails vliegveldDetails = new AirportDetails();
    vliegveldDetails.setAirportCode((String)firstItem.get("iata"));
    vliegveldDetails.setName((String)firstItem.get("name"));
    vliegveldDetails.setCity((String)firstItem.get("municipalityName"));
    vliegveldDetails.setCountry((String)firstItem.get("countryCode"));
    Map<String, Object> locationMap = (Map<String, Object>)firstItem.get("location");
    vliegveldDetails.setLatitude((Double)locationMap.get("lat"));
    vliegveldDetails.setLongitude((Double)locationMap.get("lon"));
    return vliegveldDetails;
  }

  public static AirportDetails mapFromFlightRadar(String response) throws Exception {
    Map<String, Object> responseMap = mapper.readValue(response, Map.class);
    Map<String, Object> firstItem = (Map<String, Object>)((List<Object>)responseMap.get("data")).get(0);
    Map<String, Object> detail = (Map<String, Object>)firstItem.get("detail");
    AirportDetails vliegveldDetails = new AirportDetails();
    vliegveldDetails.setAirportCode((String)firstItem.get("id"));
    vliegveldDetails.setName((String)firstItem.get("label"));
    vliegveldDetails.setCity(""); // City is not provided in the response
    vliegveldDetails.setCountry(""); // Country is not provided in the response
    vliegveldDetails.setLatitude((Double)detail.get("lat"));
    vliegveldDetails.setLongitude((Double)detail.get("lon"));
    return vliegveldDetails;
  }
}