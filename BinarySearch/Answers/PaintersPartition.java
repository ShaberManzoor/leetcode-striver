package BinarySearch.Answers;

public class PaintersPartition {
    public static void main(String[] args) {
        int arr[] = {5, 10, 30, 20, 15};
        int k = 3;
        System.out.println(minTime(arr, k));
    }
    public static int minTime(int arr[], int k){
        int low = 0, high = 0;
        for(int time: arr){
            low = Math.max(low, time);
            high += time;
        }

        if(k==arr.length) return low;

        while(low<=high){
            int minTime = low + (high-low)/2;
            if(canPaintInTime(arr, k, minTime)){
                high = minTime - 1;
            }else{
                low = minTime + 1;
            }
        }

        return low;
    }

    // will k painters able to paint all the boards in maxTime
    public static boolean canPaintInTime(int a[], int k, int maxTime){
        int painters = 1;
        int time = 0;

        for(int t: a){
            if(time + t <= maxTime){
                time += t;
            }else{
                painters++;
                time = t;

                if(painters>k) return false;
            }
        }

        return true;
    }
}
