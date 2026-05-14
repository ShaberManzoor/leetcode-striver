package arrays.hard;

public class ReversePairs {
    public static void main(String[] args) {
        int nums[] = {1,3,2,3,1};
        int reversePairsCounts = reversePairs(nums);
        System.out.println(reversePairsCounts);
    }
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public static int mergeSort(int nums[], int left, int right){
        if(left>=right) return 0;
        int mid = left + (right-left)/2;
        int counts = mergeSort(nums, left, mid) + mergeSort(nums, mid+1, right);
        
        //here we count how many element from left array are greater such that nums[i] > 2*nums[j]
        int j = mid + 1;  //start index of first element in right array
        for(int i=left;i<=mid;i++){
            while(j<=right && (long) nums[i]> 2L * nums[j]){
                j++;
            }

            counts += j - (mid + 1);
        }

        merge(nums, left, mid, right);
        return counts;
    }

    public static void merge(int nums[], int left, int mid, int right){
        int temp[] = new int[right-left+1];

        int i = left, j = mid+1, k = 0;

        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i<=mid) temp[k++] = nums[i++];
        while(j<=right) temp[k++] = nums[j++];

        // Correct copy back
        for (i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }
}
