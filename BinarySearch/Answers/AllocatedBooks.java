package BinarySearch.Answers;

import java.util.Arrays;

public class AllocatedBooks {
    public static void main(String[] args) {
        int a[] = {25, 46, 28, 49, 24};
        int k = 4;
        System.out.println(findPages(a, k));
    }
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k>n) return -1;

        int min = 0, max = 0;
        for(int pages: arr){
            min = Math.max(pages, min);
            max += pages;
        }

        while(min<=max){
            int pages = min + (max - min)/2;
            if(canAllocate(arr, k, pages)){
                max = pages - 1;
            }else{
                min = pages + 1;
            }
        }

        return min;
    }

    //to check whether we can allocate the books to each students with the max page assign to the student be pages
    static boolean canAllocate(int a[], int k, int maxPages){
        int stds = 1;
        int pages = 0;
        for(int page: a){
            if(page + pages <= maxPages){
                pages += page;
            }else{
                stds++;
                pages = page;

                if(stds>k) return false;
            }
        }

        return true;
    }
}
