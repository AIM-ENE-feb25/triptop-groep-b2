package modulaireMobiliteit_Prototype.factory;

import modulaireMobiliteit_Prototype.service.GoogleMapsService;
import modulaireMobiliteit_Prototype.service.MapBoxService;
import modulaireMobiliteit_Prototype.service.MapService;
import org.springframework.stereotype.Component;

@Component
public class MapServiceFactory {

    private final GoogleMapsService googleMapsService;
    private final MapBoxService mapBoxService;

    public MapServiceFactory(GoogleMapsService googleMapsService, MapBoxService mapBoxService) {
        this.googleMapsService = googleMapsService;
        this.mapBoxService = mapBoxService;
    }

    public MapService getMapService(String provider) {
        return switch (provider.toLowerCase()) {
            case "googlemaps" -> googleMapsService;
            case "mapbox" -> mapBoxService;
            default -> throw new IllegalArgumentException("Unknown provider: " + provider);
        };
    }
}