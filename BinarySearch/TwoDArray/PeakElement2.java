package BinarySearch.TwoDArray;

public class PeakElement2 {
    public static void main(String[] args) {
        int[][] mat = {
                { 10, 20, 15 },
                { 21, 30, 14 },
                { 7, 16, 32 }
        };

        int[] ans = findPeakGrid(mat);

        System.out.println("Peak at: (" + ans[0] + ", " + ans[1] + ")");
    }

    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // now searching for the row with max mid col value;
            int maxRow = 0;
            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid])
                    maxRow = i;
            }

            int left = (mid - 1) >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = (mid + 1) < n ? mat[maxRow][mid + 1] : -1;

            if (left < mat[maxRow][mid] && right < mat[maxRow][mid]) {
                return new int[] { maxRow, mid };
            } else if (left > mat[maxRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }
}
