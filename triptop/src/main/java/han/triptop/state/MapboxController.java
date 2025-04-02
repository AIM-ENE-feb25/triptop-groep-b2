package han.triptop.state;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MapboxController {
  private final MapboxService mapboxService;

  public MapboxController(MapboxService mapboxService) {
    this.mapboxService = mapboxService;
  }

  @GetMapping("/directions")
  public String getDirections(
      @RequestParam String origin,
      @RequestParam(required = false) String[] waypoints,
      @RequestParam String destination
  ) throws IOException {
    return this.mapboxService.getDirections(origin, waypoints, destination);
  }

  @GetMapping("/routing")
  public String getRouting() {
    return this.mapboxService.getRouting();
  }

  @PostMapping("/routing")
  public String nextRouting() {
    this.mapboxService.nextRouting();
    return this.mapboxService.getRouting();
  }

  @Service
  public static class MapboxService {
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
}
