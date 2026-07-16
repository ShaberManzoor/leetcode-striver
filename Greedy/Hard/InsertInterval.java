package Greedy.Hard;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int intervals[][] = {{1, 4}, {6, 9}};
        int newInterval[] = {3, 8};

        int newIntervals[][] = insert(intervals, newInterval);

        for(int interval[]: newIntervals) {   
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < n && intervals[i][1] < newInterval[0]){
	        res.add(intervals[i]);
	        i++;
	    }
	    
	    // merge all overlapping intervals to one considering newInterval
	    while (i < n && intervals[i][0] <= newInterval[1]) {
	    	// we could mutate newInterval here also
	        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
	        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
	        i++;
	    }
	    
	    // add the union of intervals we got
	    res.add(newInterval); 
	    
	    // add all the rest
	    while (i < n){
	    	res.add(intervals[i]); 
	    	i++;
	    }
	    
	    return res.toArray(new int[res.size()][]);
    }
}
