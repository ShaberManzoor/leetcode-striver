package BinarySearch.OneDArray;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 1));
    }
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1, ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid]==target){
                ans = mid;
                break;
            }else if(nums[mid]>=nums[low]){
                if(nums[mid]>target && nums[low]<=target){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else{
                if(nums[mid]<target && nums[high]>=target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return ans;
    }
}
