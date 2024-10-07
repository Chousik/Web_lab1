package org.chousik;

public class Main {
    DataService dataService = new DataService();
    Server server = new Server(dataService);
}