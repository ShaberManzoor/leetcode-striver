package DynammicProgramming.Subsequence;

public class SubsetSum {
    static class Memoization {
        //memo array to store can we make the target using the elements upto i
        Boolean[][] memo;
        
        boolean isSubsetSum(int arr[], int sum) {
            int n = arr.length;
            
            memo = new Boolean[n][sum+1];
            return solve(n-1, sum, arr);
        }
        
        boolean solve(int i, int tar, int[] arr) {
            if(tar==0) return true;
            
            //base case
            if(i==0) return arr[0]==tar;
            
            if(memo[i][tar]!=null) return memo[i][tar];
            
            boolean skip = solve(i-1, tar, arr);
            boolean take = tar>=arr[i] ? solve(i-1, tar-arr[i], arr) : false;
            
            return memo[i][tar] = skip || take;
        }
    }

    static class Tabulation {
        boolean isSubsetSum(int arr[], int sum) {
            int n = arr.length;
            
            //can we form sum using the elements till i index
            boolean[][] dp = new boolean[n][sum+1];
            
            //empty subset can form the sum 0
            for(int i=0;i<n;i++) {
                dp[i][0] = true;
            }
            
            //base case if arr[0]<=sum 
            if(arr[0]<=sum) dp[0][arr[0]] = true;
            
            for(int i=1;i<n;i++) {
                for(int tar=1;tar<=sum;tar++) {
                    boolean skip = dp[i-1][tar];
                    boolean take = arr[i]<=tar ? dp[i-1][tar-arr[i]] : false;
                    
                    dp[i][tar] = skip || take;
                }
            }
            
            return dp[n-1][sum];
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 8, 4, 5};
        Memoization memo = new Memoization();
        System.out.println("Memoization- " + memo.isSubsetSum(arr, 7));

        Tabulation tab = new Tabulation();
        System.out.println("Tabulation- " + tab.isSubsetSum(arr, 7));
    }
}
