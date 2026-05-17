package binarySearch.OneDArray;

public class FloorAndCeil {
    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int floorVal = findFloor(arr, 5);
        int ceilVal = findCeil(arr, 20);

        System.out.println("Floor-" + floorVal);
        System.out.println("Ceil-" + ceilVal);
    }

    //this is done using lower bound
    static int findFloor(int arr[], int x){
        int low = 0, high = arr.length-1, ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]<=x){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    //done using upper bound
    static int findCeil(int arr[], int x){
        int low = 0, high = arr.length-1, ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
}
