package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int nums[] = {-1,0,-1,0,1,2,-1,-4};
        
        List<List<Integer>> threeSum = threeSum(nums); //three nums having sum 0
        for(List<Integer> threeNums: threeSum){
            for(int num: threeNums){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int nums[]){
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int j = i+1, k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    //now removing the same duplicates
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;

                    j++;k--;
                }else if(sum>0){
                    k--;
                }else {
                    j++;
                }
            }
        }

        return res;
    }
}
