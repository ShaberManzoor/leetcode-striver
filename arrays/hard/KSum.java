package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
    public static void main(String[] args) {
        int nums[] = {1,0,-1,0,-2,2};
        int target = 0;
        int k = 4;

        List<List<Integer>> kSums = kSum(nums, target, k);
        for(List<Integer> sum: kSums){
            System.out.println(sum);
        }
    }
    public static List<List<Integer>> kSum(int nums[], int target, int k){
        List<List<Integer>> kSums = kSumHelper(nums, target, k, 0);
        return kSums;
    }

    public static List<List<Integer>> kSumHelper(int nums[], int target, int k, int st){
        List<List<Integer>> ans = new ArrayList<>();

        //base case when k = 2 means 2 nums forming the target 
        if(k==2){
            int left = st, right = nums.length-1;
            while(left<right){
                int sum = nums[left] + nums[right];

                if(sum==target){
                    ans.add(Arrays.asList(nums[left], nums[right]));

                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;

                    left++; right--;
                }else if(sum<target){
                    left++;
                }else {
                    right--;
                }
            }
        }

        for(int i=st;i<nums.length-k-1;i++){
            if(i>st && nums[i]==nums[i-1]) continue;

            if(nums[i]*k>target) break;
            if(nums[i]*k<target) break;

            List<List<Integer>> sub = kSumHelper(nums, target-nums[i], k-1, i+1);

            for(List<Integer> list: sub){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.addAll(list);
                ans.add(temp);
            }
        }

        return ans;
    }
}
