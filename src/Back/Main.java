package Back;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        System.out.println();
    }
    public static returnCode Check () {
        float R = Float.parseFloat(System.getenv("R"));
        float x = Float.parseFloat(System.getenv("x"));
        float y = Float.parseFloat(System.getenv("y"));
        if (!(2<=R && R<=5 && abs(y)<=5 && -3<=x && 5>=x)){
            return returnCode.errorData;
        }
        if (x >= 0 && y >= 0 && Math.sqrt(x * x + y * y) <= R) {
            return returnCode.valid;
        } else if (x >= 0 && y < 0 && y >= -R / 2 && x <= R) {
            return returnCode.valid;
        } else if (y<=0 && -(x + R / 2) <= y){
            return returnCode.valid;
        }
        return returnCode.invalid;
    }
    public enum returnCode{
        valid,
        invalid,
        errorData
    }
}