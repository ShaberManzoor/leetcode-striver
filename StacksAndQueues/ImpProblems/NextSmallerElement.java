package StacksAndQueues.ImpProblems;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int nums[] = {4, 8, 5, 2, 25};
        int smaller[] = nextSmallerElement(nums);
        for(int num: smaller){
            System.out.println(num);
        }
    }
    public static int[] nextSmallerElement(int nums[]){
        //we will use increasing monotonic stack
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]<=st.peek()) st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        return ans;
    }
}
