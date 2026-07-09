package Heaps.Medium;

public class KthLargestQuickSelect {
    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};
        System.out.println(kthLargest(nums, 4));
    }

    public static int kthLargest(int nums[], int k) {
        int left = 0, right = nums.length-1;
        int targetInd = nums.length-k;

        while(left<=right){
            int pivotInd = partition(nums, left, right);

            if(pivotInd==targetInd){
                return nums[pivotInd];
            }else if(pivotInd<targetInd){
                left = pivotInd + 1;
            }else{
                right = pivotInd - 1;
            }
        }

        return -1;
    }

    public static int partition(int nums[], int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                // swapping elements at i & j
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
