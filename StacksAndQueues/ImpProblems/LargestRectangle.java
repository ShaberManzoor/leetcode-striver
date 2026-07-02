package StacksAndQueues.ImpProblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangle {
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }   

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==1) return heights[0];

        int maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] > currHeight) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}
