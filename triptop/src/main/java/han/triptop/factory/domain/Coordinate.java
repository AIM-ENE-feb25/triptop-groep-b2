package han.triptop.factory.domain;

public record Coordinate(double latitude, double longitude) {
  @Override
  public String toString() {
    return "Coordinate{" + "latitude=" + latitude + ", longitude=" + longitude + '}';
  }
}
