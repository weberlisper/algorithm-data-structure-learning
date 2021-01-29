package algorithm.sort;

import utils.ArrayGenerator;
import utils.SortTest;
import utils.Utils;

public class BubbleSort {

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = data.length; i > 1; i--) {
            for (int j = 0; j + 1 < i; j++) {
                boolean isOrder = true;
                if (data[j].compareTo(data[j + 1]) > 0) {
                    Utils.swap(data, j, j + 1);
                    isOrder = false;
                }
                if (isOrder) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 100_000;
        Integer[] data = ArrayGenerator.generateRandomIntArray(n, n);
        SortTest.test("BubbleSort", data);
    }
}
