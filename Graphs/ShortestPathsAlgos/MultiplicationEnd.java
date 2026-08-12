package Graphs.ShortestPathsAlgos;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MultiplicationEnd {
    public static void main(String[] args) {
        int arr[] = {3, 4, 65};
        int st = 7, end = 175;

        System.out.println(minSteps(arr, st, end));
    }
    public static int minSteps(int[] arr, int start, int end) {
        if(start==end) return 0;

        int MOD = 1000;
        int[] dis = new int[MOD];
        Arrays.fill(dis, -1);
        dis[start] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int num: arr) {
                int next = (num * curr) % MOD;
                if (dis[next] == -1) {

                    dis[next] = dis[curr] + 1;

                    // We found the target
                    if (next == end) {
                        return dis[next];
                    }

                    q.offer(next);
                }
            }
        }
        
        return -1; //not possible
    }
}
