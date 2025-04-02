package com.example.strategyPattern.util;

import com.example.strategyPattern.domain.AirportDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class AirportMapper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static AirportDetails mapFromAeroDataBox(String response) throws Exception {
    Map<String, Object> responseMap = mapper.readValue(response, Map.class);
    Map<String, Object> firstItem = (Map<String, Object>) ((List<Object>) responseMap.get("items")).get(0);
    AirportDetails AirportDetails = new AirportDetails();
    AirportDetails.setAirportCode((String) firstItem.get("iata"));
    AirportDetails.setName((String) firstItem.get("name"));
    AirportDetails.setCity((String) firstItem.get("municipalityName"));
    AirportDetails.setCountry((String) firstItem.get("countryCode"));
    Map<String, Object> locationMap = (Map<String, Object>) firstItem.get("location");
    AirportDetails.setLatitude((Double) locationMap.get("lat"));
    AirportDetails.setLongitude((Double) locationMap.get("lon"));
    return AirportDetails;
  }

  public static AirportDetails mapFromFlightRadar(String response) throws Exception {
    Map<String, Object> responseMap = mapper.readValue(response, Map.class);
    Map<String, Object> firstItem = (Map<String, Object>) ((List<Object>) responseMap.get("data")).get(0);
    Map<String, Object> detail = (Map<String, Object>) firstItem.get("detail");
    AirportDetails AirportDetails = new AirportDetails();
    AirportDetails.setAirportCode((String) firstItem.get("id"));
    AirportDetails.setName((String) firstItem.get("label"));
    AirportDetails.setCity(""); // City is not provided in the response
    AirportDetails.setCountry(""); // Country is not provided in the response
    AirportDetails.setLatitude((Double) detail.get("lat"));
    AirportDetails.setLongitude((Double) detail.get("lon"));
    return AirportDetails;
  }
}