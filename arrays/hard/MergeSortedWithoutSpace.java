package arrays.hard;

public class MergeSortedWithoutSpace {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);

        // Print the merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1; //index of last element in nums1
        int j = n-1; //index of last element in nums2
        int k = m + n -1;

        while(i>0 && j>0){
            if(nums1[i]>=nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

        //filling with remaining elements in nums2
        while(j>0){
            nums1[k--] = nums2[j--];
        }
    }
}
