package han.triptop.factory.factory;

import han.triptop.factory.service.GoogleMapsService;
import han.triptop.factory.service.MapBoxService;
import han.triptop.factory.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceFactory {
  private final GoogleMapsService googleMapsService;
  private final MapBoxService mapBoxService;

  @Autowired
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