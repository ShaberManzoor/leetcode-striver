package Greedy.Hard;

public class JumpGame2 {
    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int nums[]) {
        int jumps = 0;
        int currEnd = 0; //farthest index we can reach with current number of jumps
        int farthest = 0; //farthest index we can in range

        for(int i=0;i<nums.length-1;i++){
            farthest = Math.max(farthest, i+nums[i]);

            if(i==currEnd) {
                jumps++;
                currEnd = farthest;

                if(currEnd>=nums.length-1) break;
            }
        }

        return jumps;
    }
}
