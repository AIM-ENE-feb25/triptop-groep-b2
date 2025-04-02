package han.triptop.factory.controller;

import han.triptop.factory.domain.Coordinate;
import han.triptop.factory.factory.MapServiceFactory;
import han.triptop.factory.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class MapController {
  private final MapServiceFactory mapServiceFactory;

  @Autowired
  public MapController(MapServiceFactory mapServiceFactory) {
    this.mapServiceFactory = mapServiceFactory;
  }

  @GetMapping("/route")
  public ResponseEntity<String> getRoute(
      @RequestParam String provider,
      @RequestParam double startLat,
      @RequestParam double startLng,
      @RequestParam double endLat,
      @RequestParam double endLng
  ) {
    MapService mapService = mapServiceFactory.getMapService(provider);
    return mapService.getRoute(new Coordinate(startLat, startLng), new Coordinate(endLat, endLng));
  }
}
