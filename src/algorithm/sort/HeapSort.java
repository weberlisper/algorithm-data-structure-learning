package algorithm.sort;

import utils.ArrayGenerator;
import utils.SortTest;
import utils.Utils;

public class HeapSort {

    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        // Heapify
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length - 1);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            Utils.swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (k * 2 + 1 < n) {
            int j = k * 2 + 1;
            if (j + 1 < n
                    && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }

            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            Utils.swap(data, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] randomArr = ArrayGenerator.generateRandomIntArray(n, n);
        SortTest.test("HeapSort", randomArr);
    }
}
