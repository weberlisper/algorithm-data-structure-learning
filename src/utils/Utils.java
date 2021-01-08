package utils;

public class Utils {

    public static <E> void swap(E[] data, int i, int j) {
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

}
