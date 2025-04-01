package modulaireMobiliteit_Prototype.controller;

import modulaireMobiliteit_Prototype.domain.Coordinate;
import modulaireMobiliteit_Prototype.domain.Route;
import modulaireMobiliteit_Prototype.service.MapService;
import modulaireMobiliteit_Prototype.factory.MapServiceFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapServiceFactory mapServiceFactory;

    public MapController(MapServiceFactory mapServiceFactory) {
        this.mapServiceFactory = mapServiceFactory;
    }

    @GetMapping("/route")
    public Route getRoute(
            @RequestParam String provider,
            @RequestParam double startLat,
            @RequestParam double startLng,
            @RequestParam double endLat,
            @RequestParam double endLng
    ) {
        System.out.println("Route opvragen van (" + startLat + ", " + startLng + ") naar (" + endLat + ", " + endLng + ") via " + provider);

        MapService mapService = mapServiceFactory.getMapService(provider);
        return mapService.getRoute(new Coordinate(startLat, startLng), new Coordinate(endLat, endLng));
    }
}
