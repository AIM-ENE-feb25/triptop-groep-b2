package han.triptop;

public class MapboxRoutingWalkingState implements MapboxRoutingState {
  @Override
  public String getRouting() {
    return "walking";
  }

  @Override
  public MapboxRoutingState nextRouting() {
    return new MapboxRoutingCyclingState();
  }
}
