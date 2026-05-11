package arrays.hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class XorSubarrays {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 8, 3, 10));
        int x = 8;
        
        int xorCounts = subarraysXor(arr, x);
        System.out.println(xorCounts);
    }
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
        int counts = 0, xor = 0;
        
        Map<Integer, Integer> xorFreq = new HashMap<>();
        xorFreq.put(0, 1); //base case

        for(int num: arr){
            xor ^= num;

            int req = xor ^ x;
            counts += xorFreq.getOrDefault(req, 0);

            xorFreq.put(xor, xorFreq.getOrDefault(xorFreq, 0) + 1);
        }
        return counts;
	}
}
