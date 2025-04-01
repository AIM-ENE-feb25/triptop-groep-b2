package modulaireMobiliteit_Prototype.domain;

import java.util.List;

public class Route {
    private final List<Coordinate> points;

    public Route(List<Coordinate> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("Route must have at least one coordinate.");
        }
        this.points = List.copyOf(points); // Immutable list
    }

    public List<Coordinate> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Route{" +
                "points=" + points +
                '}';
    }
}
