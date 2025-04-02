package han.triptop.state;

public class MapboxRoutingCyclingState implements MapboxRoutingState {
  @Override
  public String getRouting() {
    return "cycling";
  }

  @Override
  public MapboxRoutingState nextRouting() {
    return new MapboxRoutingCyclingState();
  }
}
