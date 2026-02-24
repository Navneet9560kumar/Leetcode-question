class Solution {
    public int balancedStringSplit(String s) {
        ArrayList<String>st =  new ArrayList<>();
         int countL = 0;
        int countR = 0;
        String temp = "";
         for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            temp += ch;

            if(ch == 'L') {
                countL++;
            } else {
                countR++;
            }

            if(countL == countR) {
                st.add(temp);   // balanced substring mil gaya
                temp = "";        // reset
                countL = 0;
                countR = 0;
            }
        }

        return st.size();
    }
}