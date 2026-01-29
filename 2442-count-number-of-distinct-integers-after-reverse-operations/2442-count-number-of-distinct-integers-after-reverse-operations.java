class Solution {
   public int countDistinctIntegers(int[] arr){
HashSet<Integer> set = new HashSet<>();
for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
      set.add(reverse(arr[i]));
}
return set.size();
      }

      public int reverse(int num){
            int rev =0;
            while(num!=0){
                  int digit = num %10;
                  rev = rev *10 + digit;
                  num = num /10;
            }
            return rev;
      }
}