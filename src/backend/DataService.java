package backend;

import static java.lang.Math.abs;

public class DataService {
    public boolean valid(int x, double y, double r){
        return 2 <= r && r <= 5 && abs(y) <= 5 && -3 <= x && 5 >= x;
    }
    public boolean check(int x, double y, double r){
        return  (x >= 0 && y >= 0 && Math.sqrt(x * x + y * y) <= r) || // it's a circle
                (x >= 0 && y < 0 && y >= -r / 2 && x <= r) || // it's a rectangle
                (y<=0 && -(x + r / 2) <= y); // it's a triangle
        }
    }

}
