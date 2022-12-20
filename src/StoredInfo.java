import java.util.HashMap;

public class StoredInfo {
    HashMap<City, TravelDetails> travelInfo;

    public StoredInfo() {
        this.travelInfo = new HashMap<>();
    }

    public void addCity(City city){
        this.travelInfo.put(city, new TravelDetails());
    }
}
