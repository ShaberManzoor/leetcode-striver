package DynammicProgramming.OneD;

public class HouseRobber2 {
    public static int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        int includeFirst = solve(nums, 0, n-2);
        int excludeFirst = solve(nums, 1, n-1);

        return Math.max(includeFirst, excludeFirst);
    }

    private static int solve(int nums[], int start, int end){
        int prev1 = 0, prev2 = 0;
        // prev1-> not robbing current house
        // prev2-> robbing current house

        for(int i=start;i<=end;i++){
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr; 
        }

        return prev1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1};
        System.out.println(rob(nums));
    }
}
