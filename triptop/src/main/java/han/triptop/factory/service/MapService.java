package han.triptop.factory.service;

import han.triptop.factory.domain.Coordinate;
import org.springframework.http.ResponseEntity;

public interface MapService {
  ResponseEntity<String> getRoute(Coordinate start, Coordinate end);
}
