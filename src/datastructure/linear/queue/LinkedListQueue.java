package datastructure.linear.queue;

import datastructure.linear.linkedlist.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {
    private Node head, tail;
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue in a empty queue.");
        }

        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot read in a empty queue.");
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue: front ");
        Node curNode = head;
        while (curNode != null) {
            res.append(curNode.e).append(" -> ");
            curNode = curNode.next;
        }
        res.append("tail NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if ((i + 1) % 3 == 0) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
