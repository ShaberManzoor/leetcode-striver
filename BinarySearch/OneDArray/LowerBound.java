package BinarySearch.OneDArray;

public class LowerBound {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 3, 5};
        int lowerBound = lowerBound(arr, arr.length, 2);
        System.out.println(lowerBound);
    }
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int low = 0, high = n-1, lowerIdx = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]>=x){
                lowerIdx = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return lowerIdx;
    }
}
