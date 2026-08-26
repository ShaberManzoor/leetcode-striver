package DynammicProgramming.Subsequence;

public class CountSubsetWithSum {
    class Memoization {
        // no of subsets that can form the subset equals target from 0...i
        static Integer memo[][];
        
        static int perfectSum(int[] arr, int target) {
            int n = arr.length;
            memo = new Integer[n][target+1];
            
            return solve(n-1, target, arr);
        }
        
        static int solve(int i, int tar, int arr[]) {
            //base case
            if(i==0) {
                if(tar==0 && arr[0]==0) return 2; // include {}, {0}
                if(tar==0 || arr[0]==tar) return 1;
                return 0;
            }
            
            if(memo[i][tar]!=null) return memo[i][tar];
            
            int skip = solve(i-1, tar, arr);
            int take = arr[i]<=tar ? solve(i-1, tar-arr[i], arr) : 0;
            
            return memo[i][tar] = skip + take;
        }
    }

    class Tabulation {
        static int perfectSum(int[] arr, int target) {
            int n = arr.length;
            
            //count of subsets we can form with the 0..i index elements
            int dp[][] = new int[n][target+1];
            
            //we can form the target 0 by selecting 0 element from the arr 
            if(arr[0]==0) dp[0][0] = 2;
            else {
                dp[0][0] = 1;
                if(arr[0]<=target) dp[0][arr[0]] = 1;
            }
            
            for(int i=1;i<n;i++) {
                for(int tar=0;tar<=target;tar++) {
                    int take = arr[i]<=tar ? dp[i-1][tar-arr[i]] : 0;
                    int skip = dp[i-1][tar];
                    
                    dp[i][tar] = take + skip;
                }
            }
            
            return dp[n-1][target];
        }
    }
}
