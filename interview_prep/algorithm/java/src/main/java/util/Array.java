package util;

import java.util.Arrays;

public class Array {
    public static<T> T[] tail(T[] array) {
        return Arrays.copyOfRange(array, 1, array.length-1);
    }

    public static int[] tail(int[] original) {
        if(original.length <= 1) return new int[]{};
        return Arrays.copyOfRange(original, 1, original.length);
    }
}
