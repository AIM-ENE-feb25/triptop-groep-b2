package modulaireMobiliteit_Prototype.service;

import modulaireMobiliteit_Prototype.domain.Coordinate;
import modulaireMobiliteit_Prototype.domain.MapImage;
import modulaireMobiliteit_Prototype.domain.Route;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@Service
public class MapBoxService implements MapService {

    @Value("${mapbox.api.url}")
    private String apiUrl;

    @Value("${mapbox.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<String> getRoute(Coordinate start, Coordinate end) {
        // Maak de URL
        String coordinates = start.getLongitude() + "," + start.getLatitude() + ";" +
                end.getLongitude() + "," + end.getLatitude();
        String requestUrl = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .pathSegment("", coordinates)
                .queryParam("access_token", apiKey)
                .queryParam("overview", "full")
                .queryParam("steps", "true")
                .queryParam("geometries", "geojson")
                .toUriString();

        // Maak de API-aanroep
        ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class);

        // Print de response voor debugging
        System.out.println("MapBox API Response: " + response.getBody());

        // Stuur de volledige response.body terug naar de controller en Postman
        return response;
    }

    @Override
    public MapImage getMapImage(Coordinate location, int zoomLevel) {
        return null; // Niet van toepassing in dit geval
    }
}
