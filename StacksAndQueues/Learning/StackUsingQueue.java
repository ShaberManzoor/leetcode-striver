package StacksAndQueues.Learning;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> q;

    public StackUsingQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);

        int size = q.size();

        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
