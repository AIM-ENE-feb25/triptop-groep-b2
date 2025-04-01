package modulaireMobiliteit_Prototype.service;

import modulaireMobiliteit_Prototype.domain.Coordinate;
import modulaireMobiliteit_Prototype.domain.MapImage;
import modulaireMobiliteit_Prototype.domain.Route;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class MapBoxService implements MapService {

    @Value("${mapbox.api.url}")
    private String apiUrl;

    @Value("${mapbox.api.host}")
    private String apiHost;

    @Value("${mapbox.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Route getRoute(Coordinate start, Coordinate end) {
        String requestUrl = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .pathSegment(
                        start.getLongitude() + "," + start.getLatitude(),
                        end.getLongitude() + "," + end.getLatitude()
                )
                .queryParam("overview", "full")
                .queryParam("geometries", "geojson")
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", apiHost);
        headers.add("x-rapidapi-key", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.GET, entity, String.class);

        System.out.println("MapBox API Response via RapidAPI: " + response.getBody());

        return new Route(List.of(start, end)); // Later response parsing toevoegen
    }

    @Override
    public MapImage getMapImage(Coordinate location, int zoomLevel) {
        return null;
    }
}
