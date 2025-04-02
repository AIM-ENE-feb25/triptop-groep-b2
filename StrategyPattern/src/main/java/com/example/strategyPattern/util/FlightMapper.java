package com.example.strategyPattern.util;

import com.example.strategyPattern.domain.FlightDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class FlightMapper {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static FlightDetails mapFromFlightRadar(String response) throws Exception {
    Map<String, Object> responseMap = mapper.readValue(response, Map.class);
    Map<String, Object> firstItem = (Map<String, Object>) ((List<Object>) responseMap.get("results")).get(0);
    Map<String, Object> detail = (Map<String, Object>) firstItem.get("detail");
    FlightDetails flightDetails = new FlightDetails();
    flightDetails.setFlightNumber((String) detail.get("flight"));
    flightDetails.setCallSign((String) detail.get("callsign"));
    flightDetails.setAirlineName((String) firstItem.get("label"));
    flightDetails.setAircraftModel((String) detail.get("ac_type"));
    flightDetails.setDepartureAirport((String) detail.get("schd_from"));
    flightDetails.setArrivalAirport((String) detail.get("schd_to"));
    flightDetails.setStatus("live".equals(firstItem.get("type")) ? "In Flight" : "Scheduled");
    return flightDetails;
  }

  public static FlightDetails mapFromAeroDataBox(String response) throws Exception {
    List<Map<String, Object>> responseList = mapper.readValue(response, List.class);
    Map<String, Object> firstItem = responseList.get(0);
    Map<String, Object> departure = (Map<String, Object>) firstItem.get("departure");
    Map<String, Object> arrival = (Map<String, Object>) firstItem.get("arrival");
    Map<String, Object> aircraft = (Map<String, Object>) firstItem.get("aircraft");
    Map<String, Object> airline = (Map<String, Object>) firstItem.get("airline");
    FlightDetails flightDetails = new FlightDetails();
    flightDetails.setFlightNumber((String) firstItem.get("number"));
    flightDetails.setCallSign((String) firstItem.get("callSign"));
    flightDetails.setAirlineName((String) airline.get("name"));
    flightDetails.setAircraftModel((String) aircraft.get("model"));
    flightDetails.setDepartureAirport((String) ((Map<String, Object>) departure.get("airport")).get("name"));
    flightDetails.setArrivalAirport((String) ((Map<String, Object>) arrival.get("airport")).get("name"));
    flightDetails.setStatus((String) firstItem.get("status"));
    return flightDetails;
  }
}