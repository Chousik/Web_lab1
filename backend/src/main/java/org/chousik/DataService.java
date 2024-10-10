package org.chousik;

import static java.lang.Math.abs;

public class DataService {

    public boolean valid(Data data){
        return 2 <= data.getR() && data.getR() <= 5 && abs(data.getY()) <= 5 && -3 <= data.getX() && 5 >= data.getX();
    }
    public boolean check(Data data){
        return  (data.getX() >= 0 && data.getY() >= 0 && Math.sqrt(data.getX() * data.getX() + data.getY() * data.getY()) <= data.getR()) || // it's a circle
                (data.getX() >= 0 && data.getY() < 0 && data.getY() >= -data.getR() / 2 && data.getX() <= data.getR()) || // it's a rectangle
                (data.getY()<=0 && -(data.getX() + data.getR() / 2) <= data.getY()); // it's a triangle
        }
}
