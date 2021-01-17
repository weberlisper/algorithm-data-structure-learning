package algorithm.sort;

import utils.ArrayGenerator;
import utils.SortTest;

/**
 * 实现自底向上的归并排序算法
 */
public class MergeSortBU {

    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        E[] temp = (E[]) new Comparable[data.length];
        int n = data.length;
        // 遍历合并的区间的长度
        for (int sz = 1; sz < n; sz += sz) {
            // 合并[i, i + sz -1]和[i + sz, Math.min(i + sz + sz - 1, n -1)]
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (data[i + sz - 1].compareTo(data[i + sz]) > 0) {
                    merge(data, i, i + sz - 1, Math.min(n - 1, i + sz + sz - 1), temp);
                }
            }
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
        SortTest.test("MergeSortBU", randomArr);
    }

}
