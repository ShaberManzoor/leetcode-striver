package DynammicProgramming.Subsequence;

public class TargetSum {
    Integer memo[][];

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total=0;
        for(int num: nums) total += num;

        //total should range from -total to +total
        if(Math.abs(target)>total) return 0;
        memo = new Integer[n][2*total+1];

        return solve(n-1, target, total, nums);
    }

    public int solve(int ind, int tar, int total, int nums[]) {
        if (tar < -total || tar > total) {
            return 0;
        }
        
        if(ind<0) return tar==0 ? 1 : 0;

        if(memo[ind][tar+total]!=null) return memo[ind][tar+total];

        int plus = solve(ind-1, tar-nums[ind], total, nums);
        int minus = solve(ind-1, tar+nums[ind], total, nums);

        return memo[ind][tar+total] = plus + minus;
    }
}
