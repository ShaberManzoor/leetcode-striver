package BinarySearch.Answers;

public class TwoSortedArrayMedian {
    public static void main(String[] args) {
        int a[] = {1,3,8,9,15}, b[] = {7,11,18,19,21,25};
        System.out.println(findMedianSortedArrays(a, b));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if(n1>n2) return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2; //total length
        int left = (n + 1)/2; // left part of the merged array
        int low = 0, high = n1;

        while(low<=high){
            int mid1 = (low + high)/2; //no. of elements from array 1 in left part
            int mid2 = left - mid1; //no. of elements from array 1 in left part

            int l1 = mid1 > 0 ? nums1[mid1-1] : Integer.MIN_VALUE; //last element from array 1 on left part
            int l2 = mid2 > 0 ? nums2[mid2-1] : Integer.MIN_VALUE; //last element from array 2 on left part
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE; //FIRST element from array 1 on right part
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE; //FIRST element from array 2 on right part

            if(l1<=r2 && l2<=r1){
                if(n%2==1) return (double) Math.max(l1, l2);
                return (double) (Math.max(l1, l2) + Math.min(r1, r2))/2;
            }else if(l1>r2){
                high = mid1 - 1;
            }else {
                low = mid1 + 1;
            }
        }

        return 0; //dummy
    }
}
