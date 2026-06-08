package BinarySearch.Answers;

public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {
        int a[] = {1,3,8,9,15}, b[] = {7,11,18,19,21,25};
        int k = 6;
        System.out.println(kthElement(a, b, k));
    }
    public static int kthElement(int a[], int b[], int k) {
        int n1 = a.length, n2 = b.length;
        if(n1>n2) return kthElement(b, a, k);

        int low = Math.max(0, k-n2), high = Math.min(n1, k);
        while(low<=high){
            int mid1 = low + (high-low)/2; //no. of elements from array1
            int mid2 = k - mid1; //no. of elements from array2

            int l1 = mid1>0 ? a[mid1-1] : Integer.MIN_VALUE; 
            int l2 = mid2>0 ? b[mid2-1] : Integer.MIN_VALUE; 
            int r1 = mid1<n1 ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2<n2 ? b[mid2] : Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                return Math.max(l1, l2);
            }else if(l1>r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }

        return -1; //invalid k
    }
}
