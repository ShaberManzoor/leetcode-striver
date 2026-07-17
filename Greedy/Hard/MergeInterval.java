package Greedy.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int intervals[][] = {{1, 4}, {5, 9}, {3, 11}};
        int mergeInt[][] = merge(intervals);

        for(int []interval: mergeInt){
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            // No overlap
            if (res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]) {
                res.add(interval);
            } else {
                // Merge
                res.get(res.size() - 1)[1] =
                        Math.max(res.get(res.size() - 1)[1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
