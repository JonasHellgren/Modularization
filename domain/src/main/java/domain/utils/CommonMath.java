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

    public static boolean compareArrays(float arr1[],float arr2[], float delta)
    {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {

            if (Math.abs(arr1[i] - arr2[i])>delta)
                return false;
        }
        return true;
    }


    public static boolean compareIntScalars(int s1,int s2, int delta)
    {
        return (Math.abs(s1-s2)<delta);
    }

}
