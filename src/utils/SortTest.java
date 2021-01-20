package utils;

import algorithm.sort.*;

public class SortTest {
    private SortTest() {
    }

    private static <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i].compareTo(data[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void test(String sortName, E[] data) {
        long startTime = System.currentTimeMillis();
        switch (sortName) {
            case "SelectionSort":
                SelectionSort.sort(data);
                break;
            case "InsertionSort":
                InsertionSort.sort(data);
                break;
            case "InsertionSort2":
                InsertionSort.sort2(data);
                break;
            case "InsertionSort3":
                InsertionSort.sort3(data);
                break;
            case "MergeSort":
                MergeSort.sort(data);
                break;
            case "MergeSortBU":
                MergeSortBU.sort(data);
                break;
            case "QuickSort":
                QuickSort.sort(data);
                break;
            case "QuickSort2Ways":
                QuickSort.sort2ways(data);
                break;
            case "QuickSort3Ways":
                QuickSort.sort3ways(data);
                break;
        }
        long costTime = System.currentTimeMillis() - startTime;
        if (!isSorted(data)) {
            throw new RuntimeException(sortName + " algorithm.sort failed");
        }
        System.out.println(String.format("%s: n = %d, costTime: %fS", sortName, data.length, costTime / 1000.0f));
    }

}
