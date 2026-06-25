package StacksAndQueues.ImpProblems;

import java.util.Stack;

public class SubarrayMinSum {
    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;

        int nse[] = new int[n]; //next smaller element
        int pse[] = new int[n]; //previous smaller element
        Stack<Integer> st = new Stack<>();

        //finding previous smaller for each index
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        
        //finding next smaller for each index
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long res = 0;
        for(int i=0;i<n;i++){
            int left = i - pse[i];
            int right = nse[i] - i;

            res = (res + (long) arr[i] * left * right) % mod;
        }

        return (int) res;
    }
}
