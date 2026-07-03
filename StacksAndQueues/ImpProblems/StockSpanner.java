package StacksAndQueues.ImpProblems;

import java.util.Stack;

public class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && price >= st.peek()[0]) { // If the current price is greater than stack peek.
            span += st.peek()[1];
            st.pop();
        }
        st.push(new int[] { price, span });
        return span;
    }
}
