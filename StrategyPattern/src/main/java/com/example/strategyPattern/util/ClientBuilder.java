package com.example.strategyPattern.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientBuilder {

  public static String buildClient(String url, String apiHost) {
    Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("RAPIDAPI_KEY");

    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(url))
          .header("X-Rapidapi-Host", apiHost)
          .header("X-Rapidapi-Key", apiKey)
          .method("GET", HttpRequest.BodyPublishers.noBody())
          .build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      return response.body();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return null;
    }
  }
}