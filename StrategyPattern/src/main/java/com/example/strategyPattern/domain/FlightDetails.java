package com.example.strategyPattern.domain;

public class FlightDetails {
  private String flightNumber;
  private String callSign;
  private String airlineName;
  private String aircraftModel;
  private String departureAirport;
  private String arrivalAirport;
  private String status;
  private double latitude;
  private double longitude;

  // Getters and setters
  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  public String getAirlineName() {
    return airlineName;
  }

  public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
  }

  public String getAircraftModel() {
    return aircraftModel;
  }

  public void setAircraftModel(String aircraftModel) {
    this.aircraftModel = aircraftModel;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public void setDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
  }

  public String getArrivalAirport() {
    return arrivalAirport;
  }

  public void setArrivalAirport(String arrivalAirport) {
    this.arrivalAirport = arrivalAirport;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}