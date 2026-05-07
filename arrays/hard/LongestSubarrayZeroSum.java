package arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LongestSubarrayZeroSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            int longestZeroSumSubarray = LongestSubsetWithZeroSum(arr);
            System.out.println(longestZeroSumSubarray);
        }

        sc.close();
    }

    public static int LongestSubsetWithZeroSum(List<Integer> numbers) {

        int maxLength = 0;
        int prefixSum = 0;

        Map<Integer, Integer> prefixSumToIndex = new HashMap<>();

        for (int index = 0; index < numbers.size(); index++) {

            prefixSum += numbers.get(index);

            if (prefixSum == 0) {
                maxLength = index + 1;
            } else if (prefixSumToIndex.containsKey(prefixSum)) {

                maxLength = Math.max(
                        maxLength,
                        index - prefixSumToIndex.get(prefixSum));

            } else {
                prefixSumToIndex.put(prefixSum, index);
            }
        }

        return maxLength;
    }
}
