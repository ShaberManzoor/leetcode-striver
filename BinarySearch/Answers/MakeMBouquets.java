package BinarySearch.Answers;

public class MakeMBouquets {
    public static void main(String[] args) {
        int bloomDay[] = {1,10,3,10,2};
        int min = minDays(bloomDay, 3, 1);
        System.out.println(min);
    }

    static public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int low = 1, high = 0;
        for (int days : bloomDay) {
            high = Math.max(days, high);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ableToMakeBouq(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    static boolean ableToMakeBouq(int bloomDay[], int m, int k, int days) {
        int adj = 0, bouq = 0;
        for (int day : bloomDay) {
            if (day <= days) {
                adj++;
            } else {
                adj = 0;
            }
            if (adj == k) {
                bouq++;
                adj = 0;
            }
        }

        return bouq >= m;
    }
}
