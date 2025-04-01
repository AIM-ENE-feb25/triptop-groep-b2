package han.triptop;

public class MapboxRoutingDrivingState implements MapboxRoutingState {
  @Override
  public String getRouting() {
    return "driving";
  }

  @Override
  public MapboxRoutingState nextRouting() {
    return new MapboxRoutingCyclingState();
  }
}
