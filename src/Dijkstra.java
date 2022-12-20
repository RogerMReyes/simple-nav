import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {
    public static void navi(City start, HashMap<City, List<Road>> adjCities, HashMap<City, TravelDetails> travelInfo){

        travelInfo.get(start).totalTravelTime = 0;

        List<City> completedCities = new ArrayList<>();
        List<City> citiesToCheck = new ArrayList<>();

        citiesToCheck.add(start);

        while(!citiesToCheck.isEmpty()){
            City currentCity = citiesToCheck.get(0);
            citiesToCheck.remove(currentCity);

            for(Road road : adjCities.get(currentCity)){
                if(!completedCities.contains(road.destination)){
                    calcMinTime(currentCity,road.destination, road.travelTime, travelInfo);
                    citiesToCheck.add(road.destination);
                }
            }
            completedCities.add(currentCity);
        }
    }

    public static void calcMinTime(City currentCity, City destination, int roadTravelTime, HashMap<City, TravelDetails> travelInfo){
        TravelDetails currentCityDetails = travelInfo.get(currentCity);
        TravelDetails destinationCityDetails = travelInfo.get(destination);
        if(currentCityDetails.totalTravelTime + roadTravelTime < destinationCityDetails.totalTravelTime){
            destinationCityDetails.totalTravelTime = currentCityDetails.totalTravelTime + roadTravelTime;
            ArrayList<City> shortestPath = new ArrayList<>(currentCityDetails.shortestPathFromSource);
            shortestPath.add(currentCity);
            destinationCityDetails.shortestPathFromSource = shortestPath;
        }
    }
}
