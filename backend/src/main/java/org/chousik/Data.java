package org.chousik;

public class Data {
    private final int x;
    private final double y;
    private final double r;

    public Data(int x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }
}
