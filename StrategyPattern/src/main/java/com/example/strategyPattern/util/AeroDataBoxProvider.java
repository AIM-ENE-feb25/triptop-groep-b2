package com.example.strategyPattern.util;

import com.example.strategyPattern.IVluchtDataStrategy;
import com.example.strategyPattern.domain.VliegveldDetails;
import com.example.strategyPattern.domain.VluchtDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component("AeroDataBoxProvider")
public class AeroDataBoxProvider implements IVluchtDataStrategy {
  private static final String API_HOST = "aerodatabox.p.rapidapi.com";

  @Override
  public String getFlightData(String flightNumber) throws JsonProcessingException {
    String url = "https://aerodatabox.p.rapidapi.com/flights/number/" + flightNumber + "?withAircraftImage=false&withLocation=false";
    String response = ClientBuilder.buildClient(url, API_HOST);

    VluchtDetails vluchtDetails;
    try {
      vluchtDetails = VluchtMapper.mapFromAeroDataBox(response);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return new ObjectMapper().writeValueAsString(vluchtDetails);
  }

  @Override
  public String getNearestAirport(String location) throws JsonProcessingException {
    String url = "https://aerodatabox.p.rapidapi.com/airports/search/term?q=" + location + "&limit=10";
    String response = ClientBuilder.buildClient(url, API_HOST);

    VliegveldDetails vliegveldDetails;
    try {
      vliegveldDetails = VliegveldMapper.mapFromAeroDataBox(response);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return new ObjectMapper().writeValueAsString(vliegveldDetails);
  }

//  @Override
//  public String getNearbyAirports(String latitude, String longitude) {
//    String url = "https://aerodatabox.p.rapidapi.com/airports/search/location?lat=" + latitude + "&lon=" + longitude + "&radiusKm=50&limit=10&withFlightInfoOnly=false";
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
//    String url = "https://aerodatabox.p.rapidapi.com/airports/iata/" + airportCode + "/stats/routes/daily/" + currentDate;
//    return ClientBuilder.buildClient(url, API_HOST);
//  }
//
//  @Override
//  public String getAirportDistance(String airportCode1, String airportCode2) {
//    String url = "https://aerodatabox.p.rapidapi.com/airports/iata/" + airportCode1 + "/distance-time/" + airportCode2 + "?flightTimeModel=Standard&aircraftName=Standard";
//    return ClientBuilder.buildClient(url, API_HOST);
//  }
}