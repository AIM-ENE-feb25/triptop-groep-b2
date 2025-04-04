package com.example.AeroDataBox.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.time.LocalDate;

public class HttpClientUtil {
  //LHR is london heathrow, LAX is los angeles, AMS is schiphol (amsterdam) en JFK is john f kennedy (new york). Alle codes zijn in IATA.
  //Alleen IATA wordt op dit moment ondersteund, kan aangepast worden om ICAO toe te staan.
  public static String getFlightData(String flightNumber) {
    //De locatie en afbeelding van het vliegtuig zijn uitgeschakeld, kan aangepast worden om deze te tonen.
    //DL47 is the test code
    String url = "https://aerodatabox.p.rapidapi.com/flights/number/" + flightNumber + "?withAircraftImage=false&withLocation=false";

    return clientBuilder(url);
  }

  public static String getAirportData(String airportCode) {
    //LHR or LAX is the test code
    String url = "https://aerodatabox.p.rapidapi.com/airports/iata/" + airportCode;

    return clientBuilder(url);
  }

  public static String searchAirports(String searchTerm) {
    //De limiet staat op 10 resultaten, kan aangepast worden om meer resultaten te krijgen.
    //LHR or LAX is the test code
    String url = "https://aerodatabox.p.rapidapi.com/airports/search/term?q=" + searchTerm + "&limit=10";

    return clientBuilder(url);
  }

  public static String getAirportRoutes(String airportCode) {
    //Ik maak gebruik van de currentdate om de dagelijkse routes te krijgen, dit kan aangepast worden om een specifieke datum te krijgen.
    LocalDate currentDate = LocalDate.now();

    //LHR or LAX is the test code
    String url = "https://aerodatabox.p.rapidapi.com/airports/iata/" + airportCode + "/stats/routes/daily/"+ currentDate;

    return clientBuilder(url);
  }

  public static String getAirportDistance(String airportCode1, String airportCode2) {
    //Ik heb hier geen vliegtuig geselecteerd, kan dit ook meegeven voor meer accurate resultaten.
    //Het flightTimeModel gaat over het model dat de berekening uitvoert. Dit staat op standard, maar kan omgezet worden naar ML01. Maar deze is nog experimenteel.
    //LHR and LAX is the test code
    String url = "https://aerodatabox.p.rapidapi.com/airports/iata/" + airportCode1 + "/distance-time/" + airportCode2 + "?flightTimeModel=Standard&aircraftName=Standard";

    return clientBuilder(url);
  }

  private static String clientBuilder(String url){
    // Load environment variables from .env file
    Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("RAPIDAPI_KEY");
    String apiHost = dotenv.get("RAPIDAPI_HOST");

    try {
      //Create an HttpClient
      HttpClient client = HttpClient.newHttpClient();

      //Build the request with the URL, headers containing the API key and host
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(url))
          .header("X-Rapidapi-Host", apiHost)
          .header("X-Rapidapi-Key", apiKey)
          .method("GET", HttpRequest.BodyPublishers.noBody())
          .build();

      //Send the request and get the response
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      //Return the response body (JSON data)
      return response.body();

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return null; //Return null if an error occurs
    }
  }
}
