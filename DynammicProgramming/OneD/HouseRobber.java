package DynammicProgramming.OneD;

import java.util.*;

public class HouseRobber {
    static class Memoization {
        int memo[];

        public int rob(int[] nums) {
            int n = nums.length;
            memo = new int[n];
            Arrays.fill(memo, -1);

            return solve(n-1, nums);
        }

        public int solve(int ind, int[] nums) {
            if(ind==0) return memo[0] = nums[0];
            if(ind==1) return memo[1] = Math.max(nums[0], nums[1]);

            if(memo[ind]!=-1) return memo[ind];

            //rob current house
            int rob = nums[ind] + solve(ind-2, nums);
            int notRob = solve(ind-1, nums);

            return memo[ind] = Math.max(rob, notRob);
        }
    }

    static class Tabulation {
        public int rob(int[] nums) {
            int n = nums.length;

            //only one house to rob
            if(n==1) return nums[0];
            if(n==2) return Math.max(nums[0], nums[1]);

            int dp[] = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for(int i=2;i<n;i++) {
                int rob = nums[i] + dp[i-2];
                int notRob = dp[i-1];

                dp[i] = Math.max(rob, notRob);
            }

            return dp[n-1];
        }
    }
    public static void main(String[] args) {
        int nums[] = {2, 7, 9, 3, 1};

        Memoization memo = new Memoization();
        System.out.println(memo.rob(nums));

        Tabulation tab = new Tabulation();
        System.out.println(tab.rob(nums));
    }
}
