package sort;

import utils.ArrayGenerator;
import utils.SortTest;
import utils.Utils;

public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            // 这个循环体的作用是维持循环不变量data[0 ... i)都是已排序的
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                // 这个循环体的作用是寻找最小元素的坐标
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Utils.swap(data, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomIntArray(n, n);
            SortTest.test("SelectionSort", arr);
        }
    }
}
