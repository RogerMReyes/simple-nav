import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class State {
    // Holds KEY : Value Pairs
    // When passing a City as a KEY, adjCities will return a List of Roads as the VALUE representing the roads
    // associated with the city
    HashMap<City, List<Road>> adjCities;

    //Constructor: When creating a State object adjCities is set with a new/blank hashmap
    public State() {
        this.adjCities = new HashMap<>();
    }

    //Adds a city as the KEY to adjCities and creates an empty array as the VALUE
    public void addCity(City city){
        adjCities.put(city, new ArrayList<>());
    }

    //Takes in two Cities and adds a road leading to each other in their respective List of Roads
    public void addRoad(City location1, City location2, int travelTime){
        //TODO: Verify both locations are already in the hashmap
        adjCities.get(location1).add(new Road(location2, travelTime));
        adjCities.get(location2).add(new Road(location1, travelTime));
    }
}
