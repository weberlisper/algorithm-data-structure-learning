package utils;

import java.util.Random;

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

    public static Integer[] generateRandomIntArray(int len, int bound) {
        Random random = new Random();
        Integer[] data = new Integer[len];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(bound);
        }
        return data;
    }

}
