import java.util.Arrays; // Sorting ke liye import zaroori hai

class Solution {
    public boolean containsDuplicate(int[] arr) {
        int n = arr.length;
        
        // Binary Search se pehle sort karna COMPULSORY hai
        Arrays.sort(arr); 
        
        for(int i = 0; i < n - 1; i++) {
            int target = arr[i];
            // Yahan hum i+1 se search shuru kar rahe hain
            if(binarysearch(arr, i + 1, n - 1, target)) {
                return true;
            }
        }
        return false;
    }

    // Return type 'boolean' hona chahiye
    public boolean binarysearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            // Formula correct kiya: yahan '+' aayega
            int mid = low + (high - low) / 2; 
            
            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}