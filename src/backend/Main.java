package backend;

import static java.lang.Math.abs;

public class Main {
    DataService dataService = new DataService();
    Server server = new Server(dataService);
}