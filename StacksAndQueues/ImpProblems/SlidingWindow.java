package StacksAndQueues.ImpProblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        
        int maxWindow[] = maxSlidingWindow(nums, k);
        for(int max: maxWindow){
            System.out.print(max + " ");
        } 
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int res[] = new int[n-k+1];

        for(int i=0;i<n;i++){
            //removing the indexes not possible in the window
            while(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.pollFirst();

            //removing the smaller values which can never be maximum
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) dq.pollLast();

            //adding curr index
            dq.offerLast(i);

            //adding result after the window
            if(i>=k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }    
        
        return res;
    }
}
