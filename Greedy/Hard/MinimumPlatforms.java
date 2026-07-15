package Greedy.Hard;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800}, dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minPlatform(arr, dep));
    }
    public static int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1, maxPlatforms = 1;

        int i = 1; //for storing the index of current arrival train 
        int j = 0; //for storing the index of last departure train

        while(i<arr.length && j<dep.length) {
            if(arr[i]<=dep[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            }else{
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}
