package leetcode.implementation_stack_using_queue;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    private final Queue<Integer> queue1 = new ArrayDeque<>();
    private final Queue<Integer> queue2 = new ArrayDeque<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!queue2.isEmpty()) {
            queue2.add(x);
            return;
        }
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }
        if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }
        return queue1.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int ret = 0;
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                ret = queue1.remove();
                queue2.add(ret);
            }
            return ret;
        }
        if (!queue2.isEmpty()) {
            while (!queue2.isEmpty()) {
                ret = queue2.remove();
                queue1.add(ret);
            }
            return ret;
        }
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
