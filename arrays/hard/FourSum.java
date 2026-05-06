package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int nums[] = {1,0,-1,0,-2,2};
        int tar = 0;

        List<List<Integer>> fourSums = fourSum(nums, tar);
        for(List<Integer> sum: fourSums){
            System.out.println(sum);
        }
    }
    public static List<List<Integer>> fourSum(int nums[], int target){
        int n = nums.length;
        Arrays.sort(nums);
        
        List<List<Integer>> sums = new ArrayList<>();
        for(int a=0;a<n-3;a++){
            if(a>0 && nums[a]==nums[a-1]) continue;

            for(int b=a+1;b<n-2;b++){
                if(b>a+1 && nums[b]==nums[b-1]) continue;

                int c = b+1, d = n-1;
                while(c<d){
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if(sum==target){
                        sums.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));

                        while(c<d && nums[c]==nums[c+1]) c++;
                        while(c<d && nums[d]==nums[d-1]) d--;

                        c++;d--;
                    }else if(sum<target){
                        c++;
                    }else{
                        d--;
                    }
                }
            }
        }
        return sums;
    }
}
