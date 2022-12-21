import java.util.ArrayList;
import java.util.List;

//Class to help hold information and make utilizing Dijkstra's Algorithm easier
public class TravelDetails {
    // Will hold a List of Cities that represents the shortest route from the chosen City source.
    public List<City> shortestPathFromSource;

    // Will be used to keep track of the total travelTime from the chosen City source
    public int totalTravelTime;

    // When creating a new TravelDetail shortestPath with have a new/blank ArrayList
    // totalTravelTime from source has yet to be found so the value is set to the maximum value to represent infinity
    public TravelDetails() {
        shortestPathFromSource = new ArrayList<>();
        totalTravelTime = Integer.MAX_VALUE;
    }
}
