package org.chousik;

import com.fastcgi.FCGIInterface;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DataService dataService = new DataService();
        FCGIInterface fcgiInterface = new FCGIInterface();
        Server server = new Server(dataService, fcgiInterface);
        server.start();
    }
}