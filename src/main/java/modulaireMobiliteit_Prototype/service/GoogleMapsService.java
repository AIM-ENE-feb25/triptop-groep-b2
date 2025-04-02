package modulaireMobiliteit_Prototype.service;

import modulaireMobiliteit_Prototype.domain.Coordinate;
import modulaireMobiliteit_Prototype.domain.MapImage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;

import java.util.List;

@Service
public class GoogleMapsService implements MapService {

    @Value("${google.maps.api.url}")
    private String apiUrl;

    @Value("${google.maps.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<String> getRoute(Coordinate start, Coordinate end) {
        String requestUrl = apiUrl + "?origin=" + start.getLatitude() + "," + start.getLongitude()
                + "&destination=" + end.getLatitude() + "," + end.getLongitude()
                + "&key=" + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class, entity);

        System.out.println("Google Maps API Response: " + response.getBody());

        return response;
    }

    @Override
    public MapImage getMapImage(Coordinate location, int zoomLevel) {
        return null;
    }
}
