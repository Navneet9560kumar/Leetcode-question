class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
      int j=0;
        for(int i=0;i<str1.length() && j<str2.length();i++){
            char a=str1.charAt(i); // a b c
            char b=str2.charAt(j); //a d
            char c;// b c d
            if(a=='z'){
                c='a';
            }else{
                c=(char)(a+1);
            }
            if(a==b || c==b){
                j++;
            }
        }
        return j==str2.length();

    }
}