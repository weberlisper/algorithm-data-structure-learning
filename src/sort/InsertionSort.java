package sort;

import utils.ArrayGenerator;
import utils.SortTest;
import utils.Utils;

import java.util.Arrays;

/**
 * 插入排序假设排序中的数组分两段，已排好序的前半部分data[0...i)和未排序的后半部分data[i...data.length)。
 * 循环遍历数组,每次将data[i]插入到已排好序的前半部分，排序部分每次递增1直至全部排序完成。
 * 插入排序的循环不变量是：data[0...i)是已排好序的部分。
 */
public class InsertionSort {
    private InsertionSort() {
    }

    // 进行交换，交换位置需要进行三次操作，耗性能
    public static <E extends Comparable<E>> void sort(E[] data) {
        // 第一重循环，维持循环不变量data[0 ... i)中的元素都是已排好序的
        for (int i = 0; i < data.length; i++) {
            // 第二重循环，将data[i]中的元素插入到已排好序的正确位置
            for (int j = i; j > 0; j--) {
                // 每次后面的元素比前面的小，交换位置
                if (data[j].compareTo(data[j - 1]) < 0) {
                    Utils.swap(data, j, j - 1);
                }
            }
        }
    }

    // 基于移动赋值，由三次操作变为1次操作
    public static <E extends Comparable<E>> void sort2(E[] data) {
        // 第一重循环，维持循环不变量data[0 ... i)中的元素都是已排好序的
        for (int i = 0; i < data.length; i++) {
            // 第二重循环，将data[i]中的元素插入到已排好序的正确位置，不是合适的位置的元素，都往后挪一个索引
            E t = data[i]; // 待插入元素
            int j = i; // 待插入位置
            for (j = i; j - 1 >= 0 && t.compareTo(data[j - 1]) < 0; j--) {    // 该重循环的工作是寻找待插入的正确位置j
                data[j] = data[j - 1];
            }
            data[j] = t;
        }
    }

    // 换种思路，循环不变量为：data[0 ... i]为未排序，data(i ... data.length)已排序
    // 每次找到i在data(i ... data.length)中待插入位置
    public static <E extends Comparable<E>> void sort3(E[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            E t = data[i];
            int j;
            for (j = i; j + 1 < data.length && t.compareTo(data[j + 1]) > 0; j++) {
                data[j] = data[j + 1];
            }
            data[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomIntArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, n);
            SortTest.test("InsertionSort", arr);
            SortTest.test("InsertionSort2", arr2);
        }

        for (int n : dataSize) {
            Integer[] randomArr = ArrayGenerator.generateRandomIntArray(n, n);
            Integer[] randomArr2 = Arrays.copyOf(randomArr, n);
            SortTest.test("InsertionSort2", randomArr);
            SortTest.test("SelectionSort", randomArr2);


            Integer[] orderArr = ArrayGenerator.generateOrderIntArray(n);
            Integer[] orderArr2 = Arrays.copyOf(orderArr, n);
            SortTest.test("InsertionSort2", orderArr);
            SortTest.test("SelectionSort", orderArr2);
        }
    }
}
