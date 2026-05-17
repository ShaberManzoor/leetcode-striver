package binarySearch.OneDArray;

public class FirstAndLastOccur {
    public static void main(String[] args) {
        int arr[] = {5,7,7,8,8,10};

        int firstAndLastOccur[] = new int[2];
        firstAndLastOccur[0] = findFirstOccur(arr, 8);
        firstAndLastOccur[1] = findLastOccur(arr, 8);
        
        for(int occur: firstAndLastOccur){
            System.out.println(occur);
        }
    }
    static int findFirstOccur(int arr[], int x){
        int low = 0,  high = arr.length-1, occur = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]==x){
                occur = mid;
                high = mid-1;
            }else if(arr[mid]>x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return occur;
    }
    static int findLastOccur(int arr[], int x){
        int low = 0,  high = arr.length-1, occur = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]==x){
                occur = mid;
                low = mid+1;
            }else if(arr[mid]>x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return occur;
    }
}
