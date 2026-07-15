package Greedy.Hard;

public class JumpGame {
    public static void main(String[] args) {
        int nums[] = {4, 2, 0, 0, 1, 2};

        System.out.println(canJump(nums));
    }
    public static boolean canJump(int nums[]) {
        int farthest = 0; //farthest we can go 

        for(int i=0;i<nums.length;i++){
            if(i>farthest) return false; // not possible

            if(farthest<i+nums[i]){
                farthest = i + nums[i];
            }

            if(farthest>=nums.length-1) return true;
        }

        return true;
    }
}
