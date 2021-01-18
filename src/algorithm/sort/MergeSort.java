package algorithm.sort;

import utils.ArrayGenerator;
import utils.SortTest;

public class MergeSort {
    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        E[] temp = (E[]) new Comparable[data.length];
        sort(data, 0, data.length - 1, temp);
    }

     // 对数组data的区间[l .. r]进行排序
    private static <E extends Comparable<E>> void sort(E[] data, int l, int r, E[] temp) {
        // 最简单的问题
        if (r - l <= 15) {
            InsertionSort.sort(data, l, r);
            return;
        }
        // 先求解更小的问题
        int mid = l + (r - l) / 2;
        sort(data, l, mid, temp);
        sort(data, mid + 1, r, temp);
        // 根据最小问题的解解决当前问题
        if (data[mid].compareTo(data[mid + 1]) > 0) {
            merge(data, l, mid, r, temp);
        }
    }

    // 数组data的区间[l .. mid][mid+1 .. r]分别是有序的，对这两个区间的元素进行合并排序
    private static <E extends Comparable<E>> void merge(E[] data, int l, int mid, int r, E[] temp) {
        System.arraycopy(data, l, temp, l, r - l + 1);

        int i = l;
        int j = mid + 1;
        // k轮询愿数组待操作区域的索引，用于放入新元素
        for (int k = l; k <= r; k++) {
            if (j > r) {
                data[k] = temp[i++];
            } else if (i > mid) {
                data[k] = temp[j++];
            } else if (temp[i].compareTo(temp[j]) < 0) {
                data[k] = temp[i++];
            } else {
                data[k] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] randomArr = ArrayGenerator.generateRandomIntArray(n, n);
        SortTest.test("MergeSort", randomArr);
    }
}


