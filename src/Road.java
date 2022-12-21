//Represents an "Edge" in Graph datastructures
public class Road {
    //City designated as the endpoint of the Edge
    public City destination;

    //Represents the "Weight" of the Edge.
    public int travelTime;

    // Constructor: requires a City and travel time for the Road to instantiate a new Road
    public Road(City destination, int travelTime) {
        this.destination = destination;
        this.travelTime = travelTime;
    }
}
