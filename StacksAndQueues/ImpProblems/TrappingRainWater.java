package StacksAndQueues.ImpProblems;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trap(height));
    }

    // This is the most optimised one with T.C-> O(n) & S.C-> O(1)
    public static int trap(int height[]) {
        int water = 0;
        int l = 0, r = height.length - 1, lmax = 0, rmax = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                if (lmax <= height[l]) {
                    lmax = height[l];
                } else {
                    water += lmax - height[l];
                }
                l++;
            } else {
                if (rmax <= height[r]) {
                    rmax = height[r];
                } else {
                    water += rmax - height[r];
                }
                r--;
            }
        }

        return water;
    }

    // Using Stack
    public static int trapUsingStack(int height[]) {
        int n = height.length;
        int water = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int bottom = st.pop();

                if (st.isEmpty())
                    break;

                int left = st.peek();

                int width = i - left - 1;
                int boundedHeight = Math.min(height[left], height[i]) - height[bottom];

                water += width * boundedHeight;
            }

            st.push(i);
        }

        return water;
    }
}
