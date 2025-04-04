package com.example.AeroDataBox.service;

import com.example.AeroDataBox.util.HttpClientUtil;
import org.springframework.stereotype.Service;

@Service
public class AeroDataBoxService {

  // Method to call the AeroDataBox API and get flight data
  public String getFlightData(String flightNumber) {
    return HttpClientUtil.getFlightData(flightNumber); // Use utility method to make API request
  }

  public String getAirportData(String airportCode) {
    return HttpClientUtil.getAirportData(airportCode); // Use utility method to make API request
  }

  public String searchAirports(String searchTerm) {
    return HttpClientUtil.searchAirports(searchTerm); // Use utility method to make API request
  }

  public String getAirportRoutes(String airportCode) {
    return HttpClientUtil.getAirportRoutes(airportCode); // Use utility method to make API request
  }

  public String getAirportDistance(String airportCode1, String airportCode2) {
    return HttpClientUtil.getAirportDistance(airportCode1, airportCode2); // Use utility method to make API request
  }
}
