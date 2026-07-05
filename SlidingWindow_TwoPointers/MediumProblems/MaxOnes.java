package SlidingWindow_TwoPointers.MediumProblems;

public class MaxOnes {
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};

        System.out.println(longestOnes(nums, 0));
    }
    public static int longestOnes(int[] nums, int k) {
        int maxLen = 0, left = 0, right = 0, zeros = 0;

        while(right<nums.length){
            if(nums[right]==0) zeros++;

            while(zeros>k){
                if(nums[left]==0) zeros--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }
}
