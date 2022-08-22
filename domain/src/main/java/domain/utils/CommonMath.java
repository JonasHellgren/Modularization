package domain.utils;

public class CommonMath {

    public static boolean isZero(float num) {
        return Math.abs(num) < Float.MIN_VALUE;
    }

    public static float safeDiv(float a, float b) {

        return isZero(b)
                ?Float.MAX_VALUE
                :a/b;
    }

}
