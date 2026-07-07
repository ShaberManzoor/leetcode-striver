package SlidingWindow_TwoPointers.HardProblems;

import java.util.HashMap;
import java.util.Map;

public class GoodArrays {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
    public int atMost(int nums[], int k){
        int count = 0; //counting subarrays with atmost k different integers
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, right = 0;

        while(right<nums.length){
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            
            while(freq.size()>k) {
                freq.put(nums[left], freq.get(nums[left])-1);

                if(freq.get(nums[left])==0) freq.remove(nums[left]);

                left++;
            }

            count += (right - left + 1);
            right++;
        }

        return count;
    }
}
