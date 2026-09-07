package DynammicProgramming.LongestIncreasingSubseq;

public class LISLength {
    class Memoization {
        Integer[][] memo;

        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            if(n==1) return 1;

            memo = new Integer[n][n+1];

            return solve(nums, 0, -1);
        }

        public int solve(int[] nums, int ind, int prevInd) {
            if(ind==nums.length) return 0;

            if(memo[ind][prevInd]!=null) return memo[ind][prevInd];

            // skip it
            int skip = solve(nums, ind+1, prevInd);

            // take it
            int take = 0;
            if(prevInd==-1 || nums[ind]>nums[prevInd]) take = 1 + solve(nums, ind+1, ind);

            return memo[ind][prevInd] = Math.max(take, skip);
        }
    }

    class Tabulation {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;

            int dp[] = new int[n]; //length of longest subsequence till index i
            int res = 1;

            for(int i=0;i<n;i++){
                dp[i] = 1;
                for(int j=0;j<i;j++) {
                    if(nums[j]<nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }
}
