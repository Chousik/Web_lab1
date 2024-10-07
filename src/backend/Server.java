package backend;

import java.io.IOException;

public class Server {
    private final DataService dataService;
    private final

    public Server(DataService dataService){
        this.dataService = dataService;
    }

    public void run(){
        dataService.check(1, 1, 1);
    }

    private double[] readRequest() throws IOException{
        return null;
    }
}
