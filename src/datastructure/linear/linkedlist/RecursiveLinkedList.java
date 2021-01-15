package datastructure.linear.linkedlist;

import com.sun.tools.javac.util.Pair;

public class RecursiveLinkedList<E> {

    private Node head = null;
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

        head = add(head, index, e);
        size++;
    }

    // 向链表中添加元素，并返回首节点
    private Node add(Node head, int index, E e) {
        // 最简单的情况，当index==0的时候，表示在表头插入
        if (index == 0) {
            return new Node(e, head);
        }

        // head指向子链表中添加完后的首节点
        head.next = add(head.next, index - 1, e);
        return head;
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

        Pair<Node, Node> head2del = remove(head, index);
        head = head2del.fst;
        size--;
        return head2del.snd.e;
    }

    private Pair<Node, Node> remove(Node head, int index) {
        // 最简单的情况，当index为0的时候，移除首元素
        if (index == 0) {
            Node delNode = head;
            head = head.next;
            delNode.next = null;
            return new Pair<>(head, delNode);
        }

        Pair<Node, Node> head2del = remove(head.next, index - 1);
        head.next = head2del.fst;
        return new Pair<>(head, head2del.snd);
    }


    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node curNode = head;
        while (curNode != null) {
            res.append(curNode.e).append(" -> ");
            curNode = curNode.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        RecursiveLinkedList<Integer> list = new RecursiveLinkedList<>();
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
