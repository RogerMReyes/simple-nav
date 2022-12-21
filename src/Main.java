import java.util.Scanner;

public class Main {
    static City tacoma = new City("Tacoma");
    static City federalWay = new City("Federal Way");
    static City auburn = new City("Auburn");
    static City seattle = new City("Seattle");
    public static void main(String[] args) {

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
        navPrompt(washington, storedInfo);

    }

        public static void navPrompt(State state, StoredInfo travelInfo){
            Scanner scan = new Scanner(System.in);
            City currentLocation = null;
            boolean prompt1 = true;
            while(prompt1) {
                boolean prompt2 = true;
                System.out.println("""
                    Choose a starting location!
                    1) Tacoma,
                    2) Federal Way,
                    3) Auburn,
                    4) Seattle""");
                int choice = scan.nextInt();
                switch (choice) {
                    case 1 -> currentLocation = tacoma;
                    case 2 -> currentLocation = federalWay;
                    case 3 -> currentLocation = auburn;
                    case 4 -> currentLocation = seattle;
                    default -> System.out.println("Please choose one of the options!");
                }
                while(prompt2) {
                    System.out.printf("""
                        Current Location : %s
                        Choose a destination!
                        1) Tacoma,
                        2) Federal Way,
                        3) Auburn,
                        4) Seattle%n""", currentLocation.name);
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1 -> navigate(currentLocation, tacoma, state, travelInfo);
                        case 2 -> navigate(currentLocation, federalWay, state, travelInfo);
                        case 3 -> navigate(currentLocation, auburn, state, travelInfo);
                        case 4 -> navigate(currentLocation, seattle, state, travelInfo);
                        default -> System.out.println("Please choose one of the options!");
                    }
                    System.out.println("""
                        1) Check another destination.
                        2) Choose another Starting location
                        3) Exit""");
                    choice = scan.nextInt();
                    switch (choice){
                        case 1 -> System.out.println("Okay!");
                        case 2 -> {
                            prompt2 = false;
                            travelInfo.travelInfo.replaceAll((k, v) -> new TravelDetails());
                        }
                        case 3 -> {
                            prompt2 = false;
                            prompt1 = false;
                        }
                    }
                }
            }
    }
    public static void navigate(City currentLocation, City destination, State state, StoredInfo storedInfo){
        Dijkstra.navi(currentLocation, state.adjCities, storedInfo.travelInfo);
        for(City city : storedInfo.travelInfo.get(destination).shortestPathFromSource){
            System.out.print(city.name + " --> ");
        }
        System.out.println(destination.name);
        System.out.println(storedInfo.travelInfo.get(destination).totalTravelTime + "min drive");
    }
}