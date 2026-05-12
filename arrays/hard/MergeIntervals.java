package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int intervals[][] = {{1,3},{2,6},{8,1},{15,8}};
        int merge[][] = merge(intervals);

        for(int interval[]: merge){
            for(int num: interval){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        int temp[] = intervals[0];
        res.add(temp);

        for(int a[]: intervals){
            if(a[0]<=temp[1]){
                temp[1] = Math.max(a[1], temp[1]);
            }else{
                temp = a;
                res.add(temp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
