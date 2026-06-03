package BinarySearch.Answers;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 8;
        int sqrt = findSqrt(n);
        System.out.println(sqrt);
    }

    public static int findSqrt(int n) {
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sqr = (long) mid * mid;

            if (sqr <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}
