package Heaps.Medium;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {
        char tasks[] = {'A', 'B', 'A', 'B', 'C', 'A', 'B'};
        System.out.println(leastInterval(tasks, 2));
    }
    public static int leastInterval(char[] tasks, int n) {
        int freqs[] = new int[26]; //freq of each tasks
        int maxFreq = 0; //max freq of a task
        
        for(char ch: tasks){
            freqs[ch-'A']++;
            maxFreq = Math.max(maxFreq, freqs[ch-'A']);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); //To store the tasks based on the frequencies

        for(int freq: freqs){
            if(freq>0) maxHeap.offer(freq);
        }

        Queue<int[]> cooldown = new ArrayDeque<>(); //to store the cooldown period of task as {remainingFreq, availableTime};

        int time = 0;
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll(); //getting the most freq task
                count--; //using it & decreasing its count

                if(count>0){
                    cooldown.offer(new int[]{count, time + n});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1]==time){
                maxHeap.offer(cooldown.poll()[0]);
            }
        }


        return time;
    }
}
