package DynammicProgramming.OneD;

public class FrogJump {
    public static void main(String args[]) {
        int height[] = {30, 20, 50, 10, 40};
        System.out.println(minCost(height));
    }
    public static int minCost(int[] height) {
        // code here
        int n = height.length;
        
        if(n<2) return 0;
        
        int cost1 = Math.abs(height[1]-height[0]), cost2 = 0;
        for(int stair=2;stair<n;stair++) {
            int currCost1 = Math.abs(height[stair]-height[stair-2]) + cost2;
            int currCost2 = Math.abs(height[stair]-height[stair-1]) + cost1;
            
            int currCost = Math.min(currCost1, currCost2);
            cost2 = cost1;
            cost1 = currCost;
        }
        
        return cost1;
    }
}
