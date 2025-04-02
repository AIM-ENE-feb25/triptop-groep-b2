package han.triptop.state;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class MapboxRoutingManager {
  private final OkHttpClient client = new OkHttpClient();
  private MapboxRoutingState routing = new MapboxRoutingDrivingState();

  public String getDirections(String origin, String[] waypoints, String destination) throws IOException {
    return this.buildRequest(this.buildUrl(origin, waypoints, destination));
  }

  @Nullable
  private String buildRequest(String url) throws IOException {
    Request request = new Request.Builder().url(url).get().build();
    try (Response response = this.client.newCall(request).execute()) {
      if (!response.isSuccessful()) {
        throw new IOException("Unexpected code " + response);
      }
      ResponseBody responseBody = response.body();
      return responseBody != null ? responseBody.string() : null;
    }
  }

  private String buildUrl(String origin, @Nullable String[] waypoints, String destination) {
    String baseUrl = "https://api.mapbox.com/directions/v5/mapbox";
    StringBuilder waypointsParameter = new StringBuilder();
    if (waypoints != null) {
      for (String waypoint : waypoints) {
        waypointsParameter.append(waypoint).append(';');
      }
    }
    return this.addAccessTokenToUrl("%s/%s/%s;%s%s".formatted(baseUrl, this.routing.getRouting(), origin, waypointsParameter, destination));
  }

  private String addAccessTokenToUrl(String url) {
    String apiKey = "pk.eyJ1IjoiZHZkd2hhbiIsImEiOiJjbTh4MGNtYmIwMHU2Mmtxc3JrdXFnYjF4In0.a92xTZD6NU7SQUiLWKP_8A";
    return url + "?access_token=" + apiKey;
  }

  public String getRouting() {
    return this.routing.getRouting();
  }

  public void nextRouting() {
    this.routing = this.routing.nextRouting();
  }
}
