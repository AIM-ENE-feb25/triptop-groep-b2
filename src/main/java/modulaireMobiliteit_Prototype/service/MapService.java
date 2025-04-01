package modulaireMobiliteit_Prototype.service;

import modulaireMobiliteit_Prototype.domain.Coordinate;
import modulaireMobiliteit_Prototype.domain.MapImage;
import modulaireMobiliteit_Prototype.domain.Route;

public interface MapService {
    Route getRoute(Coordinate start, Coordinate end);
    MapImage getMapImage(Coordinate location, int zoomLevel);
}
