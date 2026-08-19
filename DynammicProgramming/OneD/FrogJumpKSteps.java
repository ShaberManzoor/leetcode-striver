package DynammicProgramming.OneD;

import java.util.*;

//TOP DOWN
class Memoization {
    int dp[]; //minimum amount of energy required to reach the stair
    Memoization() {
    }

    public int frogJump(int k, int[] height) {
        int n = height.length;
        if(n==0 || n==1) return 0;

        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n-1, k, height);
    }

    public int solve(int stair, int k, int[] height) {
        if(stair==0) return dp[stair] = 0;
        if(stair==1) return dp[stair] = Math.abs(height[1]-height[0]);

        if(dp[stair]!=-1) return dp[stair];

        int minEnergy = Integer.MAX_VALUE;

        for(int i=1;i<k;i++) {
            if(stair-i>=0) {
                int energy = solve(stair-i, k, height) + Math.abs(height[stair]-height[stair-i]);
                minEnergy = Math.min(energy, minEnergy);
            }
        }

        return dp[stair] = minEnergy;
    }
}

//BOTTOM UP
class Tabulation {
    int dp[];

    public int frogJump(int k, int[] height) {
        int n = height.length;

        if(n<=1) return 0; //only one or less stair to climb

        dp = new int[n];
        for(int stair=1;stair<n;stair++) {

            int minEnergy = Integer.MAX_VALUE;
            for(int i=1;i<=k;i++) {
                if(stair-i<0) break;

                int energy = Math.abs(height[stair]-height[stair-i]) + dp[stair-i];
                minEnergy = Math.min(energy, minEnergy);
            }

            dp[stair] = minEnergy;
        }

        return dp[n-1];
    }
}

public class FrogJumpKSteps {
    public static void main(String[] args) {
        int k = 3;
        int[] height = {30, 10, 60, 10, 60, 50};

        Memoization memo = new Memoization();
        System.out.println("Memoization: " + memo.frogJump(k, height));

        Tabulation tab = new Tabulation();
        System.out.println("Tabulation: " + tab.frogJump(k, height));
    }
}
