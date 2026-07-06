package SlidingWindow_TwoPointers.MediumProblems;

public class SumSubarrays {
    public static void main(String[] args) {
        int nums[] = {0,0,0,0,0};
        System.out.println(numSubarraysWithSum(nums, 0));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public static int atMost(int nums[], int goal) {
        if(goal<0) return 0;

        int count = 0; //counts of subarrays with sum at most goal
        int left = 0, sum = 0;

        for(int right = 0;right<nums.length;right++){
            sum += nums[right];

            while(sum>goal) sum -= nums[left++];

            count += right - left + 1;
        }

        return count;
    }
}
