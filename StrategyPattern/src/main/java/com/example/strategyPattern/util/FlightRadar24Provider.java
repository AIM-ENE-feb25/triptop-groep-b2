package com.example.strategyPattern.util;

import com.example.strategyPattern.IVluchtDataStrategy;
import com.example.strategyPattern.domain.VliegveldDetails;
import com.example.strategyPattern.domain.VluchtDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component("FlightRadar24Provider")
public class FlightRadar24Provider implements IVluchtDataStrategy {

  private static final String API_HOST = "flightradar24-com.p.rapidapi.com";

  @Override
  public String getFlightData(String flightNumber) throws JsonProcessingException {
    String url = "https://flightradar24-com.p.rapidapi.com/v2/flights/search?query=" + flightNumber;
    String response = ClientBuilder.buildClient(url, API_HOST);

    VluchtDetails vluchtDetails;
    try {
      vluchtDetails = VluchtMapper.mapFromFlightRadar(response);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return new ObjectMapper().writeValueAsString(vluchtDetails);
  }

  @Override
  public String getNearestAirport(String location) throws JsonProcessingException {
    String url = "https://flightradar24-com.p.rapidapi.com/airports/search?q=" + location;
    String response = ClientBuilder.buildClient(url, API_HOST);

    VliegveldDetails vliegveldDetails;
    try {
      vliegveldDetails = VliegveldMapper.mapFromFlightRadar(response);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    return new ObjectMapper().writeValueAsString(vliegveldDetails);
  }
}
