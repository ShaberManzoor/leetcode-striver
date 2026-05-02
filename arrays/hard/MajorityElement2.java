package arrays.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MajorityElement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt(); // length of array
            int nums[] = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = sc.nextInt();
            }

            List<Integer> majorityElements = majorityElement(nums);
            
            for(int elem: majorityElements){
                System.out.print(elem + " ");
            }

            System.out.println();
        }

        sc.close();
    }
    public static List<Integer> majorityElement(int[] nums) {
        int major1 = 0, major2 = 0, c1 = 0, c2 = 0;

        for(int num: nums){
            if(c1==0 && num!=major2){
                major1 = num;
                c1++;
            }else if(c2==0 && num!=major1){
                major2 = num;
                c2++;
            }else if(num==major1){
                c1++;
            }else if(num==major2){
                c2++;
            }else{
                c1--;c2--;
            }
        }

        c1 = c2 = 0;
        for(int num: nums){
            if(num==major1) c1++;
            else if(num==major2) c2++;
        }

        int occur = (nums.length)/3;
        List<Integer> res = new ArrayList<>();

        if(c1>occur) res.add(major1);
        if(c2>occur) res.add(major2);

        return res;
    }
}