package Greedy.Hard;

import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {
        int bt[] = {4, 2, 1, 7, 3};

        System.out.println(waitingTime(bt));
    }
    public static int waitingTime(int bt[]) {
        int n = bt.length;
        long totalTime = 0;
        long time = 0; //time to get this job done

        Arrays.sort(bt);

        for(int i=1;i<n;i++) {
            time += bt[i-1];
            totalTime += time;
        }

        return (int) totalTime/n;
    }
}
