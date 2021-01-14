package datastructure.linear.linkedlist;

public class LinkedList<E> {
    /**
     * 维护一个虚拟头节点，以使对首节点的操作和其他操作一致
     */
    private final Node dummyHead;
    private int size;

    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    public LinkedList() {
        dummyHead = new Node();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, invalid index.");
        }

        Node prevNode = dummyHead;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }

        prevNode.next = new Node(e, prevNode.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, invalid index.");
        }

        Node prevNode = dummyHead;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }

        Node deleteNode = prevNode.next;
        prevNode.next = deleteNode.next;
        deleteNode.next = null;
        size--;
        return deleteNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prevNode = dummyHead;
        while (prevNode.next != null) {
            if (prevNode.next.e.equals(e)) {
                Node deleteNode = prevNode.next;
                prevNode.next = deleteNode.next;
                deleteNode.next = null;
                size--;
            }
        }
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, invalid index.");
        }

        Node curNode = dummyHead;
        for (int i = 0; i <= index; i++) {
            curNode = dummyHead.next;
        }
        curNode.e = e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, invalid index.");
        }

        Node curNode = dummyHead;
        for (int i = 0; i <= index; i++) {
            curNode = dummyHead.next;
        }
        return curNode.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E e) {
        Node curNode = dummyHead.next;
        while (curNode != null) {
            if (curNode.e.equals(e)) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node curNode = dummyHead.next;
        while (curNode != null) {
            res.append(curNode.e).append(" -> ");
            curNode = curNode.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            list.addLast(i);
            System.out.println(list);
        }

        list.add(2, 666);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);
    }
}
