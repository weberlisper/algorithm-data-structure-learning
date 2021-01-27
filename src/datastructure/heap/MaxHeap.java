package datastructure.heap;

import datastructure.array.Array;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

    private final Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    public MaxHeap(E[] data) {
        this.data = new Array<>(data);
        for (int i = parent(this.data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.getSize();
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    private int parent(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Invalid index");
        }
        return (index - 1) / 2;
    }

    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("MaxHeap is empty.");
        }
        return data.get(0);
    }

    public E extractMax() {
        E res = findMax();
        swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return res;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize()
                    && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }

            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    private void swap(int i, int j) {
        E t = data.get(j);
        data.set(j, data.get(i));
        data.set(i, t);
    }

    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        Integer[] arr1 = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = random.nextInt(Integer.MAX_VALUE);
        }
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr1);

        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr2[i - 1] < arr2[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
    }
}
