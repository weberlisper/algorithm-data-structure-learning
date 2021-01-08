package utils;

import sort.SelectionSort;

public class SortTestUtils {
    private SortTestUtils() {
    }

    private static <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i].compareTo(data[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void testSort(String sortName) {
        int[] dataSize = {1000, 10000, 100000};
        for (int len : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomIntArray(len, len);
            long startTime = System.currentTimeMillis();
            if (sortName.equals(SelectionSort.class.getSimpleName())) {
                SelectionSort.sort(data);
            }
            long costTime = System.currentTimeMillis() - startTime;
            if (!isSorted(data)) {
                throw new RuntimeException(sortName + " sort failed");
            }
            System.out.println(String.format("%s: n = %d, costTime: %fS", sortName, len, costTime / 1000.0f));
        }
    }

}
