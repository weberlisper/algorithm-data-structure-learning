package datastructure.linear.queue;

public interface Queue<E> {

    int size();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
