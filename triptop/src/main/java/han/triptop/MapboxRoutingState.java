package han.triptop;

public interface MapboxRoutingState {
  String getRouting();

  MapboxRoutingState nextRouting();
}
