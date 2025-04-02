package com.example.strategyPattern;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IVluchtDataStrategy {
  String getFlightData(String flightNumber) throws JsonProcessingException;
  String getNearestAirport(String location) throws JsonProcessingException;
}