package SlidingWindow_TwoPointers.MediumProblems;

public class NiceSubarrays {
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 2, 2, 1, 3, 1};
        System.out.println(numberOfSubarrays(nums, 1));
    }
    public static int numberOfSubarrays(int nums[], int k){
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public static int atMost(int nums[], int k){
        int count = 0; //to count the subarrays
        int left = 0, oddCount = 0;

        for(int right=0;right<nums.length;right++){
            if((nums[right]&1)==1) oddCount++;

            while(oddCount>k){
                if((nums[left++]&1)==1) oddCount--;
            }

            count += right-left+1;
        }

        return count;
    }
}
