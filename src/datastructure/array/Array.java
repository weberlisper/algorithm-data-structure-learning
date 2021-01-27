package datastructure.array;

public class Array<E> {

    // 维护的内部数组，实际存储数据的地方
    private E[] data;
    // 当前数据长度
    private int size;

    // capacity是数组的容量
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot null");
        }
        this.data = data;
        size = data.length;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalStateException("Add failed! Require index >=0 && index <= size");
        }

        if (size == data.length) {
            // 数组满时，扩容2倍
            resize(data.length * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalStateException("Add failed! Require index >=0 && index < size");
        }

        E removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length);
        }
        return removed;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalStateException("Set failed! Require index >=0 && index < size");
        }

        data[index] = e;
    }

    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        return find(e) != -1;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalStateException("Add failed! Require index >=0 && index < size");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size = %d, capacity = %d/n")).append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
