package StacksAndQueues.ImpProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>=st.peek()) {
                st.pop();
            }

            if(st.isEmpty()){
                hm.put(nums2[i], -1);
            }else{
                hm.put(nums2[i], st.peek());
            }

            st.push(nums2[i]);
        }

        int ans[] = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            ans[i] = hm.get(nums1[i]);
        }

        return ans;
    }
}
