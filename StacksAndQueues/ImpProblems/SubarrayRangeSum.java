package StacksAndQueues.ImpProblems;

import java.util.Stack;

public class SubarrayRangeSum {
    public static void main(String[] args) {
        int nums[] = { 4, -2, -3, 4, 1 };
        System.out.println(subArrayRanges(nums));
    }

    public static long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public static long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        long smallest = 0;

        st.push(0);
        for (int i = 1; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])) {
                int mid = st.pop();

                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                smallest += (long) arr[mid] * (mid - left) * (right - mid);
            }

            st.push(i);
        }

        return smallest;
    }

    public static long sumSubarrayMaxs(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        long greatest = 0;

        st.push(0);
        for (int i = 1; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[i] >= arr[st.peek()])) {
                int mid = st.pop();

                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                greatest += (long) arr[mid] * (mid - left) * (right - mid);
            }

            st.push(i);
        }

        return greatest;
    }
}
