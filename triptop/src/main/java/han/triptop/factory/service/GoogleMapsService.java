package han.triptop.factory.service;

import han.triptop.factory.domain.Coordinate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleMapsService implements MapService {
  private final RestTemplate restTemplate = new RestTemplate();

  @Override
  public ResponseEntity<String> getRoute(Coordinate start, Coordinate end) {
    String placeId = "ChIJj61dQgK6j4AR4GeTYWZsKWw";
    String apiUrl = "https://google-map-places-new-v2.p.rapidapi.com/v1/places";
    String requestUrl = UriComponentsBuilder.fromHttpUrl(apiUrl + "/" + placeId).toUriString();
    HttpHeaders headers = new HttpHeaders();
    String rapidApiKey = "ee6ecdfec2msh83d0f9fb789fbd9p1c008ejsn35278cb79928";
    headers.set("x-rapidapi-key", rapidApiKey);
    String rapidApiHost = "google-map-places-new-v2.p.rapidapi.com";
    headers.set("x-rapidapi-host", rapidApiHost);
    headers.set("X-Goog-FieldMask", "*");
    headers.set("Content-Type", "application/json");
    HttpEntity<String> entity = new HttpEntity<>(headers);
    return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, String.class);
  }
}
