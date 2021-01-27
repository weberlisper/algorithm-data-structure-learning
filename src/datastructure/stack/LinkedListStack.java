package datastructure.stack;

import datastructure.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
    private final LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return "LinkedListStack: top[ " +
                list.toString() +
                "]";
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        for (int i = 0; i < 6; i++) {
            stack.pop();
            System.out.println(stack);
        }
    }
}
