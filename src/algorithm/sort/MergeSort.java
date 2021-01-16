package algorithm.sort;

import utils.ArrayGenerator;
import utils.SortTest;

import java.util.Arrays;

public class MergeSort {

    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        sort(data, 0, data.length - 1);
    }

    // 对数组data的区间[l .. r]进行排序
    private static <E extends Comparable<E>> void sort(E[] data, int l, int r) {
        // 最简单的问题
        if (l >= r) {
            return;
        }

        // 先求解更小的问题
        int mid = l + (r - l) / 2;
        sort(data, l, mid);
        sort(data, mid + 1, r);

        // 根据最小问题的解解决当前问题
        merge(data, l, mid, r);
    }

    // 数组data的区间[l .. mid][mid+1 .. r]分别是有序的，对这两个区间的元素进行合并排序
    private static <E extends Comparable<E>> void merge(E[] data, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(data, l, r + 1);

        int i = l;
        int j = mid + 1;
        // k轮询愿数组待操作区域的索引，用于放入新元素
        for (int k = l; k <= r; k++) {
            if (j > r) {
                data[k] = temp[i - l];
                i++;
            } else if (i > mid) {
                data[k] = temp[j - l];
                j++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                data[k] = temp[i - l];
                i++;
            } else {
                data[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};

        for (int n : dataSize) {
            Integer[] randomArr = ArrayGenerator.generateRandomIntArray(n, n);
            Integer[] randomArr2 = Arrays.copyOf(randomArr, n);
            SortTest.test("InsertionSort2", randomArr);
            SortTest.test("MergeSort", randomArr2);
        }
    }

}
