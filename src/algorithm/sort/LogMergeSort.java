package algorithm.sort;

import utils.ArrayGenerator;
import utils.SortTest;

import java.util.Arrays;

// 增加归并排序的打印，以看清排序过程
public class LogMergeSort {

    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        sort(data, 0, data.length - 1, 1);
    }

    // 对数组data的区间[l .. r]进行排序
    private static <E extends Comparable<E>> void sort(E[] data, int l, int r, int depth) {
        System.out.print(generateDepthStr(depth));
        System.out.println(String.format("mergeSort arr[%d, %d]", l, r));

        // 最简单的问题
        if (l >= r) {
            return;
        }

        // 先求解更小的问题
        int mid = l + (r - l) / 2;
        sort(data, l, mid, depth + 1);
        sort(data, mid + 1, r, depth + 1);

        System.out.print(generateDepthStr(depth));
        System.out.println(String.format("merge arr[%d, %d] and arr[%d, %d]", l, mid, mid + 1, r));
        // 根据最小问题的解解决当前问题
        merge(data, l, mid, r);
        System.out.print(generateDepthStr(depth));
        System.out.print(String.format("after mergesort arr[%d, %d]: ", l, r));
        for (E datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    private static String generateDepthStr(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
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
        Integer[] nums = {9, 4, 10, 8, 5, 19, 47, 32, 3};
        LogMergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
