package datastructure.heap;

import datastructure.array.Array;

public class MinHeap<E extends Comparable<E>> {

    private final Array<E> data;

    public MinHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MinHeap() {
        this.data = new Array<>();
    }

    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    public int size() {
        return data.getSize();
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 对数组中第k个元素进行上浮
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public E findMin() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("MinHeap is empty");
        }
        return data.get(0);
    }

    public E extractMin() {
        E ret = findMin();
        swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize()
                    && data.get(j).compareTo(data.get(j + 1)) > 0) {
                j++;
            }
            if (data.get(j).compareTo(data.get(k)) >= 0) {
                break;
            }
            swap(j, k);
            k = j;
        }
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private void swap(int i, int j) {
        E t = data.get(j);
        data.set(j, data.get(i));
        data.set(i, t);
    }
}
