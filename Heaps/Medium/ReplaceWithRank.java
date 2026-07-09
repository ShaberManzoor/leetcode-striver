package Heaps.Medium;

import java.util.PriorityQueue;

public class ReplaceWithRank {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1};
        replaceWithRank(arr);

        for(int num: arr) System.out.print(num + " ");
    }
    public static void replaceWithRank(int arr[]) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] == b[1]
                    ? Integer.compare(a[0], b[0])
                    : Integer.compare(a[1], b[1])
        ); // store in pair of (ind, val)

        for(int i=0;i<arr.length;i++){
            pq.offer(new int[]{i, arr[i]});
        }

        for(int i=0;i<arr.length;i++){
            int ind = pq.poll()[0];

            arr[ind] = i;
        }
    }
}
