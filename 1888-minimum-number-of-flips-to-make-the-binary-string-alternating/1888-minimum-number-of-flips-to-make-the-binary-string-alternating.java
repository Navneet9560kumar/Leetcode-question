class Solution {
    public int minFlips(String s) {
         int n = s.length();
         s= s+s;
            
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(int i=0;i<2*n;i++){
            s1.append(i%2==1 ? '0' : '1');
              s2.append(i % 2 == 1 ? '1' : '0');
        }
        int i=0, j=0;

        int res1 = 0, res2=0;
       int result = Integer.MAX_VALUE;

        while(j<2*n){
              // expand window
            if(s.charAt(j) != s1.charAt(j)) res1++;
            if(s.charAt(j) != s2.charAt(j)) res2++;
        
           // shrink window
            if(j - i + 1 > n) {
                if(s.charAt(i) != s1.charAt(i)) res1--;
                if(s.charAt(i) != s2.charAt(i)) res2--;
                i++;
            }
             // window size n
            if(j - i + 1 == n)
                result = Math.min(result, Math.min(res1, res2));

            j++;
        }
             return result;
    }
}