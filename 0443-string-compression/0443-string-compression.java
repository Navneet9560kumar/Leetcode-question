class Solution {
    public int compress(char[] arr) {
                      String ans = "";
        int i = 0, j = 0;
        
        while (j < arr.length) {
            if (arr[j] == arr[i]) {
                j++;
            } else {
                ans += arr[i];
                int len = j - i;
                if (len > 1) ans += len;
                i = j;
            }
        }
        
        ans += arr[i];
        int len = j - i;
        if (len > 1) ans += len;

        for (i = 0; i < ans.length(); i++) {
            arr[i] = ans.charAt(i);
        }
        
        return ans.length();
    }
}