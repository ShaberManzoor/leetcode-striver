package Greedy.Hard;

import java.util.Arrays;

public class EraseNonOverlapping {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int overlaps = 0;
        int j = 0; //index of last interval

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[j][1]) {
                overlaps++;
            } else {
                j = i;  
            }
        }

        return overlaps;
    }
}
