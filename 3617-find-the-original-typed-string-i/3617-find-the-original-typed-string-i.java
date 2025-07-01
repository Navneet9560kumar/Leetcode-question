class Solution {
    public int possibleStringCount(String arr) {
        int n= arr.length();
        int count =0;
        for(int i=1;i<n;i++){
          if (arr.charAt(i) == arr.charAt(i - 1)){
                count++;
            }
        }
        return count+1;
    }
}