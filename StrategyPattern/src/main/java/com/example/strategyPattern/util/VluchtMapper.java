package com.example.strategyPattern.util;

import com.example.strategyPattern.domain.VluchtDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class VluchtMapper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static VluchtDetails mapFromFlightRadar(String response) throws Exception {
    Map<String, Object> responseMap = mapper.readValue(response, Map.class);
    Map<String, Object> firstItem = (Map<String, Object>) ((List<Object>) responseMap.get("results")).get(0);
    Map<String, Object> detail = (Map<String, Object>) firstItem.get("detail");
    VluchtDetails vluchtDetails = new VluchtDetails();
    vluchtDetails.setFlightNumber((String) detail.get("flight"));
    vluchtDetails.setCallSign((String) detail.get("callsign"));
    vluchtDetails.setAirlineName((String) firstItem.get("label"));
    vluchtDetails.setAircraftModel((String) detail.get("ac_type"));
    vluchtDetails.setDepartureAirport((String) detail.get("schd_from"));
    vluchtDetails.setArrivalAirport((String) detail.get("schd_to"));
    vluchtDetails.setStatus("live".equals(firstItem.get("type")) ? "In Flight" : "Scheduled");
    return vluchtDetails;
  }

  public static VluchtDetails mapFromAeroDataBox(String response) throws Exception {
    List<Map<String, Object>> responseList = mapper.readValue(response, List.class);
    Map<String, Object> firstItem = responseList.get(0);
    Map<String, Object> departure = (Map<String, Object>) firstItem.get("departure");
    Map<String, Object> arrival = (Map<String, Object>) firstItem.get("arrival");
    Map<String, Object> aircraft = (Map<String, Object>) firstItem.get("aircraft");
    Map<String, Object> airline = (Map<String, Object>) firstItem.get("airline");
    VluchtDetails vluchtDetails = new VluchtDetails();
    vluchtDetails.setFlightNumber((String) firstItem.get("number"));
    vluchtDetails.setCallSign((String) firstItem.get("callSign"));
    vluchtDetails.setAirlineName((String) airline.get("name"));
    vluchtDetails.setAircraftModel((String) aircraft.get("model"));
    vluchtDetails.setDepartureAirport((String) ((Map<String, Object>) departure.get("airport")).get("name"));
    vluchtDetails.setArrivalAirport((String) ((Map<String, Object>) arrival.get("airport")).get("name"));
    vluchtDetails.setStatus((String) firstItem.get("status"));
    return vluchtDetails;
  }
}