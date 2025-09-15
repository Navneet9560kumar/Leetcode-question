class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
     boolean[]broken = new boolean[26];
     for(char ch :brokenLetters.toCharArray()){
        broken[ch -'a'] =true;
     }   
     int result =0;
     boolean foundBroken =false;

     for(int i=0;i<text.length();i++){
        char ch = text.charAt(i);
        if(ch == ' '){
            if(!foundBroken){
                result++;
            }
            foundBroken = false;
        }else if(broken[ch -'a']){
            foundBroken =true;
        }
     }
     if(!foundBroken){
        result++;
     }
     return result;
    }
}