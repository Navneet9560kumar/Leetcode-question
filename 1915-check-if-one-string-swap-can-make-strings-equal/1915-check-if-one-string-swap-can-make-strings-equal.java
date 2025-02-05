class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int count=0;
        int freq[]=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        for(int i=0;i<s2.length();i++){
            freq[s2.charAt(i)-'a']--;
        }
        int freqcount=0;
        for(int i=0;i<26;i++){
            if (freq[i] != 0) {
                freqcount++;
            }
        }
        if(count==2 && freqcount==0){
            return true;
        }else{
            return false;
        }
    }
}