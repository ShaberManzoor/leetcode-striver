package DynammicProgramming.OneD;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int prev1 = 1, prev2 = 1;

        for(int i=2;i<=n;i++) {
            int current = prev1 + prev2; //ways to reach the step i

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
