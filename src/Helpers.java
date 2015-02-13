import java.util.Random;

public final class Helpers {

    private Helpers () { }

    public static int Random(int a, int b) {
        double result = Math.random() * (b - a + 1) + a;
        return (int) Math.floor(result);
    }

    public static double RadiansToDegree(int radians) {
        return radians * (180 / Math.PI);
    }

    public static double DegreesToRadians(int degrees) {
        return degrees * (Math.PI / 180);
    }

}
