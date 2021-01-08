package linearsearch;

import utils.ArrayGenerator;

public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSize = {100000, 1000000, 10000000, 100000000};
        for (int len : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderIntArray(len);
            long startTime = System.currentTimeMillis();
            LinearSearch.search(data, len - 1);
            long costTime = System.currentTimeMillis() - startTime;
            System.out.println(String.format("n = %d, costTime: %fS", len, costTime / 1000.0f));
        }
    }

}
