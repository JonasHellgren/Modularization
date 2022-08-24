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
        // if the length of the two arrays are not
        // same then the arrays cannot be equal
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {

            // if the two ith elements of the two arrays
            // are not same then simply return false
            // and do not check further elements
            if (Math.abs(arr1[i] - arr2[i])>delta)
                return false;
        }

        // else if we come out of the for loop
        // successfully without returning false ,
        // then that means all the elements were equal
        return true;
    }

}
