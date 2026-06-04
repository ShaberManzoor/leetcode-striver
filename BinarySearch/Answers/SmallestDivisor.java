package BinarySearch.Answers;

public class SmallestDivisor {
    public static void main(String[] args) {
        int nums[] = {44,22,33,11,1};
        System.out.println(smallestDivisor(nums, 5));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for(int num: nums){
            high = Math.max(high, num);
        }

        if(nums.length==threshold) return high;

        while(low<high){
            int divisor = low + (high - low)/2;
            int sum = 0;
            for(int num: nums){
                sum += (num + divisor-1)/divisor;
            }

            if(sum<=threshold){
                high = divisor;
            }else{
                low = divisor + 1;
            }
        }

        return high;
    }
}
