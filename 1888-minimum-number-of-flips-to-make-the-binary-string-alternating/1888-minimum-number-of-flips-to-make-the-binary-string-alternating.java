class Solution {
    public int minFlips(String s) {

        int n = s.length();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(int i = 0; i < 2*n; i++) {
            s1.append(i % 2 == 1 ? '0' : '1');
            s2.append(i % 2 == 1 ? '1' : '0');
        }

        int i = 0, j = 0;
        int result1 = 0, result2 = 0;
        int result = Integer.MAX_VALUE;

        while(j < 2*n) {

            // expand window
            if(s.charAt(j % n) != s1.charAt(j)) result1++;
            if(s.charAt(j % n) != s2.charAt(j)) result2++;

            // shrink window
            if(j - i + 1 > n) {
                if(s.charAt(i % n) != s1.charAt(i)) result1--;
                if(s.charAt(i % n) != s2.charAt(i)) result2--;
                i++;
            }

            if(j - i + 1 == n)
                result = Math.min(result, Math.min(result1, result2));

            j++;
        }

        return result;
    }
}
