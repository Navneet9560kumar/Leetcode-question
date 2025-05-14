class Solution {
    public double myPow(double x, int n) {
    
    //  double result = Math.pow(x, n);
    //     return result;

    // without math.pow;
 long exp = n;
         if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

          double result = 1.0;
     while (exp > 0) {
            if (exp % 2 == 1) {
                result *= x;
            }
            x *= x;
            exp /= 2;
        }

        return result;
    }
}