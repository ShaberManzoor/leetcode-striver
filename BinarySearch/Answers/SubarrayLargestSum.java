package BinarySearch.Answers;

public class SubarrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for(int num: nums){
            low = Math.max(low, num);
            high += num;
        }

        if(k==nums.length) return low;

        while(low<=high){
            int maxSum = low + (high - low)/2;
            int splits = splitsWithSum(nums, maxSum); // no. of subarrays we can for such that the sum of each sub array dont exceed maxSum;
            if(splits>k){
                low = maxSum + 1;
            }else{
                high = maxSum - 1;
            }
        }

        return low;
    }

    int splitsWithSum(int nums[], int maxSum){
        int splits = 1;
        int sum = 0;
        for(int num: nums){
            if(sum + num <= maxSum){
                sum += num;
            }else{
                splits++;
                sum = num;
            }
        }

        return splits;
    }
}
