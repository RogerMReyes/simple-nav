import java.util.ArrayList;
import java.util.List;

public class TravelDetails {
    public List<City> shortestPathFromSource;
    public int totalTravelTime;

    public TravelDetails() {
        shortestPathFromSource = new ArrayList<>();
        totalTravelTime = Integer.MAX_VALUE;
    }
}
