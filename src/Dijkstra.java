import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Responsible for finding the shortest path in Graph Datastructures
public class Dijkstra {
    // Takes in a starting City source, a map to get Roads associated with Cities, and a map to get TravelDetails associated with Cities
    public static void navi(City start, HashMap<City, List<Road>> adjCities, HashMap<City, TravelDetails> travelInfo){

        // Starting location - travel time will be 0
        travelInfo.get(start).totalTravelTime = 0;

        // Once a city has all roads "checked" they are moved to completedCities to prevent checking the same roads
        List<City> completedCities = new ArrayList<>();
        // Responsible for holding cities to be checked
        List<City> citiesToCheck = new ArrayList<>();

        // Starting location will be the first city to check
        citiesToCheck.add(start);

        // Loop will run until all cities have been checked, Once their are no more cities the loop will break
        while(!citiesToCheck.isEmpty()){
            // Grabs reference of the first city in the citiesToCheck array
            City currentCity = citiesToCheck.get(0);
            // Once reference is grabbed, the City is taken out of the citiesToCheck array
            citiesToCheck.remove(currentCity);

            // We can now go through all roads associated to our referenced city by passing it into our adjCities hashmap
            for(Road road : adjCities.get(currentCity)){
                // If conditional only runs if the destination City is not in the completedCities, this prevents rechecking the same Cities
                if(!completedCities.contains(road.destination)){
                    // Local function
                    calcMinTime(currentCity,road.destination, road.travelTime, travelInfo);
                    citiesToCheck.add(road.destination);
                }
            }
            completedCities.add(currentCity);
        }
    }

    // This function is responsible for checking if the destination travel time from the current path is shorter
    // than what is already set. If shorter, then the information will be updated with the current path info
    public static void calcMinTime(City currentCity, City destination, int roadTravelTime, HashMap<City, TravelDetails> travelInfo){
        // Simplifies grabbing travel details of current and destination city
        TravelDetails currentCityDetails = travelInfo.get(currentCity);
        TravelDetails destinationCityDetails = travelInfo.get(destination);

        // if the current paths time plus the roads time is less than what is currently set at the destination
        // then the information will be replaced with the current paths info
        if(currentCityDetails.totalTravelTime + roadTravelTime < destinationCityDetails.totalTravelTime){
            destinationCityDetails.totalTravelTime = currentCityDetails.totalTravelTime + roadTravelTime;
            ArrayList<City> shortestPath = new ArrayList<>(currentCityDetails.shortestPathFromSource);
            shortestPath.add(currentCity);
            destinationCityDetails.shortestPathFromSource = shortestPath;
        }
    }
}
