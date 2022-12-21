import java.util.HashMap;

// Class to help store the shortest path data created from running Dijkstra's Algorithm
public class StoredInfo {

    // When passing a City as the KEY, travelInfo will return the travel details from the chosen City Source
    HashMap<City, TravelDetails> travelInfo;

    //Constructor: When creating a new StoredInfo it will set travelInfo with a new/blank hashmap
    public StoredInfo() {
        this.travelInfo = new HashMap<>();
    }

    // Used to add all cities to the hashmap with a new TravelDetails object
    public void addCity(City city){
        this.travelInfo.put(city, new TravelDetails());
    }
}
