package han.triptop.factory.service;

import han.triptop.factory.domain.Coordinate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MapBoxService implements MapService {
  private final RestTemplate restTemplate = new RestTemplate();

  @Override
  public ResponseEntity<String> getRoute(Coordinate start, Coordinate end) {
    String coordinates =
        start.longitude() + "," + start.latitude() + ";" + end.longitude() + "," + end.latitude();
    String apiUrl = "https://api.mapbox.com/directions/v5/mapbox/driving";
    String apiKey = "pk.eyJ1IjoiZW1pbGdhcmlib3YiLCJhIjoiY204eWVhOXYwMDBhYTJqc2twb3UwbWtveCJ9.N9oZF6uw01uZyJP2bmeGOg";
    String requestUrl = UriComponentsBuilder.fromHttpUrl(apiUrl)
        .pathSegment("", coordinates)
        .queryParam("access_token", apiKey)
        .queryParam("overview", "full")
        .queryParam("steps", "true")
        .queryParam("geometries", "geojson")
        .toUriString();
    return restTemplate.getForEntity(requestUrl, String.class);
  }
}
