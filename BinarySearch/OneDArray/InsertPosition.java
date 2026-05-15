package BinarySearch.OneDArray;

public class InsertPosition {
    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
        System.out.println(searchInsert(nums, 7));
    }
    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while(low<high){
            int mid = low + (high - low)/2;
            if(nums[mid]>target){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return low;
    }
}
