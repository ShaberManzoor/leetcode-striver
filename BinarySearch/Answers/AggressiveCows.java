package BinarySearch.Answers;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int stalls[] = {2, 12, 11, 3, 26, 7};
        int k = 5;
        System.out.println(aggressiveCows(stalls, k));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);

        int low = 1, high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int minDis = low + (high - low) / 2;
            if (ableToAssign(stalls, k, minDis)) {
                low = minDis + 1;
            } else {
                high = minDis - 1;
            }
        }

        return high;
    }

    static boolean ableToAssign(int[] stalls, int k, int minDis) {
        int cowsPlaced = 1;
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= minDis) {
                cowsPlaced++;
                last = stalls[i];

                if (cowsPlaced >= k) {
                    return true;
                }
            }
        }

        return false;
    }
}
