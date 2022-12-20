import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class State {
    HashMap<City, List<Road>> adjCities;

    public State() {
        this.adjCities = new HashMap<>();
    }

    public void addCities(City city){
        adjCities.put(city, new ArrayList<>());
    }

    public void addRoad(City location1, City location2, int travelTime){
        //TODO: Verify both locations are already in the hashmap
        adjCities.get(location1).add(new Road(location2, travelTime));
        adjCities.get(location2).add(new Road(location1, travelTime));
    }
}
