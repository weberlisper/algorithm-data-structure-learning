package algorithm.sort;

import utils.ArrayGenerator;
import utils.SortTest;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        Random random = new Random();
        sort(data, 0, data.length - 1, random);
    }

    // 宏观语义：该函数的功能用于对数组data的区间[l, r]进行排序
    private static <E extends Comparable<E>> void sort(E[] data, int l, int r, Random random) {
        // 最简单的情况
        if (l >= r) {
            return;
        }

        // 先解决更小的问题
        int p = partition(data, l, r, random);
        sort(data, l, p - 1, random);
        sort(data, p + 1, r, random);
    }

    // 将data[l, r]划分为三部分data[l, j-1]、data[j]、data[p+1, r]，其中，data[l, j-1]所有元素都比data[j]小，data[j+1, r]所有元素都比data[j]要大
    private static <E extends Comparable<E>> int partition(E[] data, int l, int r, Random random) {
        int p = random.nextInt(r - l + 1) + l;
        Utils.swap(data, l, p);

        E v = data[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (data[i].compareTo(v) < 0) {
                j++;
                Utils.swap(data, i, j);
            }
        }
        Utils.swap(data, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort2ways(E[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        Random random = new Random();
        sort2ways(data, 0, data.length - 1, random);
    }

    // 宏观语义：该函数的功能用于对数组data的区间[l, r]进行排序
    private static <E extends Comparable<E>> void sort2ways(E[] data, int l, int r, Random random) {
        // 最简单的情况
        if (l >= r) {
            return;
        }

        // 先解决更小的问题
        int p = partition2(data, l, r, random);
        sort2ways(data, l, p - 1, random);
        sort2ways(data, p + 1, r, random);
    }

    // 将data[l, r]划分为三部分data[l, j-1]、data[j]、data[p+1, r]，其中，data[l, j-1]所有元素都比data[j]小，data[j+1, r]所有元素都比data[j]要大
    private static <E extends Comparable<E>> int partition2(E[] data, int l, int r, Random random) {
        int p = random.nextInt(r - l + 1) + l;
        Utils.swap(data, l, p);

        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && data[i].compareTo(data[l]) < 0) {
                i++;
            }
            while (j >= i && data[j].compareTo(data[l]) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            Utils.swap(data, i, j);
            i++;
            j--;
        }
        Utils.swap(data, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3ways(E[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        Random random = new Random();
        sort3ways(data, 0, data.length - 1, random);
    }

    // 宏观语义：该函数的功能用于对数组data的区间[l, r]进行排序
    private static <E extends Comparable<E>> void sort3ways(E[] data, int l, int r, Random random) {
        // 最简单的情况
        if (l >= r) {
            return;
        }

        int lt = l, gt = r + 1, i = l;
        // 维持循环不变量：data[l+1, lt] < v, data[lt+1, i-1]=v, data[gt, r]>v
        while (i < gt) {
            if (data[i].compareTo(data[l]) < 0) {
                lt++;
                Utils.swap(data, lt, i);
                i++;
            } else if (data[i].compareTo(data[l]) > 0) {
                gt--;
                Utils.swap(data, gt, i);
            } else {
                i++;
            }
        }
        Utils.swap(data, l, lt);
        //此时，data[l, lt-1] < v, data[lt, i-1]=v, data[gt, r]>v
        sort3ways(data, l, lt - 1, random);
        sort3ways(data, gt, r, random);
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] randomArr = ArrayGenerator.generateRandomIntArray(n, n);
        Integer[] randomArr2 = Arrays.copyOf(randomArr, randomArr.length);
        Integer[] randomArr3 = Arrays.copyOf(randomArr, randomArr.length);
        SortTest.test("QuickSort", randomArr);
        SortTest.test("QuickSort2Ways", randomArr2);
        SortTest.test("QuickSort3Ways", randomArr3);
    }

}
