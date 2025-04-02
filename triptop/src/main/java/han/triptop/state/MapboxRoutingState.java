package han.triptop.state;

public interface MapboxRoutingState {
  String getRouting();

  MapboxRoutingState nextRouting();
}
