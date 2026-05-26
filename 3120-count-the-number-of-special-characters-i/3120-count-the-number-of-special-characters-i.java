class Solution {
    public int numberOfSpecialChars(String arr) {
        int n= arr.length();
        int count =0;

        for(char c ='a'; c<='z';c++){
            boolean samll= false;
            boolean capital = false;

            for(int i=0;i<n;i++){
                if(arr.charAt(i)==c){
                    samll = true;
                }
                if(arr.charAt(i) == (char)(c-'a'+ 'A')){
                    capital =true;
                }
            }
            if(samll && capital){
                count++;
            }
        }
        return count;
    }
}