package han.triptop;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MapboxService {
  private final MapboxRoutingManager mapboxRoutingManager = new MapboxRoutingManager();

  public String getDirections(String origin, @Nullable String[] waypoints, String destination) throws IOException {
    return this.mapboxRoutingManager.getDirections(origin, waypoints, destination);
  }

  public String getRouting() {
    return this.mapboxRoutingManager.getRouting();
  }

  public void nextRouting() {
    this.mapboxRoutingManager.nextRouting();
  }
}
