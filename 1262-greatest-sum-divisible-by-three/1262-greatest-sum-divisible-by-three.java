class Solution {
    public int maxSumDivThree(int[] nums) {

        // INF ek bahut bada number hai, jisse hum "infinity" maan rahe hain
        final int INF = 1000000001; 

        // a1: remainder 1 wale numbers me sabse chhota
        // a2: remainder 1 wale numbers me second sabse chhota
        int a1 = INF, a2 = INF;
        
        // b1: remainder 2 wale numbers me sabse chhota
        // b2: remainder 2 wale numbers me second sabse chhota
        int b1 = INF, b2 = INF;
        
        int sum = 0;

        for (int x : nums) {
            sum += x;  // sum me value add kar rahe hain
            
            if (x % 3 == 1) {
                // remainder 1 wale numbers me a1 aur a2 ko update karna hai
                if (x < a1) {
                    a2 = a1;
                    a1 = x;
                } else if (x < a2) {
                    a2 = x;
                }
            } else if (x % 3 == 2) {
                // remainder 2 wale numbers me b1 aur b2 update karna
                if (x < b1) {
                    b2 = b1;
                    b1 = x;
                } else if (x < b2) {
                    b2 = x;
                }
            }
        }

        int remainder = sum % 3;

        if (remainder == 0) {
            // Agar sum already 3 se divisible hai, to sum return kar do
            return sum;
        } 
        else if (remainder == 1) {
            // sum % 3 == 1 matlab ek remainder 1 hataana padega

            // Option 1: sabse chhota remainder 1 wala number hata do
            int option1 = a1;

            // Option 2: remainder 2 ke do numbers (b1 + b2) hata do 
            // (kyunki 2 + 2 = 4, and 4 % 3 = 1)
            int option2 = b1 + b2;
            
            // Dono me se jiski cost kam ho wo hata do
            return sum - Math.min(option1, option2);
        } 
        else { 
            // remainder == 2 matlab ek remainder 2 hataana padega

            // Option 1: sabse chhota remainder 2 wala number hata do
            int option1 = b1;

            // Option 2: remainder 1 ke do numbers hata do (a1 + a2)
            // (kyunki 1 + 1 = 2, and 2 % 3 = 2)
            int option2 = a1 + a2;

            // Jiski cost kam ho use hata do
            return sum - Math.min(option1, option2);
        }
    }
}
