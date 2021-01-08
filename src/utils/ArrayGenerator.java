package utils;

public class ArrayGenerator {
    private ArrayGenerator() {

    }

    public static Integer[] generateOrderIntArray(int len) {
        Integer[] data = new Integer[len];
        for (int i = 0; i < len; i++) {
            data[i] = i;
        }
        return data;
    }

}
