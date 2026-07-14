package Heaps.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

class Node {
    int i, j, sum;
    Node(int i, int j, int sum){
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}

public class MaxSumComb {
    public static void main(String[] args) {
        int a[] = {3, 2}, b[] = {1, 4};
        ArrayList<Integer> topKSum = topKSumPairs(a, b, 2);

        for(int sum: topKSum){
            System.out.println(sum + " ");
        }
    }

    public static ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        //sort both the arrays
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        //Think of it as matrix and as only the right most will product the max not its neighbours then
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.sum-x.sum);
        HashSet<String> visited = new HashSet<>(); //to keep the tract of indicies pair

        pq.offer(new Node(n-1, n-1, a[n-1] + b[n-1]));
        visited.add((n-1) + "," + (n-1));

        ArrayList<Integer> ans = new ArrayList<>();

        while(k-->0){
            Node curr = pq.poll();

            ans.add(curr.sum);

            int i = curr.i, j = curr.j;

            if(i-1>=0 && visited.add((i-1) + "," + j)) pq.offer(new Node(i-1, j, a[i-1] + b[j])); 
            if(j-1>=0 && visited.add(i + "," + (j-1))) pq.offer(new Node(i, j-1, a[i] + b[j-1])); 
        }

        return ans;
    }
}
