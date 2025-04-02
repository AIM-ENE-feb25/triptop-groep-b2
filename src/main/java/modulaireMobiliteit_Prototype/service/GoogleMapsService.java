package modulaireMobiliteit_Prototype.service;

import modulaireMobiliteit_Prototype.domain.Coordinate;
import modulaireMobiliteit_Prototype.domain.MapImage;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleMapsService implements MapService {

    private final String apiUrl = "https://google-map-places-new-v2.p.rapidapi.com/v1/places";
    private final String rapidApiKey = "ee6ecdfec2msh83d0f9fb789fbd9p1c008ejsn35278cb79928";  // Zet hier jouw RapidAPI key
    private final String rapidApiHost = "google-map-places-new-v2.p.rapidapi.com";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<String> getRoute(Coordinate start, Coordinate end) {
        // Hier gebruiken we een place_id als voorbeeld (je kunt dit aanpassen voor routeberekening)
        String placeId = "ChIJj61dQgK6j4AR4GeTYWZsKWw"; // Dit moet dynamisch komen van je input

        String requestUrl = UriComponentsBuilder.fromHttpUrl(apiUrl + "/" + placeId)
                .toUriString();

        // Headers instellen
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", rapidApiKey);
        headers.set("x-rapidapi-host", rapidApiHost);
        headers.set("X-Goog-FieldMask", "*");
        headers.set("Content-Type", "application/json");

        // Maak HTTP-request
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                entity,
                String.class
        );

        System.out.println("Google Maps API Response: " + response.getBody());

        return response;
    }

    @Override
    public MapImage getMapImage(Coordinate location, int zoomLevel) {
        return null; // Niet nodig voor deze implementatie
    }
}
