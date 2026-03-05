class Solution {
    public int maxVowels(String s, int k) {

        int l = 0, r = 0, count = 0, max = 0;

        while(r < s.length()){

            if(isVowel(s.charAt(r)))
                count++;

            while(r - l + 1 > k){
                if(isVowel(s.charAt(l)))
                    count--;
                l++;
            }

            if(r - l + 1 == k)
                max = Math.max(max, count);

            r++;
        }

        return max;
    }

    boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}