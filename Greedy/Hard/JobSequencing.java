package Greedy.Hard;

import java.util.ArrayList;
import java.util.Arrays;

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        int deadline[] = {2, 1, 2, 1, 1}, profit[] = {100, 19, 27, 25, 15};
        System.out.println(jobSequencing(deadline, profit));
    }
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(i + 1, deadline[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int slots[] = new int[n + 1];
        int maxProfit = 0, jobCounts = 0;
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                // it means at this slot job is not done
                if (slots[j] == 0) {
                    slots[j] = job.id;
                    maxProfit += job.profit;
                    jobCounts++;
                    break;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(jobCounts);
        ans.add(maxProfit);
        return ans;
    }
}
