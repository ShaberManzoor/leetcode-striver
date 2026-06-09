package BinarySearch.TwoDArray;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };

        System.out.println(median(matrix));
    }
    public static int median(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int mat[]: matrix){
            min = Math.min(min, mat[0]);
            max = Math.max(max, mat[n-1]);
        }

        int req = (m*n)/2; //count required to be greater than elements to be median
        while(min<=max){
            int mid = min + (max-min)/2;

            int count = 0;
            for(int i=0;i<m;i++){
                count += countLess(matrix[i], mid);
            }

            if(count<=req){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }

        return min;
    }

    //to find the number of elements in array less than the tar
    static int countLess(int arr[], int tar){
        int low = 0, high = arr.length-1;
        int ans = arr.length;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]>tar){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
