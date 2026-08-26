package DynammicProgramming.Subsequence;

public class SubsetWithDiff {
    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;

        int total = 0;
        for (int num : arr) {
            total += num;
        }

        // s1-s2 = diff;
        // s1+s2 = total;
        // 2s1 = total+diff => s1 = (total + diff) / 2;

        // Impossible cases
        if (total < diff || (total - diff) % 2 != 0) {
            return 0;
        }

        int target = (total + diff) / 2;

        int[][] dp = new int[n][target + 1];

        // Base case
        if (arr[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;

            if (arr[0] <= target) {
                dp[0][arr[0]] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int sum = 0; sum <= target; sum++) {

                // Don't take arr[i]
                int skip = dp[i - 1][sum];

                // Take arr[i]
                int take = 0;

                if (arr[i] <= sum) {
                    take = dp[i - 1][sum - arr[i]];
                }

                dp[i][sum] = skip + take;
            }
        }

        return dp[n - 1][target];
    }
}
