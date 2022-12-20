public class Main {
    public static void main(String[] args) {
        City tacoma = new City("Tacoma");
        City federalWay = new City("Federal Way");
        City auburn = new City("Auburn");
        City seattle = new City("Seattle");

        StoredInfo storedInfo = new StoredInfo();
        storedInfo.addCity(tacoma);
        storedInfo.addCity(federalWay);
        storedInfo.addCity(auburn);
        storedInfo.addCity(seattle);

        State washington = new State();
        washington.addCities(tacoma);
        washington.addCities(federalWay);
        washington.addCities(auburn);
        washington.addCities(seattle);
        washington.addRoad(tacoma, federalWay, 10);
        washington.addRoad(tacoma, auburn, 15);
        washington.addRoad(federalWay, auburn, 5);
        washington.addRoad(federalWay, seattle, 15);
        washington.addRoad(auburn, seattle, 20);

        Dijkstra.navi(tacoma, washington.adjCities, storedInfo.travelInfo);


    }
}