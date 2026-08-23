package DynammicProgramming.Subsequence;

public class SubsetPartitionSum {
    class Solution {
        Boolean memo[][];

        public boolean canPartition(int[] nums) {
            int n = nums.length;

            int sum = 0;
            for(int num:nums) {
                sum += num;
            }

            //odd sum can't be possible to split in two
            if((sum&1)==1) return false;

            int tar = sum/2;
            memo = new Boolean[n][tar + 1];

            return solve(n-1, tar, nums);
        }

        public boolean solve(int i, int tar, int[] nums) {
            if(tar==0) return true;

            if(i==0) return nums[0]==tar;

            if(memo[i][tar]!=null) return memo[i][tar];

            boolean skip = solve(i-1, tar, nums);
            boolean take = nums[i]<=tar ? solve(i-1, tar-nums[i], nums) : false;

            return memo[i][tar] = skip || take;
        }
    }
}
